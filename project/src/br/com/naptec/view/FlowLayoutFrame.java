package br.com.naptec.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {
	 
    private JButton botaoEsquerdo;  //BOT�O PARA CONFIGURAR O ALINHAMENTO � ESQUERDA
    private JButton botaoDireito;   //BOT�O PARA CONFIGURAR O ALINHAMENTO � DIREITA
    private JButton botaoCentral;   //BOT�O PARA CONFIGURAR O ALINHAMENTO CENTRALIZADO
    private FlowLayout layout;      //OBJETO LAYOUT
    private Container container;    //CONT�INER PARA CONFIGURAR LAYOUT
     
    public FlowLayoutFrame() {
        super("Demonstra��o de um FlowLayout");
         
        layout = new FlowLayout();      //CRIA FLOWLAYOUT
        container = getContentPane();   //OBT�M CONTEINER PARA LAYOUT
         
        setLayout(layout);  //CONFIGURA O LAYOUT DE FRAME
         
        botaoEsquerdo = new JButton("Esquerda");    //CRIA O BOT�O LEFT
        add(botaoEsquerdo);     //ADICIONA O BOT�O ESQUERDO AO FRAME
         
        botaoEsquerdo.addActionListener(new ActionListener() {
             
                @Override
                public void actionPerformed(ActionEvent e) {
                    layout.setAlignment(FlowLayout.LEFT);
                    layout.layoutContainer(container);
                }
            }
        );
         
        botaoCentral = new JButton("Centro");   //CRIA P BOT�O CENTRAL
        add(botaoCentral);  //ADICIONO O BOT�O AO FRAME
         
        botaoCentral.addActionListener(new ActionListener() {
             
                @Override
                public void actionPerformed(ActionEvent e) {
                    layout.setAlignment(FlowLayout.CENTER);
                    layout.layoutContainer(container);                  
                }
            }
        );
         
        botaoDireito = new JButton("Direita");
        add(botaoDireito);  //ADICIONA BOT�O
         
        botaoDireito.addActionListener(new ActionListener() {
             
                @Override
                public void actionPerformed(ActionEvent e) {
                    layout.setAlignment(FlowLayout.RIGHT);
                     
                    layout.layoutContainer(container);                  
                }
            }
        );
    }
    
    public static void main(String[] args) {
        
        FlowLayoutFrame fl = new FlowLayoutFrame();
        fl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fl.setSize(600, 75);    //CONFIGURA O TAMANHO DA TELA
        fl.setVisible(true);    //CONFIGURA A VISIBILIDADE
    }
}