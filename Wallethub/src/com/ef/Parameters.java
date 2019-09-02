package com.ef;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Parameters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7142500014402050163L;
	private LocalDateTime startDate;
	private String duration;
	private Integer threshold;
	private String pathToLog;

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}

	public String getPathToLog() {
		return pathToLog;
	}

	public void setPathToLog(String pathToLog) {
		this.pathToLog = pathToLog;
	}
}
