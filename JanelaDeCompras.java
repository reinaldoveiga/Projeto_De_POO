import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JanelaDeCompras extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigoDeBarras;
	private GerenciadorDeRoupasParaLojas gerenciador;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDeCompras2 frame = new JanelaDeCompras2();
					frame.setVisible(true);
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
	public JanelaDeCompras(GerenciadorDeRoupasParaLojas gerenciador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 448);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		this.gerenciador = gerenciador;
		
		JLabel lblCdigoDeBarras = new JLabel(" Digite aqui o código de Barras\r\n para realizar a sua compra");
		lblCdigoDeBarras.setFont(new Font("Arial", Font.BOLD, 13));
		lblCdigoDeBarras.setBackground(Color.WHITE);
		lblCdigoDeBarras.setForeground(Color.WHITE);
		lblCdigoDeBarras.setBounds(113, 11, 438, 64);
		getContentPane().add(lblCdigoDeBarras);
		

		textCodigoDeBarras = new JTextField();
		/*textCodigoDeBarras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});*/
		textCodigoDeBarras.setBackground(Color.WHITE);
		textCodigoDeBarras.setBounds(166, 152, 268, 19);
		getContentPane().add(textCodigoDeBarras);
		textCodigoDeBarras.setColumns(10);

		//Botões
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setIcon(new ImageIcon(JanelaDeCompras.class.getResource("/imagensProjeto/coin.png")));
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				compraRoupas();
				textCodigoDeBarras.setText("");
				}
			});
			btnComprar.setBounds(56, 295, 123, 25);
			getContentPane().add(btnComprar);
			
			JButton btnCarrinho = new JButton("Adicionar ao carrinho");
			btnCarrinho.setIcon(new ImageIcon(JanelaDeCompras.class.getResource("/imagensProjeto/shopping-cart-of-checkered-design.png")));
			btnCarrinho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					carrinhoDeCompras();
					textCodigoDeBarras.setText("");
				}
			});
			btnCarrinho.setBounds(217, 295, 198, 25);
			getContentPane().add(btnCarrinho);
				
			JButton btnVoltar = new JButton("Voltar");
			btnVoltar.setIcon(new ImageIcon(JanelaDeCompras.class.getResource("/imagensProjeto/back-arrow (1).png")));
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					voltar();
				}
			});
			btnVoltar.setBounds(446, 295, 117, 25);
			getContentPane().add(btnVoltar);
			
			JLabel lblFundocodigodebarras = new JLabel("fundoCodigoDeBarras");
			lblFundocodigodebarras.setIcon(new ImageIcon(JanelaDeCompras.class.getResource("/imagensProjeto/cc3b3digo-inicial.png")));
			lblFundocodigodebarras.setBounds(179, 77, 255, 52);
			contentPane.add(lblFundocodigodebarras);
			
			JLabel lblFunfojanelacompras = new JLabel("FunfoJanelaCompras2");
			lblFunfojanelacompras.setIcon(new ImageIcon(JanelaDeCompras.class.getResource("/imagensProjeto/fundoParaJanela2.jpg")));
			lblFunfojanelacompras.setBounds(100, 0, 406, 206);
			contentPane.add(lblFunfojanelacompras);
			
			JLabel lblFundoprincipaljaneladecompras = new JLabel("fundoPrincipalJanelaDeCompras");
			lblFundoprincipaljaneladecompras.setIcon(new ImageIcon(JanelaDeCompras.class.getResource("/imagensProjeto/bosas-carro-compras.png")));
			lblFundoprincipaljaneladecompras.setBounds(0, -73, 1038, 635);
			contentPane.add(lblFundoprincipaljaneladecompras);
				

	}
	
	private void compraRoupas(){
		String opcao = JOptionPane.showInputDialog("Digite a opção de compra abaixo\n\n1.Roupas direto\n2.Roupas do carrinho de compras");
		if(opcao == null){
			
		}else if(opcao.equals("1")){
			try{
				gerenciador.valorTotalComprasEPreparaRelatorio(textCodigoDeBarras.getText().toString());
						}catch(CodigoDeBarrasInexistenteException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}else if(opcao.equals("2")){
			gerenciador.compraCarrinhoEPreparaRelatorio();
		}else{
			JOptionPane.showMessageDialog(null,"Opção inválida!");
		}
	}
	
	private void carrinhoDeCompras(){
		try{
    		gerenciador.comprasPorCodigoDeBarrasParaCarrinho(textCodigoDeBarras.getText().toString());
    	}catch(CodigoDeBarrasInexistenteException e){
    		JOptionPane.showMessageDialog(null, e.getMessage());
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
