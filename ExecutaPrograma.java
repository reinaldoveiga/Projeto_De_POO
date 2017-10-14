import javax.swing.JFrame;

public class ExecutaPrograma {

	public static void main(String[] args) {
		GerenciadorDeRoupasParaLojas gerenciador = new GerenciadorDeRoupasParaLojas();
		JanelaPrincipal j = new JanelaPrincipal();
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(530, 260);
        	j.setSize(630, 460);
		j.setVisible(true);
		j.setLocationRelativeTo(null);
        	j.setVisible(true);
        	j.setResizable(false);
        
	}

}
