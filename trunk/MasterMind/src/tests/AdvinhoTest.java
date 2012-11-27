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
	 * NullPointerException � lan�ada pois a classe Adivinho n�o foi
	 * inicializada corretamente pelos criadores do software
	 */

	public void testRealizarTentativaNullPointerException()
			throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();

		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "roxo");

		try {
			ad.realizarTentativa(t);
			fail("Atributo jogadaTurno nao inicializado.");
		} catch (NullPointerException e) {
		}
	}

	/*
	 * Para corrigir o NullPointerException, o m�todo setJogada � chamado antes
	 * do realizarTentativa.
	 */
	public void testRealizarTentativaCompleta()
			throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();

		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "roxo");

		Jogada jog = new Jogada();
		ad.setJogada(jog);

		ad.realizarTentativa(t);
		assertEquals(false, t.ehTentativaIncompleta());

	}

	public void testRealizarTentativaIncompleta()
			throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();

		Jogada jog = new Jogada();
		ad.setJogada(jog);

		ad.realizarTentativa(t);
		assertEquals(true, t.ehTentativaIncompleta());

	}

	/*
	 * M�todo n�o-test�vel pois dentro do m�todo � utilizado Scanner.in;
	 * Aconselhado extrair o Scanner do m�todo para que ele possa ser adicionado
	 * aos testes automatizados do JUnit.
	 */
	public void testAdicionarNovoPinoATentativaCheia()
			throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();

		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "roxo");

		String cor = "roxo";

		ad.adicionarNovoPinoATentativaTestadores(t, cor);
	}

	public void testAdicionarNovoPinoATentativaValida()
			throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();

		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");

		String cor = "roxo";

		ad.adicionarNovoPinoATentativaTestadores(t, cor);
		
	}

	public void testAdicionarNovoPinoATentativaCorInvalida()
			throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa t = new Tentativa();
		Adivinho ad = new Adivinho();

		t.adicionarPino(0, "laranja");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");

		String cor = "marrom";

		ad.adicionarNovoPinoATentativaTestadores(t, cor);
	}

	public void testJogarTestadores() throws PosicaoInvalidaException,
			CorInvalidaException {
		Adivinho ad = new Adivinho();

		Jogada jog = new Jogada();
		ad.setJogada(jog);

		ad.jogarTestadores();
	}

}
