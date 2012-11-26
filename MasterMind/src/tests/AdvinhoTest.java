package tests;

import jogo.Adivinho;
import jogo.CorInvalidaException;
import jogo.Jogada;
import jogo.PosicaoInvalidaException;
import jogo.Tentativa;
import junit.framework.TestCase;

public class AdvinhoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/* 
	 * NullPointerException é lançada pois a classe Adivinho
	 * não foi inicializada corretamente pelos criadores do software
	 */
	public void testRealizarTentativaNullPointerException () throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();
		
		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "roxo");
		
		try{
			ad.realizarTentativa(t);
			fail("Atributo jogadaTurno nao inicializado.");
		}	
		catch (NullPointerException e){
		}
	}
	
	/*
	 * Para corrigir o NullPointerException, o método setJogada é chamado antes do realizarTentativa.
	 */
	public void testRealizarTentativa () throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();
		
		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "roxo");
		
		Jogada jog = new Jogada();
		ad.setJogada(jog);
		
		ad.realizarTentativa(t);
	}
	
	/*
	 * Método não-testável pois dentro do método é utilizado Scanner.in;
	 * Aconselhado extrair o Scanner do método para que ele possa ser adicionado aos testes automatizados do JUnit.
	 */
	public void testAdicionarNovoPinoATentativa(){
		
	}

}
