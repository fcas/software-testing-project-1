package tests;

import jogo.CorInvalidaException;
import jogo.Jogada;
import jogo.PosicaoInvalidaException;
import jogo.Retorno;
import jogo.Tentativa;
import junit.framework.TestCase;

public class JogadaTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSetGetJogadaTentativa() throws PosicaoInvalidaException,
			CorInvalidaException {

		Tentativa tentativaEsperada = new Tentativa();
		Tentativa tentativaRetorno = new Tentativa();
		Jogada jogada = new Jogada();

		String cor0 = "rosa";
		String cor1 = "vermelho";
		String cor2 = "laranja";
		String cor3 = "rosa";

		tentativaEsperada.adicionarPino(0, cor0);
		tentativaEsperada.adicionarPino(1, cor1);
		tentativaEsperada.adicionarPino(2, cor2);
		tentativaEsperada.adicionarPino(3, cor3);

		jogada.setTentativa(tentativaEsperada);

		tentativaRetorno = jogada.getTentativa();

		assertEquals(tentativaEsperada, tentativaRetorno);

	}

	public void testSetGetJogadaRetorno() throws PosicaoInvalidaException,
			CorInvalidaException {

		Jogada jogada = new Jogada();
		Retorno retornoEsperado = new Retorno();

		String cor0 = "branco";

		retornoEsperado.adicionarPino(cor0);
		jogada.setRetorno(retornoEsperado);

		assertEquals(jogada.getRetorno().getPino(0), cor0);

	}

}
