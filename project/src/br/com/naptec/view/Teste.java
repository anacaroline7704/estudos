package br.com.naptec.view;

import br.com.naptec.Pessoa;

public class Teste {

	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		String nome = p.getNome();
		String rua = p.getEndereco().getRua();
		int numero = p.getEndereco().getNumero();
		String cidade = p.getEndereco().getCidade();
		String bairro = p.getEndereco().getBairro();
	}
}
