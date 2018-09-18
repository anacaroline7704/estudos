package br.com.naptec.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import br.com.naptec.Calculadora;

public class Tela {

	public JButton botao() {
		JButton jb = new JButton();
		jb.setText("botao");
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println();
				Calculadora calc = new Calculadora();
				calc.divide();
			}
		});
		return jb;
	}

	public void init() {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Teste");
		jf.setSize(1024, 650);

		jf.setLayout(new BorderLayout());

		jf.getContentPane().add(botao(), BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		Tela t = new Tela();
		t.init();
	}
}
