package br.com.naptec.doamin;

import java.util.ArrayList;
import java.util.List;

public class Listas {

	public void preencheLista() {

		
		Pessoa pessoa1 = new Pessoa();
		Pessoa pessoa2 = new Pessoa();
		Pessoa pessoa3 = new Pessoa();
		Pessoa pessoa4 = new Pessoa();
		Pessoa pessoa5 = new Pessoa();
		
		List<Pessoa> listaPessoa = new ArrayList<>();
		listaPessoa.add(pessoa1);
		listaPessoa.add(pessoa2);
		listaPessoa.add(pessoa3);
		listaPessoa.add(pessoa4);
		listaPessoa.add(pessoa5);
	}
}
