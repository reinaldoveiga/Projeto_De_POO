import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;


public class JanelaPrincipal extends JFrame{
     GerenciadorDeRoupasParaLojas gerenciador = new GerenciadorDeRoupasParaLojas();  
     Gravador gravador = new Gravador();
     Sexo se = null;
    
    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaPrincipal frame = new JanelaPrincipal();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(630, 460);
                   // frame.setVisible(true);
                    //frame.setState(JFrame.NORMAL);
                    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    frame.setResizable(false);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
*/
    /**
     * Create the frame.
     */
    public JanelaPrincipal(){
    menu();
    
    }
    public JanelaPrincipal(GerenciadorDeRoupasParaLojas gerenciador)  {
        
      this.gerenciador = gerenciador;
      menu();
      
      
    }
      public void menu(){
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
        
        
        JLabel opcao = new JLabel("Gerenciador de Roupas");
        opcao.setBackground(Color.WHITE);
        opcao.setForeground(Color.BLACK);
        opcao.setFont(new Font("Arial", Font.BOLD, 30));
        opcao.setBounds(140, 157, 373, 40);
        getContentPane().add(opcao);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(270, 0, 92, 21);
        getContentPane().add(menuBar);
        

        JMenu mnPesquisar = new JMenu("Pesquisar");
        mnPesquisar.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/search.png")));
        menuBar.add(mnPesquisar);
        
                
                JMenuItem mnTodasAsRoupas = new JMenuItem("Todas as Roupas");
                mnTodasAsRoupas.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                
                mnTodasAsRoupas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        pesquisarTodasAsRoupas();
                    }
                });
                mnPesquisar.add(mnTodasAsRoupas);
                
                JMenuItem mntmPorTipo = new JMenuItem("Por Tipo");
                mntmPorTipo.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                
                mntmPorTipo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        pesquisaRoupasPorTipo();
                    }
                });
                mnPesquisar.add(mntmPorTipo);
                
                JMenuItem mntmPorFabricante = new JMenuItem("Por Fabricante");
                mntmPorFabricante.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                mntmPorFabricante.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisaRoupasPorFabricante();
                    }
                });
                mnPesquisar.add(mntmPorFabricante);
                
                JMenu mnNewMenu = new JMenu("Por Sexo");
                mnNewMenu.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                mnPesquisar.add(mnNewMenu);
                
                JMenuItem mntmMasculino = new JMenuItem("Masculino");
                mntmMasculino.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisarRoupaPeloSexoMasculino();
                    }
                });
                mnNewMenu.add(mntmMasculino);
                
                JMenuItem mntmFeminino = new JMenuItem("Feminino");
                mntmFeminino.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisarRoupaPeloSexoFeminino();
                    }
                });
                mnNewMenu.add(mntmFeminino);
                
                JMenuItem mntmUnisex = new JMenuItem("Unisex");
                mntmUnisex.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisarRoupaPeloSexoUnisex();
                    }
                });
                mnNewMenu.add(mntmUnisex);
                
                JMenuItem mntmPorTamanho = new JMenuItem("Por Tamanho");
                mntmPorTamanho.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                mntmPorTamanho.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisaRoupasPorTamanho();
                    }
                });
                mnPesquisar.add(mntmPorTamanho);
                
                JMenuItem mntmPeloCdigoDe = new JMenuItem("Pelo Código de Barras");
                mntmPeloCdigoDe.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                mntmPeloCdigoDe.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisaRoupasPeloCodigoDeBarras();
                    }
                });
                mnPesquisar.add(mntmPeloCdigoDe);
                
                JMenuItem mntmQuantidadeDeRoupas = new JMenuItem("Quantidade de Roupas");
                mntmQuantidadeDeRoupas.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                        QuantidadeRoupas();

                	}
                });
                mntmQuantidadeDeRoupas.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
                mnPesquisar.add(mntmQuantidadeDeRoupas);
        
        JButton btnRemover = new JButton("Remover");
        btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 9));
        btnRemover.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/delete.png")));
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerRoupa();
            }
        });
        btnRemover.setBounds(172, 0, 98, 21);
        getContentPane().add(btnRemover);
        
        JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(360, 0, 70, 21);
        
        getContentPane().add(menuBar_1);
        
        JMenu mnAjuda = new JMenu("Ajuda");
        mnAjuda.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/help.png")));
        menuBar_1.add(mnAjuda);
        
        JMenuItem mntmSobre = new JMenuItem("Sobre...");
        mntmSobre.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/info.png")));
        mntmSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sobre();
            }
        });
        mnAjuda.add(mntmSobre);
        
        JMenuItem mntmSair = new JMenuItem("Sair");
        mntmSair.setIcon(new ImageIcon(janela01.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
        mntmSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            sairDoPrograma();
            }
        });
        mnAjuda.add(mntmSair);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(75, 0, 98, 21);
        getContentPane().add(btnCadastrar);
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 9));
        btnCadastrar.setIcon(new ImageIcon(janela01.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
        
        JMenuBar menuBar_2 = new JMenuBar();
        menuBar_2.setBounds(0, 0, 75, 21);
        getContentPane().add(menuBar_2);
        
        JMenu mnArquivo = new JMenu("Arquivo");
        mnArquivo.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
        menuBar_2.add(mnArquivo);
        
        JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
        mntmCadastrar.setIcon(new ImageIcon(janela01.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
        mntmCadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                cadastrarRoupa();

        	}
        });
        mnArquivo.add(mntmCadastrar);
        
        JMenuItem mntmRemover = new JMenuItem("Remover");
        mntmRemover.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/delete.png")));
        mntmRemover.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                removerRoupa();

        	}
        });
        mnArquivo.add(mntmRemover);
        
        JMenuItem mntmRecuperarRoupas = new JMenuItem("Recuperar Roupas");
        mntmRecuperarRoupas.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/file.png")));
        mntmRecuperarRoupas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		recuperaRoupas();
        	}
        });
        mnArquivo.add(mntmRecuperarRoupas);
        
        JMenuItem mntmSair_1 = new JMenuItem("Sair");
        mntmSair_1.setIcon(new ImageIcon(janela01.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
        mntmSair_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		sairDoPrograma();
        	}
        });
        mnArquivo.add(mntmSair_1);
        
        JLabel lblFundoprincipal = new JLabel("fundoPrincipal");
        lblFundoprincipal.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/fundoNomeTelaPrincipal.jpg")));
        lblFundoprincipal.setBounds(130, 157, 360, 40);
        getContentPane().add(lblFundoprincipal);
        
        JLabel lblImagemprincipal = new JLabel("imagemPrincipal");
        lblImagemprincipal.setIcon(new ImageIcon(janela01.class.getResource("/imagensProjeto/TelaPrincipal.png")));
        lblImagemprincipal.setBounds(-112, 0, 776, 434);
        getContentPane().add(lblImagemprincipal);
        
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarRoupa();
            }
        });

    
    
    }
   
 

    private void pesquisarTodasAsRoupas() {
         if(gerenciador.informaQuantidadeDeRoupasCadastradas() == 0){
                 JOptionPane.showMessageDialog(null, gerenciador.informaQuantidadeDeRoupasCadastradas()+" roupa(s) cadastrada(s)");
         }else{
        	 String texto = "\n";
        	 for(Roupas r : gerenciador.pesquisaRoupas()){
        		texto += r.toString() + "\n\n"; 
        	 }
        	 JOptionPane.showMessageDialog(null, gerenciador.informaQuantidadeDeRoupasCadastradas()+" roupa(s)\n" +  texto);
         }
    }
    private void pesquisaRoupasPorTipo() {
    	String tipo = JOptionPane.showInputDialog("Informe o tipo da roupa que deseja encontrar:");
        if(tipo == null){
        	 
        }else{
        try{
        	String texto = "\n";
            for(Roupas r: gerenciador.pesquisaRoupasPorTipo(tipo.toUpperCase())){
            	texto += r.toString() + "\n\n";
            }
            JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorTipo(tipo.toUpperCase()).size()+" roupa(s)\n" + texto);

        }catch(TipoInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        	} 
         }
    }
    private void pesquisaRoupasPorFabricante() {
        String fabricante = JOptionPane.showInputDialog("Informe o fabricante da roupa que deseja encontrar:");
        if(fabricante == null){
       	 
        }else{      
        try{
        	String texto = "\n";
        	for(Roupas r: gerenciador.pesquisaRoupasDofabricante(fabricante.toUpperCase())){
        		texto += r.toString()+"\n\n";
            }
            JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasDofabricante(fabricante.toUpperCase()).size()+" roupa(s)\n" + texto);

        }catch(FabricanteInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        	}
        }
    }
    private void pesquisaRoupasPorTamanho() {
        String tamanho = JOptionPane.showInputDialog("Informe o tamanho da roupa que deseja encontrar:");
        if(tamanho == null){
       	 
        }else{
        try{
            String texto = "\n";
            for(Roupas r: gerenciador.pesquisaRoupasPorTamanho(tamanho)){
            	texto += r.toString() + "\n\n";
            }
            JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorTamanho(tamanho).size()+" roupa(s)\n" + texto);
              
        }catch(TamanhoInexistenteException e){     
        	JOptionPane.showMessageDialog(null,e.getMessage());
              }
        }
    }
    private void pesquisaRoupasPeloCodigoDeBarras(){
         String codDeBarras = JOptionPane.showInputDialog("Informe o código de barras da roupa que deseja encontrar:");
         if(codDeBarras == null){
           	 
         }else{         
         try{        
        	 JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorCodigo(codDeBarras));
           
         }catch(CodigoDeBarrasInexistenteException e){
        	 JOptionPane.showMessageDialog(null,e.getMessage());
                  
         	}
         }
    }
    
    private void QuantidadeRoupas() {
           JOptionPane.showMessageDialog(null, "Estão cadastradas " + gerenciador.informaQuantidadeDeRoupasCadastradas()+" roupa(s).");

    }
    private void pesquisarRoupaPeloSexoMasculino(){
        se = se.MASCULINO;
              try {
            	  String texto = "\n";
                  for(Roupas r: gerenciador.pesquisaRoupasPorSexo(se)){
                	  texto += r.toString() + "\n\n";
                  }
                  JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorSexo(se).size()+" roupa(s)\n" + texto);

              }catch (SexoInexistenteException e) {
                 JOptionPane.showMessageDialog(null,e.getMessage());
              }

    }
    private void pesquisarRoupaPeloSexoFeminino(){
             se = se.FEMININO;
              try {
            	  String texto = "\n";
                  for(Roupas r: gerenciador.pesquisaRoupasPorSexo(se)){
                	  texto += r.toString() + "\n\n";
                  }
                  JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorSexo(se).size()+" roupa(s)\n" + texto);

              }catch (SexoInexistenteException e) {
                 JOptionPane.showMessageDialog(null,e.getMessage());
              }

    }
    private void pesquisarRoupaPeloSexoUnisex(){
         se = se.UNISEX;
                  try {
                	  String texto = "\n";
                      for(Roupas r: gerenciador.pesquisaRoupasPorSexo(se)){
                    	  texto += r.toString() + "\n\n";
                      }
                      JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorSexo(se).size()+" roupa(s)\n" + texto);

                  }catch (SexoInexistenteException e) {
                     JOptionPane.showMessageDialog(null,e.getMessage());
                  }

    }
    private void recuperaRoupas(){
    	try{
    	      for(int k=0; k<gravador.recuperaTextoDeArquivo("Roupas.txt").size();k++){
    	    	  System.out.println(gravador.recuperaTextoDeArquivo("Roupas.txt").get(k));
    	      }
    	      }catch(IOException e){
    	    	  
    	      }
    }
    private void sobre(){
        JOptionPane.showMessageDialog(null, "Programa de Gerenciamento de Estoque para Loja de Roupas\n\nPrograma criado por:\nAnderson Cosme dos Santos\nWelyson Jerônimo Santos\nReinaldo da Veiga Lima\n\nPrograma para a aula de POO ministrada pela professora\nAyla Débora Dantas de Souza Rebouças", "Sobre...", JOptionPane.PLAIN_MESSAGE);
            
    }
    private void cadastrarRoupa() {
    	try{
    		gravador.recuperaTextoDeArquivo("Roupas.txt");
    	}catch(IOException e){
    		
    	}
    	JanelaPrincipal j = new JanelaPrincipal(gerenciador);
 
    	Janela2 janela2 = new Janela2(gerenciador);
        janela2.setSize(630, 460);
        janela2.setResizable(false);
    	janela2.setVisible(true);
    	janela2.setLocationRelativeTo(null);
    	
    	dispose();

    }
    private void removerRoupa() {
         String codigoBarras = JOptionPane.showInputDialog("Informe o código de barras para poder remover a roupa:");
            if(codigoBarras == null){
            	
            }else{
         	try{
                   gerenciador.removeRoupas(codigoBarras);
                   JOptionPane.showMessageDialog(null,"Roupa removida com sucesso!");
                   
              }catch(RoupaInexistenteException e){
                  JOptionPane.showMessageDialog(null,e.getMessage());
               }
            }
    }
    private void sairDoPrograma(){
        System.exit(0);
    }
}

