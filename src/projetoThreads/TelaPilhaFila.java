package projetoThreads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPilhaFila extends JDialog{
	
	private JPanel jPanel = new JPanel(new GridBagLayout());//painel dos componentes// criar o painel

	private JLabel descricaoHora = new JLabel("Nome");//escrito no panel // criar label
	private JTextField mostraTempo = new JTextField();//campo tela de texto // criar a caixa de texto
	
	private JLabel descricaoHora2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jButton = new JButton("Gerar Lote"); //criar o botão
	private JButton jButton2 = new JButton("stop");
	
	//criado um objeto da classe 
	private implementacaoFilaThread fila = new implementacaoFilaThread();
	
	
	//metodo construtos// executa o que tiver dentro quando iniciar o objeto
	public TelaPilhaFila()  {
		//metodos estão vindo do (extends JDialog)
		setTitle("minha tela time com thread"); // titulo da janela
		setSize(new Dimension(240, 240));//tamanho da tela
		setLocationRelativeTo(null);//sentralizar a tela
		setResizable(false);//não deixar almentar e diminuir o tamanho da tela
		//-------------------------------------------------
		
		//controlador de posicionamento de componentes
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); //ajustar o posicionamento dos componentes
		
		gridBagConstraints.gridx =0;
		gridBagConstraints.gridy =0;
		gridBagConstraints.gridwidth = 2; //os componentes irão ocupar o espaço de dois no grid
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);// separar os componentes (cada numero é referente a alguama posição)
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		
		//contruir a label
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		//contruir o textfild
		mostraTempo.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++; //mover o textfild
		jPanel.add(mostraTempo, gridBagConstraints);
		
		
		descricaoHora2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++; //mover para não ficar em sima do outro componente
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++; //mover para não ficar em sima do outro componente
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1; //quando chegar aqui altera os botões para o espaço de 1 no grid// (os dois botoes ão ficar no mesmo espaço)
		
		
		//contruir o botão
		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton, gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++; //adicionar ao lado do botão start// o grid so vai até quatra linhas
		jPanel.add(jButton2, gridBagConstraints);
		
		//metodo para chamar a ac~]ao do botão
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //executa o clique no botão
				
				
				if(fila == null) {
					fila = new implementacaoFilaThread();
					fila.start();
				}
				
				
				
				for (int qtd =0; qtd <100; qtd++) { //simular 100 envios, quando chagar até 100 para de enviar
					
				objetoFilaThread filathread = new objetoFilaThread();
				filathread.setNome(mostraTempo.getText());
				filathread.setEmail(mostraTempo2.getText() + " - "+ qtd);
				
				fila.add(filathread);
				
				}
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				fila.stop(); //parar a fila
				fila = null; //apagar a fila
				
				
			}
		});
		
		
		
		fila.start(); //cahma a fila para iniciar
		add(jPanel, BorderLayout.WEST); //adicioanl no diolog(sem isso não o label no aperece no panel)
		//--------------------------------------------------
		//torna a tela visivel para o usuario / sempre sera o ultimo comando
		setVisible(true);
		
	}

}
