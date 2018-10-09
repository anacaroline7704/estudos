package br.com.naptec.view;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {
	 
    private JButton botaoEsquerdo;  //BOTÃO PARA CONFIGURAR O ALINHAMENTO À ESQUERDA
    private JButton botaoDireito;   //BOTÃO PARA CONFIGURAR O ALINHAMENTO À DIREITA
    private JButton botaoCentral;   //BOTÃO PARA CONFIGURAR O ALINHAMENTO CENTRALIZADO
    private FlowLayout layout;      //OBJETO LAYOUT
    private Container container;    //CONTÊINER PARA CONFIGURAR LAYOUT
     
    public FlowLayoutFrame() {
        super("Demonstração de um FlowLayout");
         
        layout = new FlowLayout();      //CRIA FLOWLAYOUT
        container = getContentPane();   //OBTÊM CONTEINER PARA LAYOUT
         
        setLayout(layout);  //CONFIGURA O LAYOUT DE FRAME
         
        botaoEsquerdo = new JButton("Esquerda");    //CRIA O BOTÃO LEFT
        add(botaoEsquerdo);     //ADICIONA O BOTÃO ESQUERDO AO FRAME
         
        botaoEsquerdo.addActionListener(new ActionListener() {
             
                @Override
                public void actionPerformed(ActionEvent e) {
                    layout.setAlignment(FlowLayout.LEFT);
                    layout.layoutContainer(container);
                }
            }
        );
         
        botaoCentral = new JButton("Centro");   //CRIA P BOTÃO CENTRAL
        add(botaoCentral);  //ADICIONO O BOTÃO AO FRAME
         
        botaoCentral.addActionListener(new ActionListener() {
             
                @Override
                public void actionPerformed(ActionEvent e) {
                    layout.setAlignment(FlowLayout.CENTER);
                    layout.layoutContainer(container);                  
                }
            }
        );
         
        botaoDireito = new JButton("Direita");
        add(botaoDireito);  //ADICIONA BOTÃO
         
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