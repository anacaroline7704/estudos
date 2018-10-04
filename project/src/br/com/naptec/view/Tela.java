package br.com.naptec.view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import br.com.naptec.Calculadora;

public class Tela {

	public JTextField getCampo1() {
		JTextField tx = new JTextField() ;
		tx.setSize(200, 24);
		return tx;
	}
	
	public JTextField getCampo2() {
		JTextField tf = new JTextField() ;
		tf.setSize(200, 20);
		return tf;
	}
	
	public JButton botao() {
		JButton jb = new JButton();
		jb.setText("botao");
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println();
				Calculadora calc = new Calculadora();
				
				String text = getCampo1().getText();
				String text2 = getCampo2().getText();
				
				
				Integer valorInteiro = Integer.valueOf(text);
				calc.divide(valorInteiro, Integer.valueOf(text2));
			}
		});
		return jb;
	}

	public void init() {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Teste");
		jf.setSize(1024, 250);

		jf.setLayout(new GridLayout(4,2));

		jf.getContentPane().add(getCampo1());
		jf.getContentPane().add(getCampo2());
		jf.getContentPane().add(botao());
		jf.getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jf.pack();
	}

	public static void main(String[] args) {
		Tela t = new Tela();
		t.init();
		
	}
}
