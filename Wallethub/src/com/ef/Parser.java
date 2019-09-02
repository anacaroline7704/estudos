package com.ef;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class Parser {

	private static final DateTimeFormatter LOG_FILE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
	private static final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm:ss", Locale.US);
	private static final String REGEX_PIPE = "\\|";

	public static void main(String[] args) {
	
		Parser p = new Parser();
		
		Parameters parameters = p.validateParameters(args);
		if (parameters.getPathToLog() == null) {
			System.out.println("Missing --accesslog='path/to/log' parameter");
			System.exit(0);
		}
		
		List<String> list = p.readFile(parameters.getPathToLog());
		
		LocalDateTime to = p.defineResearchPeriod(parameters.getStartDate(), parameters.getDuration());
		if (to == null) {
			System.out.println("Invalid duration parameter, only accepted: hourly or daily");
			System.exit(0);
		}
		
		List<LogVO> logVoList = p.findByPeriod(list, parameters.getStartDate(), to);
		
		p.distinctAndCount(logVoList, parameters.getStartDate(), to, parameters.getThreshold());
	}
	
	private Parameters validateParameters(String[] parameterList) {

		Parameters parameters = new Parameters();
		
		for (String param : parameterList) {
	
			if (param.startsWith("--startDate")) {

				String[] split = param.split("=");
				parameters.setStartDate(LocalDateTime.parse(split[1], CUSTOM_FORMATTER));

			} else if (param.startsWith("--duration")) {

				String[] split = param.split("=");
				parameters.setDuration(split[1]);

			} else if (param.startsWith("--threshold")) {

				String[] split = param.split("=");
				parameters.setThreshold(Integer.valueOf(split[1]));
				
			} else if (param.startsWith("--accesslog")) {
				
				String[] split = param.split("=");
				parameters.setPathToLog(split[1]);
			}
		}
		
		return parameters;
	}
	
	private LocalDateTime defineResearchPeriod(LocalDateTime from, String duration) {

		LocalDateTime to = null;
		if (duration.equalsIgnoreCase(ResearchPeriod.hourly.name()))
			to = from.plusHours(1).minusNanos(1);
		else if (duration.equalsIgnoreCase(ResearchPeriod.daily.name()))
			to = from.plusDays(1).minusNanos(1);
		else
			System.out.println("Error! Duration out of the scope.");
		return to;
	}
	
	private enum ResearchPeriod {
		hourly,
		daily;
	}
	
	private List<String> readFile(String fileName) {

		List<String> collect = null;
				
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			collect = stream.collect(Collectors.toList());

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error found", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() == null ? "Possible null pointer, see stack trace." : e.getMessage(), "General error", JOptionPane.ERROR_MESSAGE);
		}
		
		return collect;
	}
	
	private List<LogVO> findByPeriod(List<String> fullList, LocalDateTime from, LocalDateTime to) {

		System.out.println("from: " + from + " to: " + to);
		
		List<LogVO> ipList = new ArrayList<>();
		
		fullList.stream().forEach(line -> {
			
			String[] lineArray = line.split(REGEX_PIPE);
			
			String dateLineString = lineArray[0];
			LocalDateTime dateLineLocaldate = LocalDateTime.parse(dateLineString, LOG_FILE_FORMATTER);
			
			if (dateLineLocaldate.isAfter(from) && dateLineLocaldate.isBefore(to))
				ipList.add(new LogVO(dateLineLocaldate, lineArray[1], lineArray[2], Integer.valueOf(lineArray[3]), lineArray[4]));
		});
		
		return ipList;
	}

	private void distinctAndCount(List<LogVO> logVoList, LocalDateTime from, LocalDateTime to, Integer threshold) {

		List<LogVO> reduced = logVoList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > threshold)
				.map(e -> e.getKey())
				.collect(Collectors.toList());
		
		reduced.forEach(System.out::println);
		
		reduced.forEach(log -> {
			String comment = this.buildComment(log.getIp(), threshold, from, to);
			this.buildQuery(log.getDate(), log.getIp(), threshold, log.getRequest(), log.getStatus(), log.getUserAgent(), comment);
		});
	}
	
	private String buildComment(String ip, Integer threshold, LocalDateTime from, LocalDateTime to) {

		StringBuilder comment = new StringBuilder();
    	comment.append("The IP ");
		comment.append(ip);
		comment.append(" was blocked due to made more than ");
		comment.append(threshold);
		comment.append(" requests between ");
		comment.append(from);
		comment.append(" and ");
		comment.append(to);
		comment.append(".");
		
		return comment.toString();
	}
	
	private void buildQuery(LocalDateTime startDate, String ip, Integer threshold, String request, Integer status, String userAgent, String comment) {

		StringBuilder queryInsert = new StringBuilder();
		queryInsert.append("INSERT INTO blocked_ip (start_date, internet_protocol, threshold, request, status, user_agent, comment) values ('");
		queryInsert.append(startDate);
		queryInsert.append("', '");
		queryInsert.append(ip);
		queryInsert.append("', ");
		queryInsert.append(threshold);
		queryInsert.append(", ");
		queryInsert.append(request);
		queryInsert.append(", ");
		queryInsert.append(status);
		queryInsert.append(", ");
		queryInsert.append(userAgent);
		queryInsert.append(", '");
		queryInsert.append(comment);
		queryInsert.append("')");
		
		this.storeInDatabase(queryInsert.toString());
	}
	
	private void storeInDatabase(String query) {

		Connection connection = MySqlConnection.getConnection();
		Statement statement = null;
		try {
			
			statement = connection.createStatement();
			statement.execute(query);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage() == null ? "Possible null pointer, see stack trace." : e.getMessage(), "General error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
