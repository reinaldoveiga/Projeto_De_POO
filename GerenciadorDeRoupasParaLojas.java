package projeto.ufpb.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GerenciadorDeRoupasParaLojas implements GerenciadorDeRoupas{

    private Map<String, Roupas> roupas;
    private Gravador gravador;
    
    public GerenciadorDeRoupasParaLojas() {
        this.roupas = new TreeMap<>();
        this.gravador = new Gravador();
        for(int k=0; k<gravador.recuperarRoupas().size();k++){
        	this.roupas.put(gravador.recuperarRoupas().get(k).getCodDeBarras(), gravador.recuperarRoupas().get(k));
        }
    }
    
    @Override
    public void cadastraRoupas(Roupas r) throws RoupaJaExisteException, RoupaInvalidaException{
        if(r.getFabricante().equals("")||r.getTamanho().equals("")||r.getTipo().equals("")||r.getCodDeBarras().equals("")||r.getSexo()==null){
            throw new RoupaInvalidaException("Roupa Inválida:" + r.getCodDeBarras());

        }
        
        else if(roupas.containsKey(r.getCodDeBarras())) {
        	
            throw new RoupaJaExisteException("Já existe uma roupa com esse código de barras:" + r.getCodDeBarras());
        }else{
            this.roupas.put(r.getCodDeBarras(), r);
        }
    }

    @Override
    public List<Roupas> pesquisaRoupas() {
        List<Roupas> r = new ArrayList<Roupas>(this.roupas.values());
        return r;
    }

    @Override
    public List<Roupas> pesquisaRoupasDofabricante(String fabricante) throws FabricanteInexistenteException {
        List<Roupas> listFabricante = new ArrayList<>();
        boolean achou = false;

        for(Roupas f : this.roupas.values()) {
            if (f.getFabricante().equals(fabricante)) {
                listFabricante.add((Roupas) f);
                achou = true;
            }
        }
        if (!(achou)) {
            throw new FabricanteInexistenteException("Esse fabricante não existe: "+fabricante);
        }
        return listFabricante;
    }

    @Override
    public List<Roupas> pesquisaRoupasPorTamanho(String tamanho) throws TamanhoInexistenteException {
        List<Roupas> listTamanho = new ArrayList<>();
        boolean achou = false;

        for(Roupas t : this.roupas.values()) {
            if (t.getTamanho().equals(tamanho)) {
                listTamanho.add((Roupas) t);
                achou = true;
            }
        }
        if (!(achou)) {
            throw new TamanhoInexistenteException("Esse tamanho não existe: "+tamanho);
        }
        return listTamanho;
        
    }

    @Override
    public List<Roupas> pesquisaRoupasPorSexo(Sexo sexo) throws SexoInexistenteException {
        List<Roupas> listSexo = new ArrayList<>();
        boolean achou = false;

        for(Roupas s : this.roupas.values()) {
            if (s.getSexo().equals(sexo)) {
                listSexo.add((Roupas) s);
                achou = true;
            }
        }
        if (!(achou)) {
            throw new SexoInexistenteException("Esse sexo não existe: "+sexo);
        }
        return listSexo;
    }

    @Override
    public List<Roupas> pesquisaRoupasPorTipo(String tipo) throws TipoInexistenteException {
        List<Roupas> listTipo = new ArrayList<>();
        boolean achou = false;

        for(Roupas t : this.roupas.values()) {
            if (t.getTipo().equals(tipo)) {
                listTipo.add((Roupas) t);
                achou = true;
            }
        }
        if (!(achou)) {
            throw new TipoInexistenteException("Esse tipo de roupa não existe: "+tipo);
        }
        return listTipo;
    }
    
    @Override
    public Roupas pesquisaRoupasPorCodigo(String codigo) throws CodigoDeBarrasInexistenteException {
        if (!(roupas.containsKey(codigo))) {
            throw new CodigoDeBarrasInexistenteException("Não existe roupa com esse código: "+codigo);
        }
        return this.roupas.get(codigo);
    }
    
    @Override
    public int informaQuantidadeDeRoupasCadastradas() {
        int quant = this.roupas.size();
        return quant;
    }

    @Override
    public void removeRoupas(String codigo) throws RoupaInexistenteException {
        if (!(roupas.containsKey(codigo))) {
            throw new RoupaInexistenteException("Não existe roupa com esse código: "+codigo);
        }
        this.roupas.remove(codigo);
        gravador.gravaRoupas(pesquisaRoupas());//regrava já sem a roupa removida
    }
    

}
