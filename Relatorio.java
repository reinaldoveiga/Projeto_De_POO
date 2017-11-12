
public class Relatorio{
	
	private int dia = 0;
	private int mes = 0;
	private int	ano = 0;
	private double renda = 0;
		
	public Relatorio(int dia, int mes, int ano, double renda){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.renda = renda;
		
	}

	public int getDia() {
		return this.dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getRenda() {
		return this.renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	public String toString(){
		return "Data: "+ this.dia + "/" + this.mes + "/" + this.ano + ".";//Renda: R$ " + this.renda + " reais.";
	}
}
