package tests;

import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Retorno;
import junit.framework.TestCase;

public class RetornoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAdicionarPinoCorInvalida() throws PosicaoInvalidaException {

		String corPino = "azul";
		Retorno retorno = new Retorno();

		try {
			retorno.adicionarPino(corPino);
			fail("Cor inválida");
		} catch (CorInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("nenhum", retorno.getPino(0));

	}

	public void testAdicionarPinoCorValida() throws CorInvalidaException, PosicaoInvalidaException {

		String corPino = "branco";
		Retorno retorno = new Retorno();

		retorno.adicionarPino(corPino);
		
		assertEquals(corPino, retorno.getPino(0));

	}

	public void testGetPinoPosicaoValida() throws PosicaoInvalidaException {

		Retorno retorno = new Retorno();
		int posicao = retorno.getPinosInseridos();

		retorno.getPino(posicao);

	}
	
	public void testGetPinoPosicaoInvalida() {

		int posicao = -1;
		Retorno retorno = new Retorno();

		try {
			retorno.getPino(posicao);
			fail("Posição Inválida");
		} catch (PosicaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
