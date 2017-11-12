
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

public class GerenciadorDeRoupasParaLojas implements GerenciadorDeRoupas {

	private Map<String, Roupas> roupas;
	private List<Relatorio> renda;
	private List<Roupas> roupasCompradasCarrinho;
	private Gravador gravador;
	private double valorComprasCarrinho;
	

	public GerenciadorDeRoupasParaLojas() {
		this.roupas = new TreeMap<>();
		this.renda = new ArrayList<Relatorio>();
		this.roupasCompradasCarrinho = new ArrayList<Roupas>();
		this.gravador = new Gravador();
		this.valorComprasCarrinho = 0;
		
		for (int k = 0; k < gravador.recuperarRoupas().size(); k++) {
			this.roupas.put(gravador.recuperarRoupas().get(k).getCodDeBarras(), gravador.recuperarRoupas().get(k));
		}
		for (int k = 0; k < gravador.recuperarRelatorio().size(); k++) {
			this.renda.add( gravador.recuperarRelatorio().get(k));
		}
	}

	@Override
	public void cadastraRoupas(Roupas r) throws RoupaJaExisteException, RoupaInvalidaException {
		if (r.getFabricante().equals("") || r.getTamanho().equals("") || r.getTipo().equals("")
				|| r.getCodDeBarras().equals("") || r.getSexo() == null) {
			throw new RoupaInvalidaException("Roupa Inválida:" + r.getCodDeBarras());

		}

		else if (roupas.containsKey(r.getCodDeBarras())) {

			throw new RoupaJaExisteException("Já existe uma roupa com esse código de barras:" + r.getCodDeBarras());
		} else {
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

		for (Roupas f : this.roupas.values()) {
			if (f.getFabricante().equals(fabricante)) {
				listFabricante.add((Roupas) f);
				achou = true;
			}
		}
		if (!(achou)) {
			throw new FabricanteInexistenteException("Esse fabricante não existe: " + fabricante);
		}
		return listFabricante;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTamanho(String tamanho) throws TamanhoInexistenteException {
		List<Roupas> listTamanho = new ArrayList<>();
		boolean achou = false;

		for (Roupas t : this.roupas.values()) {
			if (t.getTamanho().equals(tamanho)) {
				listTamanho.add((Roupas) t);
				achou = true;
			}
		}
		if (!(achou)) {
			throw new TamanhoInexistenteException("Esse tamanho não existe: " + tamanho);
		}
		return listTamanho;

	}

	@Override
	public List<Roupas> pesquisaRoupasPorSexo(Sexo sexo) throws SexoInexistenteException {
		List<Roupas> listSexo = new ArrayList<>();
		boolean achou = false;

		for (Roupas s : this.roupas.values()) {
			if (s.getSexo().equals(sexo)) {
				listSexo.add((Roupas) s);
				achou = true;
			}
		}
		if (!(achou)) {
			throw new SexoInexistenteException("Esse sexo não existe: " + sexo);
		}
		return listSexo;
	}

	@Override
	public List<Roupas> pesquisaRoupasPorTipo(String tipo) throws TipoInexistenteException {
		List<Roupas> listTipo = new ArrayList<>();
		boolean achou = false;

		for (Roupas t : this.roupas.values()) {
			if (t.getTipo().equals(tipo)) {
				listTipo.add((Roupas) t);
				achou = true;
			}
		}
		if (!(achou)) {
			throw new TipoInexistenteException("Esse tipo de roupa não existe: " + tipo);
		}
		return listTipo;
	}

	@Override
	public Roupas pesquisaRoupasPorCodigo(String codigo) throws CodigoDeBarrasInexistenteException {
		if (!(roupas.containsKey(codigo))) {
			throw new CodigoDeBarrasInexistenteException("Não existe roupa com esse código: " + codigo);
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
			throw new RoupaInexistenteException("Não existe roupa com esse código: " + codigo);
		}
		this.roupas.remove(codigo);
		gravador.gravaRoupas(pesquisaRoupas());
	}
	
	@Override
	public void comprasPorCodigoDeBarrasParaCarrinho(String codigo) throws CodigoDeBarrasInexistenteException {
		if (!(roupas.containsKey(codigo))) {
			throw new CodigoDeBarrasInexistenteException("Não existe roupa com esse código: " + codigo);
		}
		
		for(Roupas r: this.roupas.values()){
			if(r.getCodDeBarras().equals(codigo)){
				this.roupasCompradasCarrinho.add(r);
				this.valorComprasCarrinho += r.getPreco();
			}
		}
		
		JOptionPane.showMessageDialog(null, this.roupas.get(codigo));
		
	}
	
	@Override
	public void compraCarrinhoEPreparaRelatorio(){
		String texto = "Compras Carrinho\n\n";
		if(roupasCompradasCarrinho.size() > 0){
			for(int k=0; k < roupasCompradasCarrinho.size();k++){
				texto += roupasCompradasCarrinho.get(k).toString()+"\n";
			}
		
			texto+= "\n\nValor Total: " + this.valorComprasCarrinho + " reais.";
			JOptionPane.showMessageDialog(null, texto);
			JOptionPane.showMessageDialog(null, "Relatório da compra: ");
			int dia = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia: "));
			int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês: "));
			int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano: "));
			Relatorio r = new Relatorio(dia, mes, ano, this.valorComprasCarrinho);
			renda.add(r);
			
			gravador.gravaRelatorio(renda);
			for(int k=0; k< this.roupasCompradasCarrinho.size(); k++){
				
				try{
					removeRoupas(this.roupasCompradasCarrinho.get(k).getCodDeBarras());
				}catch(RoupaInexistenteException e){
		
				}
			}
			this.valorComprasCarrinho = 0;
			this.roupasCompradasCarrinho = new ArrayList<Roupas>();
		}else{
			JOptionPane.showMessageDialog(null,"Carrinho vazio");
		}
	}
	
	@Override
	public void valorTotalComprasEPreparaRelatorio(String codigo) throws CodigoDeBarrasInexistenteException{
		double valorDaCompra = 0;

		if (!(roupas.containsKey(codigo))) {
			throw new CodigoDeBarrasInexistenteException("Não existe roupa com esse código: " + codigo);
		}
		JOptionPane.showMessageDialog(null, this.roupas.get(codigo));
		valorDaCompra += this.roupas.get(codigo).getPreco();
		
		JOptionPane.showMessageDialog(null, "Relatório da compra: ");
		
		String dia = JOptionPane.showInputDialog("Digite o dia: ");
		int d = 0;
		try{
			d = Integer.parseInt(dia);
		}catch(NumberFormatException e){
	 		JOptionPane.showMessageDialog(null,"ERRO");
		}
		
		String mes = JOptionPane.showInputDialog("Digite o mês: ");
		int m = 0;
		try{
			m = Integer.parseInt(mes);
		}catch(NumberFormatException e){
	 		JOptionPane.showMessageDialog(null,"ERRO");
		}
		
		String ano = JOptionPane.showInputDialog("Digite o ano: ");
		int a = 0;
		try{
			 a = Integer.parseInt(ano);
		}catch(NumberFormatException e){
	 		JOptionPane.showMessageDialog(null,"ERRO");
		}
		
		Relatorio r = new Relatorio(d, m, a, valorDaCompra);
		renda.add(r);
		
		gravador.gravaRelatorio(renda);
		JOptionPane.showMessageDialog(null, "Valor total da compra R$ " + valorDaCompra + " reais.");
		
		try{
			removeRoupas(codigo);
		}catch(RoupaInexistenteException e){

		}
		
	}
	
	@Override
	public double comprasComPromocao(double promo, double valorTotal) throws NumeroNegativoException {
		if (promo <= 0) {
			throw new NumeroNegativoException("Não são permitidos números de 0 a menores!");
		}

		double valorX = (promo * 0.01);
		double valorY = (valorX * valorTotal);
		double valorZ = (valorTotal - valorY);
		valorTotal = valorZ;

		return valorTotal;
	}

	@Override
	public double rendaDiaria(int dia){
		double rendaD = 0.00;
		for(int k=0; k<gravador.recuperarRelatorio().size(); k++){
			if(dia == gravador.recuperarRelatorio().get(k).getDia()){
				rendaD += gravador.recuperarRelatorio().get(k).getRenda();
			}
		}
		return rendaD;
	}

	@Override
	public double rendaMensal(int mes) {
		double rendaM = 0.00;
		for(int k=0; k<gravador.recuperarRelatorio().size(); k++){
			if(mes == gravador.recuperarRelatorio().get(k).getMes()){
				rendaM += gravador.recuperarRelatorio().get(k).getRenda();
			}
		}
		return rendaM;
	}

	@Override
	public double rendaAnual(int ano) {
		double rendaA = 0.00;
		for(int k=0; k<gravador.recuperarRelatorio().size(); k++){
			if(ano == gravador.recuperarRelatorio().get(k).getAno()){
				rendaA += gravador.recuperarRelatorio().get(k).getRenda();
			}
		}
		return rendaA;
	}

}
