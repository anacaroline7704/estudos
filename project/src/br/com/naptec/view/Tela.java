package br.com.naptec.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.naptec.Calculadora;

public class Tela {
	
	private JTextField valor;
	private JTextField taxa;
	JLabel resultado = new JLabel("");
	
	public void init() {
		JFrame jf = new JFrame();
		jf.getContentPane().setLayout(null);
		
		valor = new JTextField();
		valor.setBounds(102, 11, 86, 20);
		jf.getContentPane().add(valor);
		valor.setColumns(10);
		
		taxa = new JTextField();
		taxa.setBounds(102, 42, 86, 20);
		jf.getContentPane().add(taxa);
		taxa.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(46, 14, 46, 14);
		jf.getContentPane().add(lblValor);
		
		JLabel lblTaxa = new JLabel("Taxa");
		lblTaxa.setBounds(46, 45, 46, 14);
		jf.getContentPane().add(lblTaxa);
		
		JButton btnCalcula = new JButton("Calcula");
		btnCalcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tx = taxa.getText()  ;
				String vl = valor.getText() ;
				
				Double vv = Double.valueOf(tx);
				Double tt = Double.valueOf(vl);
				
				Calculadora c = new Calculadora();
				c.divide(tt, vv);
				double d = c.divide(tt, vv) ;
				String dd = String.valueOf(d) ;
				resultado.setText(dd);
			}
		}); 
		btnCalcula.setBounds(99, 73, 89, 23);
		jf.getContentPane().add(btnCalcula);
		
		resultado.setBounds(109, 117, 63, 14);
		jf.getContentPane().add(resultado);
		jf.setVisible(true);
	}

	public static void main(String[] args) {
		Tela t = new Tela();
		t.init();
		
	}
}
