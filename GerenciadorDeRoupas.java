import java.util.List;

public interface GerenciadorDeRoupas {

	public void cadastraRoupas(Roupas r);
	
	public 	List<Roupas> pesquisaRoupas();
	
	public 	List<Roupas> pesquisaRoupasDofabricante(String fabricante) throws FabricanteInexistenteException;
	
	public 	List<Roupas> pesquisaRoupasPorTamanho(String tamanho) throws TamanhoInexistenteException;
	
	public 	List<Roupas> pesquisaRoupasPorSexo(String sexo) throws SexoInexistenteException;
	
	public 	List<Roupas> pesquisaRoupasPorTipo(String tipo) throws TipoInexistenteException;
	
	public int informaQuantidadeDeRoupasCadastradas();
	
	public void removeRoupas(String tipo, String fabricante, String tamanho, String sexo) throws RoupaInexistenteException;;

}


