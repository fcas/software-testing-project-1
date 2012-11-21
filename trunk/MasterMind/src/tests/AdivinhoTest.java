package tests;

import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Tentativa;
import junit.framework.TestCase;

public class AdivinhoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAdicionarNovoPinoATentativa () throws PosicaoInvalidaException, CorInvalidaException{
		
		int posicao = 1; 
		String cor = "rosa"; 
		
		Tentativa tentativa = new Tentativa();
		
		tentativa.adicionarPino(posicao, cor);
		
	}

}
