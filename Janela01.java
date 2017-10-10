import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

//import GerenciadorFrame.EntrarAction;

public class janela01 extends JFrame{//JInternalFrame {
    private GerenciadorDeRoupasParaLojas gerenciador;
    //janela01 frame = new janela01();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    janela01 frame = new janela01();
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

    /**
     * Create the frame.
     */
    public janela01() {
        
        this.gerenciador = new GerenciadorDeRoupasParaLojas();
       
        
        
        setBounds(100, 100, 450, 300);
        //setBounds(1000, 200, 450, 300);
        getContentPane().setLayout(null);
        
        JLabel opcao = new JLabel("Gerenciador de Roupas");
        opcao.setBackground(Color.WHITE);
        opcao.setForeground(Color.BLACK);
        opcao.setFont(new Font("Verdana", Font.BOLD, 26));
        opcao.setBounds(156, 33, 373, 40);
        getContentPane().add(opcao);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 82, 21);
        getContentPane().add(menuBar);
        

        JMenu mnPesquisar = new JMenu("Pesquisa");
        mnPesquisar.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\search (2).png"));
        menuBar.add(mnPesquisar);
        
                
                JMenuItem mnTodasAsRoupas = new JMenuItem("Todas as Roupas");
                mnTodasAsRoupas.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
                
                mnTodasAsRoupas.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        pesquisarTodasAsRoupas();
                    }
                });
                mnPesquisar.add(mnTodasAsRoupas);
                
                JMenuItem mntmPorTipo = new JMenuItem("Por Tipo");
                mntmPorTipo.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
                
                mntmPorTipo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        pesquisaRoupasPorTipo();
                    }
                });
                mnPesquisar.add(mntmPorTipo);
                
                JMenuItem mntmPorFabricante = new JMenuItem("Por Fabricante");
                mntmPorFabricante.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
                mntmPorFabricante.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisaRoupasPorFabricante();
                    }
                });
                mnPesquisar.add(mntmPorFabricante);
                
                JMenu mnNewMenu = new JMenu("Por Sexo");
                mnNewMenu.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
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
                mntmPorTamanho.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
                mntmPorTamanho.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pesquisaRoupasPorTamanho();
                    }
                });
                mnPesquisar.add(mntmPorTamanho);
                
                JMenuItem mntmPeloCdigoDe = new JMenuItem("Pelo Código de Barras");
                mntmPeloCdigoDe.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
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
                mntmQuantidadeDeRoupas.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\file.png"));
                mnPesquisar.add(mntmQuantidadeDeRoupas);
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setIcon(new ImageIcon(janela01.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarRoupa();
            }
        });
        btnCadastrar.setBounds(259, 165, 120, 23);
        getContentPane().add(btnCadastrar);
        
        JButton btnRemover = new JButton("Remover");
        btnRemover.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\delete.png"));
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removerRoupa();
            }
        });
        btnRemover.setBounds(259, 217, 120, 23);
        getContentPane().add(btnRemover);
        
        JMenuBar menuBar_1 = new JMenuBar();
        menuBar_1.setBounds(80, 0, 50, 21);
        getContentPane().add(menuBar_1);
        
        JMenu mnAjuda = new JMenu("Ajuda");
        menuBar_1.add(mnAjuda);
        
        JMenuItem mntmSobre = new JMenuItem("Sobre...");
        mntmSobre.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\info.png"));
        mntmSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sobre();
            }
        });
        mnAjuda.add(mntmSobre);
        
        JMenuItem mntmSair = new JMenuItem("Sair");
        mntmSair.setIcon(new ImageIcon(janela01.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
        mntmSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            sairDoPrograma();
            }
        });
        mnAjuda.add(mntmSair);
        
        JLabel lblImagem = new JLabel("imagem");
        lblImagem.setIcon(new ImageIcon("C:\\Users\\william\\Desktop\\Arquivos eclipse\\01-decoração-loja-roupas.jpg"));
        lblImagem.setBounds(0, 0, 687, 437);
        getContentPane().add(lblImagem);

    
    
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
         String tip = JOptionPane.showInputDialog("Informe o tipo da roupa que deseja encontrar:");
                 try{
                	 String texto = "\n";
                     for(Roupas r: gerenciador.pesquisaRoupasPorTipo(tip.toUpperCase())){
                    	 texto += r.toString() + "\n\n";
                     }
                     JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorTipo(tip.toUpperCase()).size()+" roupa(s)\n" + texto);

                 }catch(TipoInexistenteException e){
                     JOptionPane.showMessageDialog(null,e.getMessage());
                  }

         
        
    }
    private void pesquisaRoupasPorFabricante() {
        String fab = JOptionPane.showInputDialog("Informe o fabricante da roupa que deseja encontrar:");
              try{
            	  String texto = "\n";
                  for(Roupas r: gerenciador.pesquisaRoupasDofabricante(fab.toUpperCase())){
                	  texto += r.toString()+"\n\n";
                  }
                  JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasDofabricante(fab.toUpperCase()).size()+" roupa(s)\n" + texto);

              }catch(FabricanteInexistenteException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
              }

    }
    private void pesquisaRoupasPorTamanho() {
        String tam = JOptionPane.showInputDialog("Informe o tamanho da roupa que deseja encontrar:");
              try{
            	  String texto = "\n";
                  for(Roupas r: gerenciador.pesquisaRoupasPorTamanho(tam)){
                	  texto += r.toString() + "\n\n";
                  }
                  JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorTamanho(tam).size()+" roupa(s)\n" + texto);

              }catch(TamanhoInexistenteException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
              }

    }
    private void pesquisaRoupasPeloCodigoDeBarras(){
         String cod = JOptionPane.showInputDialog("Informe o código de barras da roupa que deseja encontrar:");
                  try{
                     JOptionPane.showMessageDialog(null, gerenciador.pesquisaRoupasPorCodigo(cod));
                     
                  }catch(CodigoDeBarrasInexistenteException e){
                     JOptionPane.showMessageDialog(null,e.getMessage());
                  }

    }
    private void cadastrarRoupa() {
    	janela02 janela2 = new janela02(gerenciador);
        janela2.setSize(630, 460);
        janela2.setResizable(false);
    	janela2.setVisible(true);
    	janela2.setLocationRelativeTo(null);
    	//dispose();

    }
    private void removerRoupa() {
         String codigoBarras = JOptionPane.showInputDialog("Informe o código de barras para poder remover a roupa:");
              try{
                   gerenciador.removeRoupas(codigoBarras);
                   JOptionPane.showMessageDialog(null,"Roupa removida com sucesso!");
                   
              }catch(RoupaInexistenteException e){
                  JOptionPane.showMessageDialog(null,e.getMessage());
               }

    }
    Sexo se = null;
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
    private void sobre(){
        JOptionPane.showMessageDialog(null, "Programa de Gerenciamento de Estoque para Loja de Roupas\n\nPrograma criado por:\nAnderson Cosme dos Santos\nWelyson Jerônimo Santos\nReinaldo da Veiga Lima\n\nPrograma para a aula de POO ministrada pela professora\nAyla Débora Dantas de Souza Rebouças", "Sobre...", JOptionPane.PLAIN_MESSAGE);
            
    }
    private void sairDoPrograma(){
        System.exit(0);
    }
}

