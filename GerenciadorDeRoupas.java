
import java.util.List;

public interface GerenciadorDeRoupas {

    public void cadastraRoupas(Roupas r) throws RoupaJaExisteException, RoupaInvalidaException;
    
    public List<Roupas> pesquisaRoupas();
    
    public Roupas pesquisaRoupasPorCodigo(String codigo) throws CodigoDeBarrasInexistenteException;
    
    public List<Roupas> pesquisaRoupasDofabricante(String fabricante) throws FabricanteInexistenteException;
    
    public List<Roupas> pesquisaRoupasPorTamanho(String tamanho) throws TamanhoInexistenteException;
    
    public List<Roupas> pesquisaRoupasPorSexo(Sexo sexo) throws SexoInexistenteException;
    
    public List<Roupas> pesquisaRoupasPorTipo(String tipo) throws TipoInexistenteException;
    
    public int informaQuantidadeDeRoupasCadastradas();
    
    public void removeRoupas(String codigo) throws RoupaInexistenteException;
    
    public void comprasPorCodigoDeBarrasParaCarrinho(String codigo) throws CodigoDeBarrasInexistenteException;
	
    public void compraCarrinhoEPreparaRelatorio();
    
    public void valorTotalComprasEPreparaRelatorio(String codigo)throws CodigoDeBarrasInexistenteException;
    
    public double rendaDiaria(int dia);
	
    public double rendaMensal(int mes);
	
    public double rendaAnual(int ano);
    
}
