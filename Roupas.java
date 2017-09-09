
public class Roupas {
	
	private String tipo;
	private String fabricante;
	private String sexo;
	private String tamanho;
	
	public Roupas(String tipo, String fabricante, String sexo, String tamanho){
		this.tipo = tipo;
		this.fabricante = fabricante;
		this.sexo = sexo;
		this.tamanho = tamanho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String toString(){
		return "Tipo: "+this.tipo+", Tamanho: "+this.tamanho+"Sexo: "+this.sexo+" e Fabricante: "+this.fabricante;
	}

}
