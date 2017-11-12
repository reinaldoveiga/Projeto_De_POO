
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

public class JanelaCadastraRoupas extends JFrame {
	private JTextField textCodigoDeBarras;
	private GerenciadorDeRoupasParaLojas gerenciador;
	private Gravador gravador = new Gravador();	
	
	private Sexo sexo = null;
	private Roupas roupa = new Roupas();
	private String tipo = "";
	private String tamanho = "";
	private String fabricante = "";
	private double preco = 0.00;
	
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxFabricante;
	private JComboBox comboBoxTamanho;
	private JComboBox comboBoxSexo;
	private JComboBox comboBoxPreco;

	public JanelaCadastraRoupas(GerenciadorDeRoupasParaLojas gerenciador) {
		
		this.gerenciador = gerenciador;
		
		this.comboBoxSexo = new JComboBox();
		this.comboBoxTipo = new JComboBox();
		this.comboBoxTamanho = new JComboBox();
		this.comboBoxFabricante = new JComboBox();
		this.comboBoxPreco = new JComboBox();

		setBounds(100, 100, 572, 462);
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
		lblTamanho.setBounds(396, 71, 70, 15);
		getContentPane().add(lblTamanho);
		
		JLabel lblCdigoDeBarras = new JLabel("Código de Barras");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblCdigoDeBarras.setBackground(Color.WHITE);
		lblCdigoDeBarras.setForeground(Color.WHITE);
		lblCdigoDeBarras.setBounds(114, 126, 152, 15);
		getContentPane().add(lblCdigoDeBarras);
		
		textCodigoDeBarras = new JTextField();
		textCodigoDeBarras.setBackground(Color.WHITE);
		textCodigoDeBarras.setBounds(124, 153, 113, 19);
		getContentPane().add(textCodigoDeBarras);
		textCodigoDeBarras.setColumns(10);
		
		//Botões
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(JanelaCadastraRoupas.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cadastraRoupas();
			textCodigoDeBarras.setText("");
			}
		});
		btnCadastrar.setBounds(149, 295, 117, 25);
		getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(JanelaCadastraRoupas.class.getResource("/imagensProjeto/back-arrow (1).png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			voltar();
			}
		});
		btnVoltar.setBounds(349, 295, 117, 25);
		getContentPane().add(btnVoltar);
		
		//ComboBox de opções
		//Sexo
		comboBoxSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionaSexo();
			}
		});
		comboBoxSexo.setBounds(126, 97, 113, 20);
		comboBoxSexo.addItem("");
		comboBoxSexo.addItem("Masculino");
		comboBoxSexo.addItem("Feminino");
		comboBoxSexo.addItem("Unisex");
		getContentPane().add(comboBoxSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSexo.setBounds(158, 71, 46, 14);
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
		comboBoxTamanho.setBounds(375, 97, 113, 20);
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
		
		//preço
		comboBoxPreco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selecionaPreco();
			}
		});
		
		comboBoxPreco.setBounds(375, 150, 113, 20);
		comboBoxPreco.addItem("R$ 5.00");
		comboBoxPreco.addItem("R$ 8.00");
		comboBoxPreco.addItem("R$ 10.00");
		comboBoxPreco.addItem("R$ 15.00");
		comboBoxPreco.addItem("R$ 20.00");
		comboBoxPreco.addItem("R$ 25.00");
		comboBoxPreco.addItem("R$ 30.00");
		comboBoxPreco.addItem("R$ 35.00");
		comboBoxPreco.addItem("R$ 40.00");
		comboBoxPreco.addItem("R$ 45.00");
		comboBoxPreco.addItem("R$ 50.00");
		comboBoxPreco.addItem("R$ 55.00");
		comboBoxPreco.addItem("R$ 60.00");
		comboBoxPreco.addItem("R$ 65.00");
		comboBoxPreco.addItem("R$ 70.00");
		comboBoxPreco.addItem("R$ 75.00");
		comboBoxPreco.addItem("R$ 80.00");
		comboBoxPreco.addItem("R$ 85.00");
		comboBoxPreco.addItem("R$ 90.00");
		comboBoxPreco.addItem("R$ 95.00");
		comboBoxPreco.addItem("R$ 100.00");
		comboBoxPreco.addItem("R$ 120.00");
		comboBoxPreco.addItem("R$ 125.00");
		comboBoxPreco.addItem("R$ 130.00");
		comboBoxPreco.addItem("R$ 150.00");
		comboBoxPreco.addItem("R$ 200.00");

		getContentPane().add(comboBoxPreco);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPreo.setForeground(Color.WHITE);
		lblPreo.setBounds(410, 126, 122, 10);
		getContentPane().add(lblPreo);
		
		JLabel lblFundodestaque = new JLabel("fundoDestaque");
		lblFundodestaque.setIcon(new ImageIcon(JanelaCadastraRoupas.class.getResource("/imagensProjeto/fundoParaJanela2.jpg")));
		lblFundodestaque.setBounds(88, -48, 438, 249);
		getContentPane().add(lblFundodestaque);
		
		JLabel lblJanela = new JLabel("janela2");
		lblJanela.setIcon(new ImageIcon(JanelaCadastraRoupas.class.getResource("/imagensProjeto/Janela2.jpeg")));
		lblJanela.setBounds(-11, -3, 733, 473);
		getContentPane().add(lblJanela);
	    			
	
	}
	
	private void selecionarTipo(){
		if(comboBoxTipo.getSelectedItem().toString().equals("camisa")){
			this.tipo = "CAMISA";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("calça")){
			this.tipo = "CALÇA";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("gravata")){
			this.tipo = "GRAVATA";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("short")){
			this.tipo = "SHORT";
		}else if(comboBoxTipo.getSelectedItem().toString().equals("vestido")){
			this.tipo = "VESTIDO";	
		}else if(comboBoxTipo.getSelectedItem().toString().equals("Selecionar outro")){
			String outroTipo = JOptionPane.showInputDialog("Digite aqui o tipo da roupa:");
			if(outroTipo == null){
			
			}else if(outroTipo.equals("")){
				JOptionPane.showMessageDialog(null,"Digite Novamente!");	
			}else{
				this.tipo = outroTipo.toUpperCase();
			}
		}else{
			this.tipo = "";
		}
	}
	private void selecionarFabricante(){
		if(comboBoxFabricante.getSelectedItem().toString().equals("adidas")){
			this.fabricante = "ADIDAS";
		}else if(comboBoxFabricante.getSelectedItem().toString().equals("nike")){
			this.fabricante = "NIKE";

		}else if(comboBoxFabricante.getSelectedItem().toString().equals("calvin_klein")){
			this.fabricante = "CALVIN_KLINE";

		}else if(comboBoxFabricante.getSelectedItem().toString().equals("polo")){
			this.fabricante = "POLO";
		
		}else if(comboBoxFabricante.getSelectedItem().toString().equals("lacoste")){
			this.fabricante = "LACOSTE";

		}else if(comboBoxFabricante.getSelectedItem().toString().equals("Selecionar outro")){
			String outroFabricante = JOptionPane.showInputDialog("Digite aqui o fabricante da roupa:");
			if(outroFabricante == null){
			
			}else if(outroFabricante.equals("")){
				JOptionPane.showMessageDialog(null,"Digite Novamente!");	
			}else{
				this.fabricante = outroFabricante.toUpperCase();
			}

		}else{
			this.fabricante = "";
		}
	}
	private void selecionaTamanho(){
		if(comboBoxTamanho.getSelectedItem().toString().equals("PP")){
			this.tamanho = "PP";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("P")){
			this.tamanho = "P";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("M")){
			this.tamanho = "M";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("G")){
			this.tamanho = "G";
			
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("GG")){
			this.tamanho = "GG";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("36")){
			this.tamanho = "36";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("38")){
			this.tamanho = "38";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("40")){
			this.tamanho = "40";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("42")){
			this.tamanho = "42";
		}else if(comboBoxTamanho.getSelectedItem().toString().equals("Selecionar outro")){
			String outroTamanho = JOptionPane.showInputDialog("Digite aqui o tamanho da roupa:");
			if(outroTamanho == null){
			
			}else if(outroTamanho.equals("")){
				JOptionPane.showMessageDialog(null,"Digite Novamente!");	
			}else{ 
				this.tamanho = outroTamanho.toUpperCase();
			}
		}else{
			this.tamanho = "";
		}
	}
	private void selecionaSexo(){
		if(comboBoxSexo.getSelectedItem().toString().equals("Masculino")){
			this.sexo = sexo.MASCULINO;
		}else if(comboBoxSexo.getSelectedItem().toString().equals("Feminino")){
			this.sexo = sexo.FEMININO;
		}else if(comboBoxSexo.getSelectedItem().toString().equals("Unisex")){
			this.sexo = sexo.UNISEX;
		}else{
			this.sexo = null;
		}

	}
	private void selecionaPreco(){
		if(comboBoxPreco.getSelectedItem().toString().equals("R$ 5.00")){
			this.preco = 5.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 8.00")){
			this.preco = 8.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 10.00")){
			this.preco = 10.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 15.00")){
			this.preco = 15.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 20.00")){
			this.preco = 20.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 25.00")){
			this.preco = 25.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 30.00")){
			this.preco = 30.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 35.00")){
			this.preco = 35.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 40.00")){
			this.preco = 40.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 45.00")){
			this.preco = 45.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 50.00")){
			this.preco = 50.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 55.00")){
			this.preco = 55.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 60.00")){
			this.preco = 60.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 65.00")){
			this.preco = 65.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 70.00")){
			this.preco = 70.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 75.00")){
			this.preco = 75.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 80.00")){
			this.preco = 80.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 85.00")){
			this.preco = 85.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 90.00")){
			this.preco = 90.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 95.00")){
			this.preco = 95.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 100.00")){
			this.preco = 100.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 120.00")){
			this.preco = 120.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 125.00")){
			this.preco = 125.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 130.00")){
			this.preco = 130.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 150.00")){
			this.preco = 150.00;
		}else if(comboBoxPreco.getSelectedItem().toString().equals("R$ 200.00")){
			this.preco = 200.00;
		}
	}
	
	private void cadastraRoupas(){
			roupa = new Roupas(tipo, fabricante, sexo, tamanho, textCodigoDeBarras.getText().toString(), preco);
			
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
