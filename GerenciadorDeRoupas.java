import java.util.List;

public interface GerenciadorDeRoupas {

	public void cadastraRoupas(Roupas r);
	
	public 	List<Roupas> pesquisaRoupas();
	
	public 	List<Roupas> pesquisaRoupasDofabricante() throws FabricanteInexistenteException;
	
	public 	List<Roupas> pesquisaRoupasPorTamanho() throws TamanhoInexistenteException;
	
	public 	List<Roupas> pesquisaRoupasPorSexo() throws SexoInexistenteException;
	
	public 	List<Roupas> pesquisaRoupasPorTipo() throws TipoInexistenteException;
	
	public int informaQuantidadeDeRoupasCadastradas();
	
	public void removeRoupas(String tipo, String fabricante, String tamanho, String sexo) throws RoupaInexistenteException;;

}


