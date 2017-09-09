import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeRoupasParaLojas implements GerenciadorDeRoupas {
	
		private List<Roupas> roupas;
		
	public GerenciadorDeRoupasParaLojas(){
		this.roupas = new ArrayList<Roupas>();
	}

	@Override
	public void cadastraRoupas(Roupas r) {
		this.roupas.add(r);
		
	}

	@Override
	public List<Roupas> pesquisaRoupas() {
		return this.roupas;
	}

	@Override
	public List<Roupas> pesquisaRoupasDofabricante() throws FabricanteInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		boolean achou = false;
		for(Roupas ro : this.roupas){
			if(ro.getFabricante().equals(fabricante)){
				r.add(ro);
				achou = true;
			}
		}
		if(!achou){
			throw new FabricanteInexistenteException("Esse fabricante não existe!");
		}
		return r;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTamanho() throws TamanhoInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		boolean achou = false;
		for(Roupas ro : this.roupas){
			if(ro.getTamanho().equals(tamanho)){
				r.add(ro);
				achou = true;
			}
		}
		if(!achou){
			throw new TamanhoInexistenteException("Esse tamanho não existe!");
		}
		return r;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorSexo() throws SexoInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		boolean achou = false;
		for(Roupas ro : this.roupas){
			if(ro.getSexo().equals(sexo)){
				r.add(ro);
				achou = true;
			}
		}
		if(!achou){
			throw new SexoInexistenteException("Esse sexo não existe!");
		}
		return r;	
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTipo() throws TipoInexistenteException {
		List<Roupas> r = new ArrayList<Roupas>();
		boolean achou = false;
		for(Roupas ro : this.roupas){
			if(ro.getTipo().equals(tipo)){
				r.add(ro);
				achou = true;
			}
		}
		if(!achou){
			throw new TipoInexistenteException("Esse tipo de roupa não existe!");
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
		boolean achou = false;
		for(Roupas r : this.roupas){
			if(r.getFabricante().equals(fabricante) && r.getTamanho().equals(tamanho) && r.getSexo().equals(sexo) && r.getTipo().equals(tipo)){
				this.roupas.remove(r);
				achou = true;
			}
		}
		if(!achou){
			throw new RoupaInexistenteException("Essa roupa não existe!");
		}
		
	}

}
