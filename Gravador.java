
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

   	
  public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
   			 throws IOException {
   		 BufferedWriter gravador = null;
   		 try {
   			 gravador = new BufferedWriter(new FileWriter(nomeArquivo));
             for (String s: texto){
            	 gravador.write(s+"\n");
                        	}
   		 } finally {
   			 if (gravador!=null){
   				 gravador.close();
   			 }
   		 }
   	 }
  public void gravaRelatorio(List<Relatorio> relato){
	  List<String> lista = new ArrayList<String>();
	  for(Relatorio r : relato){
			lista.add(""+r.getDia());
			lista.add(""+r.getMes());
			lista.add(""+r.getAno());
			lista.add(""+r.getRenda());
			
		}
	  try{
		  gravaTextoEmArquivo(lista, "Relatorio.txt");
	  }catch(IOException e){
		  JOptionPane.showMessageDialog(null, "erro ao gravar");
	  }
  }
  	
  public void gravaRoupas(List<Roupas> roup){
  		 List<String> lista = new ArrayList<String>();
  		for(Roupas p : roup){
  			lista.add(p.getTipo());
  			lista.add(p.getFabricante());
  			lista.add(p.getSexo().toString());
  			lista.add(p.getTamanho());
  			lista.add(p.getCodDeBarras());
  			lista.add(""+p.getPreco());
  		}

  		 try {
  			 
  			 gravaTextoEmArquivo(lista,"Roupas.txt");
  			// JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
  		 } catch (IOException e) {
  	 
  			 JOptionPane.showMessageDialog(null, "erro ao gravar");
  		 }
  		 
  	 }
  	
  public List<Relatorio> recuperarRelatorio(){
  		List<Relatorio> lista = new ArrayList<Relatorio>();
  		try{
  			List<String> relato;
  			relato = recuperaTextoDeArquivo("Relatorio.txt");
  			for(int k=0; k < relato.size(); k++){
  				
  				int dia = Integer.parseInt(relato.get(k));
  				k++;
  				int mes = Integer.parseInt(relato.get(k));
  				k++;
  				int ano = Integer.parseInt(relato.get(k));
  				k++;
  				double renda = Double.parseDouble(relato.get(k));
  				
  				Relatorio r = new Relatorio(dia, mes, ano, renda);
  				lista.add(r);
  			}
  			
  		}catch (IOException e) {
 			 JOptionPane.showMessageDialog(null, "erro ao ler arquivo");
  		}
  		
  		return lista;
  	}
  	
  	public List<Roupas> recuperarRoupas(){
  		 
  		 List<Roupas> lista = new ArrayList<Roupas>();
  		 
  		 try {
  			 
  			 List<String> roups;
  			 roups = recuperaTextoDeArquivo("Roupas.txt");
  			 Sexo sexo = Sexo.MASCULINO;
  			 for(int k=0;k<roups.size();k++){
  				 String tipo=roups.get(k);
  				 k++;
  				 String fabricante=roups.get(k);
  				 k++;
  				 if(roups.get(k).equals("MASCULINO")){
  					 sexo = Sexo.MASCULINO;
  					 k++;
  				 }else if(roups.get(k).equals("FEMININO")){
  					 sexo = Sexo.FEMININO;
  					 k++;
  				 }else{
  					 sexo = Sexo.UNISEX;
  					 k++;
  				 }
  				 String tamanho=roups.get(k);
  				 k++;
  				 String codDeBarras=roups.get(k);
  				 k++;
  				 double preco = Double.parseDouble(roups.get(k));
  				 
  				 Roupas end= new Roupas(tipo, fabricante, sexo, tamanho, codDeBarras, preco);
  				 lista.add(end);
  				 
  			 }
  			 
  			 
  		 } catch (IOException e) {
  			 
  			 JOptionPane.showMessageDialog(null, "erro ao ler arquivo");
  			 
  		 }
  		 return lista;
  		 
  	 }
  	   	
    }
