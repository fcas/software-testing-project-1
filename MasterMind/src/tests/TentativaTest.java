package tests;

import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Tentativa;
import junit.framework.TestCase;

public class TentativaTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAdicionarNovoPinoValido() throws PosicaoInvalidaException,
			CorInvalidaException {

		int posicao = 0;
		String cor = "laranja";

		Tentativa tentativa = new Tentativa();

		tentativa.adicionarPino(posicao, cor);

	}

	/*
	 * O correto é testar uma característica em cada teste, no entando, no each
	 * choice há em uma única cláusula valores pertecentes a blocos diferentes
	 * (o que reduz o número de testes necessários) abaixo por exemplo, os dois
	 * valores escolhidos levantam exceções diferentes, ou seja, duas
	 * características estão sendo testadas em um único teste, posso manté-lo
	 * assim ?
	 */

	public void testAdicionarNovoPinoCorInvalida() throws PosicaoInvalidaException {

		int posicao = 0;
		String cor = "marrom";

		Tentativa tentativa = new Tentativa();

		try {
			tentativa.adicionarPino(posicao, cor);
			fail("Cor inválida");
		} catch (CorInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void testAdicionarNovoPinoPosicaoInvalida() throws CorInvalidaException {

		int posicao = -1;
		String cor = "marrom";

		Tentativa tentativa = new Tentativa();

		try {
			tentativa.adicionarPino(posicao, cor);
			fail("Posição Inválida");
		} catch (PosicaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testGetPinoValido() throws PosicaoInvalidaException {

		int posicao = 0;
		Tentativa tentativa = new Tentativa();
		tentativa.getPino(posicao);

	}

	public void testGetPinoInvalido() {

		int posicao = -1;
		Tentativa tentativa = new Tentativa();
		try {
			tentativa.getPino(posicao);
			fail("Posicao Inválida");
		} catch (PosicaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testEhTentativaIncompleta() {
		Tentativa tentativa = new Tentativa();
		assertTrue(tentativa.ehTentativaIncompleta());
	}

	public void testEhTentativaCompleta() throws PosicaoInvalidaException,
			CorInvalidaException {

		String cor = "rosa";

		Tentativa tentativa = new Tentativa();

		for (int i = 0; i < 4; i++) {
			tentativa.adicionarPino(i, cor);
		}

		assertTrue(!(tentativa.ehTentativaIncompleta()));

	}

	public void testQuantosPinos() throws PosicaoInvalidaException,
			CorInvalidaException {

		String cor = "laranja";

		Tentativa tentativa = new Tentativa();
		
		assertEquals(0, tentativa.quantosPinosJaForamAdicionados());
		
		for (int i = 0; i < 4; i++) {
			tentativa.adicionarPino(i, cor);
		}

		assertEquals(4, tentativa.quantosPinosJaForamAdicionados());

	}

}
