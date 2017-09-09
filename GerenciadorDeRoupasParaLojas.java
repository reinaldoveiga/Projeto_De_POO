import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRoupasParaLojas implements GerencidorDeRoupas {
	
		private List<Roupas> roupas;
		
	public GerenciadorDeRoupasParaLojas(){
		
		this.roupas = new ArrayList<Roupas>();
	}

	@Override
	public void cadastraRoupas(Roupas r) {
		this.roupas.add(r);
		
	}

	@Override
	public List<Roupas> pesquisaRoupas() throws RoupaInexistenteException {
		return this.roupas;
	}

	@Override
	public List<Roupas> pesquisaRoupasDofabricante() throws FabricanteInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		for(Roupas ro : this.roupas){
			if(ro.getFabricante().equals(fabricante)){
				r.add(ro);
			}
		}
		return r;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTamanho() throws TamanhoInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		for(Roupas ro : this.roupas){
			if(ro.getTamanho().equals(tamanho)){
				r.add(ro);
			}
		}
		return r;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorSexo() throws SexoInexistenteException {
List<Roupas> r = new ArrayList<Roupas>();
		for(Roupas ro : this.roupas){
			if(ro.getSexo().equals(sexo)){
				r.add(ro);
			}
		}
		return r;	}

	@Override
	public List<Roupas> pesquisaRoupasPorTipo() throws TipoInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		for(Roupas ro : this.roupas){
			if(ro.getTipo().equals(tipo)){
				r.add(ro);
			}
		}
		return r;
	}

	@Override
	public int informaQuantidadeDeRoupasCadastradas() {
		int quantidade = this.roupas.size();
		return quantidade;
	}

	@Override
	public void removeRoupas(String tipo, String fabricante, String tamanho, String sexo)
			throws RoupaInexistenteException {
		for(Roupas r : this.roupas){
			if(r.getFabricante().equals(fabricante) && r.getTamanho().equals(tamanho) && r.getSexo().equals(sexo) && r.getTipo().equals(tipo)){
				this.roupas.remove(r);
			}
		}b
		
	}

}
