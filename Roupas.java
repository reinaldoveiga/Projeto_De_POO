public class Roupas {
    
    private String tipo, fabricante, tamanho ,codDeBarras;
    private Sexo sexo;
    
    public Roupas(){
    	this.tipo = "";
      	this.fabricante = "";
      	this.sexo = null;
      	this.tamanho = "";
      	this.codDeBarras = "";
    }
    public Roupas(String tipo, String fabricante, Sexo sexo, String tamanho, String codigo){
   	 this.tipo = tipo;
   	 this.fabricante = fabricante;
   	 this.sexo = sexo;
   	 this.tamanho = tamanho;
   	 this.codDeBarras = codigo;
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

    public Sexo getSexo() {
   	 return sexo;
    }

    public void setSexo(Sexo sexo) {
   	 this.sexo = sexo;
    }

    public String getTamanho() {
   	 return tamanho;
    }

    public void setTamanho(String tamanho) {
   	 this.tamanho = tamanho;
    }
    
    public String getCodDeBarras() {
   	 return codDeBarras;
    }

    public void setCodDeBarras(String codDeBarras) {
   	 this.codDeBarras = codDeBarras;
    }
    
    public String toString(){
   	 return "Tipo: "+this.tipo+", Tamanho: "+this.tamanho+", Sexo: "+this.sexo+", Fabricante: "+
    this.fabricante+", Código de barras: "+ this.codDeBarras;
    
    }
    
    public boolean equals(Object o) {
   	 if (!(o instanceof Roupas)) {
   		 return false;
   	 }
   	 
   	 Roupas r = (Roupas) o;
   	 if (!(r == null)) {
   		 if (r.getCodDeBarras() == this.codDeBarras) {
   			 return true;
   		 } else if (!(r.getCodDeBarras() == this.codDeBarras)) {
   			 return false;
   		 }
   	 }
   	 return false;
    }
    

}
