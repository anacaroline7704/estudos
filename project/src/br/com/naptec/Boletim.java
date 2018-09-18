package br.com.naptec;

import java.util.Scanner;

public class Boletim {

	public void cadastroAluno(String nomeAluno, String serie, String formatoAno, String nomeColegio) {

		System.out.println("Teste");
	}

	public void cadastrarMateria() {
		String[] materias = new String[8];
		Scanner scan = new Scanner(System.in);

		System.out.println("-------CADASTRO DE MATERIAS-------");

		int i = 0;
		while (i < 8) {

			System.out.println("Informe a materia:");
			String conteudo = scan.nextLine();

			materias[i] = conteudo;
			i++;
		}
		System.out.println("materias cadastradas com sucesso!");
	}

	public void cadastrarAtividade() {

		String[] atividade = new String[8];
		Scanner scan = new Scanner(System.in);

		System.out.println("-------CADASTRO DE ATIVIDADES-------");

		int i = 0;
		while (i < 8) {

			System.out.println("Informe a atividade:");

			String conteudo = scan.nextLine();

			atividade[i] = conteudo;
			i++;
		}
	}

	public void recomendacaoEstudo() {

	}

	public void cadastrarNota() {

		String[] notas = new String[8];
		Scanner scan = new Scanner(System.in);

		System.out.println("-------CADASTRO DE NOTAS-------");

		int l = 0;
		while (l < 8) {

			System.out.println("Informe a nota:");

			String conteudo = scan.nextLine();

			notas[l] = conteudo;
			l++;
		}
	}

	public void calculoMedia() {

	}

	public void imprimirNota(String x) {

		System.out.println("sua nota é: " + x);
	}

	public static void main(String[] args) {
		Boletim x = new Boletim();
		x.cadastrarMateria();
		x.cadastrarAtividade();
		x.cadastrarNota();
	}
}

