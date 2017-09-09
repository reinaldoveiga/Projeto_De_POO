import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRoupasParaLojas implements GerencidorDeRoupas {
	
		private List<Roupas> roupas;
		
	public GerenciadorDeRoupasParaLojas(){
		
		this.roupas = new ArrayList<Roupas>();
	}

	@Override
	public void cadastraRoupas(Roupas r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Roupas> pesquisaRoupas() throws RoupaInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roupas> pesquisaRoupasDofabricante() throws FabricanteInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTamanho() throws TamanhoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorSexo() throws SexoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTipo() throws TipoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int informaQuantidadeDeRoupasCadastradas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeRoupas(String tipo, String fabricante, String tamanho, String sexo)
			throws RoupaInexistenteException {
		// TODO Auto-generated method stub
		
	}

}
