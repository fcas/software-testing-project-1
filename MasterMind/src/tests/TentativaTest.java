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

		int posicao = 1;
		String cor = "rosa";

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

	public void testAdicionarNovoPinoInvalido() {

		int posicao = -1;
		String cor = "marrom";

		Tentativa tentativa = new Tentativa();

		try {
			tentativa.adicionarPino(posicao, cor);
			fail("Posição ou cor inválida");
		} catch (PosicaoInvalidaException | CorInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
