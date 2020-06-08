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

//             extends Swing tela JDialog
public class TelaTimeThread extends JDialog{
	
	
	private JPanel jPanel = new JPanel(new GridBagLayout());//painel dos componentes// criar o painel

	private JLabel descricaoHora = new JLabel("Time thead 1");//escrito no panel // criar label
	private JTextField mostraTempo = new JTextField();//campo tela de texto // criar a caixa de texto
	
	private JLabel descricaoHora2 = new JLabel("Time thead 2");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton jButton = new JButton("start"); //criar o bot�o
	private JButton jButton2 = new JButton("stop");
	
	//interface para criar a thread com o metodo que sera executado
	private Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			while(true) {//fica sempre rodando ate matar a thread
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime())); // entrega o valor na caixa de texto ja formado, (pega as informa��es da classe "Calendar" j� formatada
				
				//para n�o travar o metodo dar 1 segundo de tempo at� continuar
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}	
		
	};
	
private Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			while(true) {//fica sempre rodando ate matar a thread
				mostraTempo2.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").
						format(Calendar.getInstance().getTime())); // entrega o valor na caixa de texto ja formado, (pega as informa��es da classe "Calendar" j� formatada
				
				//para n�o travar o metodo dar 1 segundo de tempo at� continuar
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}	
		
	};
	
	
	
	private Thread thread1Time;
	private Thread thread2Time;
	
	
	//metodo construtos// executa o que tiver dentro quando iniciar o objeto
	public TelaTimeThread() {
		//metodos est�o vindo do (extends JDialog)
		setTitle("minha tela time com thread"); // titulo da janela
		setSize(new Dimension(240, 240));//tamanho da tela
		setLocationRelativeTo(null);//sentralizar a tela
		setResizable(false);//n�o deixar almentar e diminuir o tamanho da tela
		//-------------------------------------------------
		
		//controlador de posicionamento de componentes
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); //ajustar o posicionamento dos componentes
		
		gridBagConstraints.gridx =0;
		gridBagConstraints.gridy =0;
		gridBagConstraints.gridwidth = 2; //os componentes ir�o ocupar o espa�o de dois no grid
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);// separar os componentes (cada numero � referente a alguama posi��o)
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		
		//contruir a label
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);
		
		//contruir o textfild
		mostraTempo.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++; //mover o textfild
		mostraTempo.setEditable(false); //para n�o conseguir escrever na telinha(agora s� serve para mostrar as coisas)
		jPanel.add(mostraTempo, gridBagConstraints);
		
		
		descricaoHora2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++; //mover para n�o ficar em sima do outro componente
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++; //mover para n�o ficar em sima do outro componente
		mostraTempo2.setEditable(false);
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1; //quando chegar aqui altera os bot�es para o espa�o de 1 no grid// (os dois botoes �o ficar no mesmo espa�o)
		
		
		//contruir o bot�o
		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton, gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++; //adicionar ao lado do bot�o start// o grid so vai at� quatra linhas
		jPanel.add(jButton2, gridBagConstraints);
		
		//metodo para chamar a ac~]ao do bot�o
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //executa o clique no bot�o
				
				thread1Time = new Thread(thread1); //cria o objeto thread
				thread1Time.start();//metodo que ezecuta o metodo da thread1
				
				thread2Time = new Thread(thread2); 
				thread2Time.start();
				
				jButton.setEnabled(false);//desabilita o bot�o de start depois que clicar nele
				jButton2.setEnabled(true);//abilita o bot�o stop 
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thread1Time.stop();
				thread2Time.stop();
				
				jButton2.setEnabled(false);//desabilita o bot�o de stop depois que clicar nele
				jButton.setEnabled(true);//abilita o bot�o de start
				
				
			}
		});
		
		jButton2.setEnabled(false); //desabilita o bot�o de stop
		
		
		
		add(jPanel, BorderLayout.WEST); //adicioanl no diolog(sem isso n�o o label no aperece no panel)
		//--------------------------------------------------
		//torna a tela visivel para o usuario / sempre sera o ultimo comando
		setVisible(true);
		
	}
	
	
	
}
