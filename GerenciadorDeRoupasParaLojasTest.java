import static org.junit.Assert.*;

import org.junit.Test;

public class GerenciadorDeRoupasParaLojasTest {

	@Test
	public void test() {
		GerenciadorDeRoupasParaLojas g = new GerenciadorDeRoupasParaLojas();
		Roupas r = new Roupas("calça", "Adidas", Sexo.MASCULINO, "32", "123454");
		 try{
	   		 g.cadastraRoupas(r);
	   	 }catch(RoupaJaExisteException e){
	   		 fail("Essa roupa já está cadastrada!");
	   	 }
		assertTrue(g.informaQuantidadeDeRoupasCadastradas()==1);
		
		try{
			g.pesquisaRoupasDofabricante("Adidas");
			g.pesquisaRoupasPorSexo(Sexo.MASCULINO);
			g.pesquisaRoupasPorTamanho("32");
			g.pesquisaRoupasPorTipo("calça");
		
		}catch(FabricanteInexistenteException e){
			fail("Esse Fabricante não existe!");
		}catch(SexoInexistenteException e){
			fail("Esse Sexo não existe!");
		}catch(TamanhoInexistenteException e){
			fail("Esse Tamanho não existe!");
		}catch(TipoInexistenteException e){
			fail("Esse Tipo De Roupa não existe!");
		}
		
		try{
			g.removeRoupas("123454");
		}catch(RoupaInexistenteException e){
			fail("Essa Roupa não existe!");
		}
		assertTrue(g.informaQuantidadeDeRoupasCadastradas()==0);
		
	}

}
