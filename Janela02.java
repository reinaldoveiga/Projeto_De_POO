import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class janela02 extends JFrame {
	private JTextField textTipo;
	private JTextField textFabricante;
	private JTextField textTamanho;
	private JTextField textCodigoDeBarras;
	GerenciadorDeRoupasParaLojas gerenciador;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela02 frame = new janela02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public janela02(GerenciadorDeRoupasParaLojas gerenciador) {
		
		this.gerenciador = gerenciador;

		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(158, 13, 70, 15);
		getContentPane().add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setBounds(125, 39, 114, 19);
		getContentPane().add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Arial", Font.BOLD, 13));
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setBounds(389, 13, 92, 15);
		getContentPane().add(lblFabricante);
		
		textFabricante = new JTextField();
		textFabricante.setBounds(363, 39, 114, 19);
		getContentPane().add(textFabricante);
		textFabricante.setColumns(10);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Arial", Font.BOLD, 13));
		lblTamanho.setForeground(Color.WHITE);
		lblTamanho.setBounds(380, 86, 70, 15);
		getContentPane().add(lblTamanho);
		
		textTamanho = new JTextField();
		textTamanho.setBounds(363, 112, 114, 19);
		getContentPane().add(textTamanho);
		textTamanho.setColumns(10);
		
		JLabel lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblCdigoDeBarras.setBackground(Color.WHITE);
		lblCdigoDeBarras.setForeground(Color.WHITE);
		lblCdigoDeBarras.setBounds(126, 86, 152, 15);
		getContentPane().add(lblCdigoDeBarras);
		
		textCodigoDeBarras = new JTextField();
		textCodigoDeBarras.setBounds(125, 112, 114, 19);
		getContentPane().add(textCodigoDeBarras);
		textCodigoDeBarras.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(janela02.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cadastraRoupas();
			textTipo.setText("");
			textFabricante.setText("");
			textTamanho.setText("");
			textCodigoDeBarras.setText("");
			}
		});
		btnCadastrar.setBounds(136, 295, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\back-arrow (1).png"));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			voltar();
			}
		});
		btnVoltar.setBounds(333, 295, 117, 25);
		getContentPane().add(btnVoltar);
				
		JButton btnSexo = new JButton("Sexo");
		btnSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			escolheSexo();
			}
		});
		btnSexo.setBounds(250, 164, 117, 25);
		getContentPane().add(btnSexo);
		
		JLabel lblImagemjanela = new JLabel("imagemJanela2");
		lblImagemjanela.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\Dicas-para-ter-uma-gestao-de-estoque-de-lojas-mais-efetiva.png"));
		lblImagemjanela.setBounds(-14, -14, 643, 449);
		getContentPane().add(lblImagemjanela);
	    
		
	
	}
	Sexo s = null;
	Roupas roupa = new Roupas();
	
	private void cadastraRoupas(){
		
			try{
				
				 gerenciador.cadastraRoupas(roupa);
		         JOptionPane.showMessageDialog(null, "1 roupa cadastrada com sucesso\n"+roupa.toString());
		         roupa = new Roupas();
			}catch(RoupaInvalidaException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			 	 
			}catch(RoupaJaExisteException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
	
	    

	private void escolheSexo(){	
		String sexo = JOptionPane.showInputDialog("Informe o modelo de roupa:\n1.Feminino\n2.Masculino\n3.Unisex");
			
			 if(sexo == null){
				 
			 }else if(sexo.equals("1")){
			 
				 roupa = new Roupas(textTipo.getText().toString(),textFabricante.getText().toString(), s.FEMININO, textTamanho.getText().toString(), textCodigoDeBarras.getText().toString());
				 

			 }else if(sexo.equals("2")){
				roupa = new Roupas(textTipo.getText().toString(),textFabricante.getText().toString(), s.MASCULINO, textTamanho.getText().toString(), textCodigoDeBarras.getText().toString());
					 
			 }else if(sexo.equals("3")){
				roupa = new Roupas(textTipo.getText().toString(),textFabricante.getText().toString(), s.UNISEX, textTamanho.getText().toString(), textCodigoDeBarras.getText().toString());
					 
			 }else{
					JOptionPane.showMessageDialog(null,"Valor Inválido!");

			 }
	}
	private void voltar(){
		//System.exit(0);
		//janela01 janela1 = new janela01();
			
		//janela1.setVisible(true);
		//new janela01();
		//janela01.setVisible(true);
		dispose();
		//janela.setVisible(true);	

	}
}
