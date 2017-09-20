import java.util.List;

public interface GerenciadorDeRoupas {

    public void cadastraRoupas(Roupas r) throws RoupaJaExisteException;
    
    public List<Roupas> pesquisaRoupas();
    
    public Roupas pesquisaRoupasPorCodigo(String codigo) throws CodigoDeBarrasInexistenteException;
    
    public List<Roupas> pesquisaRoupasDofabricante(String fabricante) throws FabricanteInexistenteException;
    
    public List<Roupas> pesquisaRoupasPorTamanho(String tamanho) throws TamanhoInexistenteException;
    
    public List<Roupas> pesquisaRoupasPorSexo(Sexo sexo) throws SexoInexistenteException;
    
    public List<Roupas> pesquisaRoupasPorTipo(String tipo) throws TipoInexistenteException;
    
    public int informaQuantidadeDeRoupasCadastradas();
    
    public void removeRoupas(String codigo) throws RoupaInexistenteException;
    
}
