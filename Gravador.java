import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

    public class Gravador {
   	 public List<String> recuperaTextoDeArquivo(String nomeArquivo)
   			 throws IOException {    
   		 BufferedReader leitor = null;
        	List<String> textoLido = new ArrayList<String>();
   		 try {
   			 leitor = new BufferedReader(new FileReader(nomeArquivo));
   			 String texto = null;
   			 do {
   				 texto = leitor.readLine();
   				 if (texto != null){
                       	textoLido.add(texto);
                	}
   			 } while(texto != null);
   		 } finally {
   			 if (leitor!=null){
   				 leitor.close();
   			 }
   		 }
   		 return textoLido;
   	 }

   	
  public void gravaTextoEmArquivo(List<Roupas> texto, String nomeArquivo)
   			 throws IOException {
   		 BufferedWriter gravador = null;
   		 try {
   			 gravador = new BufferedWriter(new FileWriter(nomeArquivo));
             for (Roupas s: texto){
            	 gravador.write(s.toString()+"\n");
                        	}
   		 } finally {
   			 if (gravador!=null){
   				 gravador.close();
   			 }
   		 }
   	 }
  	
  public void gravaRoupas(List<Roupas> roup){
  		 

  		 try {
  			 
  			 gravaTextoEmArquivo(roup,"Roupas.txt");
  			 JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
  		 } catch (IOException e) {
  	 
  			 JOptionPane.showMessageDialog(null, "erro ao gravar");
  		 }
  		 
  	 }
  	 public List<Roupas> recuperarRoupas(){
  		 
  		 List<Roupas> lista=new ArrayList<Roupas>();
  		 
  		 try {
  			 
  			 List<String> roups;
  			 roups = recuperaTextoDeArquivo("Roupas.txt");
  			 Sexo sexo = Sexo.MASCULINO;
  			 for(int k=0;k<roups.size();k++){
  				 String tipo=roups.get(k);
  				 String fabricante=roups.get(k);
  				 if(roups.get(k).equals("MASCULINO")){
  					 sexo = Sexo.MASCULINO;
  					
  				 }else if(roups.get(k).equals("FEMININO")){
  					 sexo = Sexo.FEMININO;
  					 
  				 }else{
  					 sexo = Sexo.UNISEX;
  					 
  				 }
  				 String tamanho=roups.get(k);
  				 String codDeBarras=roups.get(k);
  				
  				 Roupas end= new Roupas(tipo, fabricante, sexo, tamanho, codDeBarras);
  				 lista.add(end);
  				 
  			 }
  			 
  			 
  		 } catch (IOException e) {
  			 
  			 JOptionPane.showMessageDialog(null, "erro ao ler arquivo");
  			 
  		 }
  		 return lista;
  		 
  	 }
  	
    }