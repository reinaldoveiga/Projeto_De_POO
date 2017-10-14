
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.JComboBox;

public class Janela2 extends JFrame {
	private JTextField textCodigoDeBarras;
	GerenciadorDeRoupasParaLojas gerenciador;
	Gravador gravador = new Gravador();	
	
	Sexo sexo = null;
	Roupas roupa = new Roupas();
	String tipo = "";
	String tamanho = "";
	String fabricante = "";
	
	JComboBox comboBoxTipo;
	JComboBox comboBoxFabricante;
	JComboBox comboBoxTamanho;
	JComboBox comboBoxSexo;
	
	public Janela2(GerenciadorDeRoupasParaLojas gerenciador) {
		
		this.gerenciador = gerenciador;
		
		this.comboBoxSexo = new JComboBox();
		this.comboBoxTipo = new JComboBox();
		this.comboBoxTamanho = new JComboBox();
		this.comboBoxFabricante = new JComboBox();

		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(158, 13, 70, 15);
		getContentPane().add(lblTipo);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Arial", Font.BOLD, 13));
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setBounds(396, 13, 92, 15);
		getContentPane().add(lblFabricante);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Arial", Font.BOLD, 13));
		lblTamanho.setForeground(Color.WHITE);
		lblTamanho.setBounds(396, 86, 70, 15);
		getContentPane().add(lblTamanho);
		
		JLabel lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblCdigoDeBarras.setBackground(Color.WHITE);
		lblCdigoDeBarras.setForeground(Color.WHITE);
		lblCdigoDeBarras.setBounds(126, 86, 152, 15);
		getContentPane().add(lblCdigoDeBarras);
		
		textCodigoDeBarras = new JTextField();
		textCodigoDeBarras.setBackground(Color.WHITE);
		textCodigoDeBarras.setBounds(126, 112, 113, 19);
		getContentPane().add(textCodigoDeBarras);
		textCodigoDeBarras.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(janela02.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cadastraRoupas();
			textCodigoDeBarras.setText("");
			}
		});
		btnCadastrar.setBounds(149, 295, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(janela02.class.getResource("/imagensProjeto/back-arrow (1).png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			voltar();
			}
		});
		btnVoltar.setBounds(349, 295, 117, 25);
		getContentPane().add(btnVoltar);
		
		//Sexo
		comboBoxSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionaSexo();
			}
		});
		comboBoxSexo.setBounds(257, 165, 113, 20);
		comboBoxSexo.addItem("");
		comboBoxSexo.addItem("Masculino");
		comboBoxSexo.addItem("Feminino");
		comboBoxSexo.addItem("Unisex");
		getContentPane().add(comboBoxSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSexo.setBounds(295, 140, 46, 14);
		getContentPane().add(lblSexo);
		
		//Tipo
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionarTipo();
			}
		});
		comboBoxTipo.setBounds(126, 39, 113, 20);
		comboBoxTipo.addItem("");
		
		comboBoxTipo.addItem("Selecionar outro");
		comboBoxTipo.addItem("camisa");
		comboBoxTipo.addItem("calça");
		comboBoxTipo.addItem("short");
		comboBoxTipo.addItem("vestido");
		comboBoxTipo.addItem("gravata");
		getContentPane().add(comboBoxTipo);
		
		//Tamanho
		comboBoxTamanho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionaTamanho();
			}
		});
		comboBoxTamanho.setBounds(375, 112, 113, 20);
		comboBoxTamanho.addItem("");
		comboBoxTamanho.addItem("Selecionar outro");
		comboBoxTamanho.addItem("PP");
		comboBoxTamanho.addItem("P");
		comboBoxTamanho.addItem("M");
		comboBoxTamanho.addItem("G");
		comboBoxTamanho.addItem("GG");
		comboBoxTamanho.addItem("36");
		comboBoxTamanho.addItem("38");
		comboBoxTamanho.addItem("40");
		comboBoxTamanho.addItem("42");
		getContentPane().add(comboBoxTamanho);
		
		//Fabricante
		comboBoxFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarFabricante();
			}
		});
		comboBoxFabricante.setBounds(375, 39, 113, 20);
		comboBoxFabricante.addItem("");
		comboBoxFabricante.addItem("Selecionar outro");
		comboBoxFabricante.addItem("adidas");
		comboBoxFabricante.addItem("nike");
		comboBoxFabricante.addItem("calvin_klein");
		comboBoxFabricante.addItem("polo");
		comboBoxFabricante.addItem("lacoste");
		
		getContentPane().add(comboBoxFabricante);
		
		JLabel lblFundodestaque = new JLabel("fundoDestaque");
		lblFundodestaque.setIcon(new ImageIcon(janela02.class.getResource("/imagensProjeto/fundoParaJanela2.jpg")));
		lblFundodestaque.setBounds(105, -3, 402, 195);
		getContentPane().add(lblFundodestaque);
		
		JLabel lblJanela = new JLabel("janela2");
		lblJanela.setIcon(new ImageIcon(janela02.class.getResource("/imagensProjeto/Janela2.jpeg")));
		lblJanela.setBounds(-11, -3, 719, 442);
		getContentPane().add(lblJanela);
	    			
	
	}
	
	private void selecionarTipo(){
		if(comboBoxTipo.getSelectedItem().toString().equals("camisa")){
			tipo = "CAMISA";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("calça")){
			tipo = "CALÇA";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("gravata")){
			tipo = "GRAVATA";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("short")){
			tipo = "SHORT";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("vestido")){
			tipo = "VESTIDO";	
		}else if(comboBoxTipo.getSelectedItem().toString().equals("Selecionar outro")){
			String outroTipo = JOptionPane.showInputDialog("Digite aqui o tipo da roupa:");
			if(outroTipo == null){
			
			}else if(outroTipo.equals("")){
				JOptionPane.showMessageDialog(null,"Digite Novamente!");	
			}else{
				tipo = outroTipo.toUpperCase();
			}
		}else{
			tipo = "";
		}
	}
	private void selecionarFabricante(){
		if(comboBoxFabricante.getSelectedItem().toString().equals("adidas")){
			fabricante = "ADIDAS";
		}else if(comboBoxFabricante.getSelectedItem().toString().equals("nike")){
			fabricante = "NIKE";

		}else if(comboBoxFabricante.getSelectedItem().toString().equals("calvin_klein")){
			fabricante = "CALVIN_KLINE";

		}else if(comboBoxFabricante.getSelectedItem().toString().equals("polo")){
			fabricante = "POLO";
		
		}else if(comboBoxFabricante.getSelectedItem().toString().equals("lacoste")){
			fabricante = "LACOSTE";

		}else if(comboBoxFabricante.getSelectedItem().toString().equals("Selecionar outro")){
			String outroFabricante = JOptionPane.showInputDialog("Digite aqui o fabricante da roupa:");
			if(outroFabricante == null){
			
			}else if(outroFabricante.equals("")){
				JOptionPane.showMessageDialog(null,"Digite Novamente!");	
			}else{
				fabricante = outroFabricante.toUpperCase();
			}

		}else{
			fabricante = "";
		}
	}
	private void selecionaTamanho(){
		if(comboBoxTamanho.getSelectedItem().toString().equals("PP")){
			tamanho = "PP";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("P")){
			tamanho = "P";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("M")){
			tamanho = "M";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("G")){
			tamanho = "G";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("GG")){
			tamanho = "GG";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("36")){
			tamanho = "36";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("38")){
			tamanho = "38";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("40")){
			tamanho = "40";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("42")){
			tamanho = "42";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("Selecionar outro")){
			String outroTamanho = JOptionPane.showInputDialog("Digite aqui o tamanho da roupa:");
			if(outroTamanho == null){
			
			}else if(outroTamanho.equals("")){
				JOptionPane.showMessageDialog(null,"Digite Novamente!");	
			}else{
				tamanho = outroTamanho.toUpperCase();
			}
		}else{
			tamanho = "";
		}
	}
	private void selecionaSexo(){
		if(comboBoxSexo.getSelectedItem().toString().equals("Masculino")){
			sexo = sexo.MASCULINO;
		}else if(comboBoxSexo.getSelectedItem().toString().equals("Feminino")){
			sexo = sexo.FEMININO;
		}else if(comboBoxSexo.getSelectedItem().toString().equals("Unisex")){
			sexo = sexo.UNISEX;
		}else{
			sexo = null;
		}

	}
	
	private void cadastraRoupas(){
			roupa = new Roupas(tipo, fabricante, sexo, tamanho, textCodigoDeBarras.getText().toString());
			
			try{
				
				 gerenciador.cadastraRoupas(roupa);
				 
		        JOptionPane.showMessageDialog(null, "1 roupa cadastrada com sucesso\n"+roupa.toString());
		        File r = new File("Roupas.txt");
		 	gravador.gravaRoupas(gerenciador.pesquisaRoupas());
		 		
			}catch(RoupaInvalidaException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			 	 
			}catch(RoupaJaExisteException e){
				JOptionPane.showMessageDialog(null,e.getMessage());
			}
		}
	private void voltar(){
		
		JanelaPrincipal janela1 = new JanelaPrincipal(this.gerenciador);
		janela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela1.setSize(630, 460);
      
        janela1.setLocationRelativeTo(null);
        janela1.setVisible(true);
        janela1.setResizable(false);
      
		dispose();
		}
	}
