package projetoThreads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
	
	private JButton jButton = new JButton("start"); //criar o botão
	private JButton jButton2 = new JButton("stop");
	
	//metodo construtos// executa o que tiver dentro quando iniciar o objeto
	public TelaTimeThread() {
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
		mostraTempo.setEditable(false); //para não conseguir escrever na telinha(agora só serve para mostrar as coisas)
		jPanel.add(mostraTempo, gridBagConstraints);
		
		
		descricaoHora2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++; //mover para não ficar em sima do outro componente
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++; //mover para não ficar em sima do outro componente
		mostraTempo2.setEditable(false);
		jPanel.add(mostraTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1; //quando chegar aqui altera os botões para o espaço de 1 no grid// (os dois botoes ão ficar no mesmo espaço)
		
		
		//contruir o botão
		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton, gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++; //adicionar ao lado do botão start// o grid so vai até quatra linhas
		jPanel.add(jButton2, gridBagConstraints);
		
		
		add(jPanel, BorderLayout.WEST); //adicioanl no diolog(sem isso não o label no aperece no panel)
		//--------------------------------------------------
		//torna a tela visivel para o usuario / sempre sera o ultimo comando
		setVisible(true);
		
	}
	
	
	
}
