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
	 * O correto eh testar uma caracteristica em cada teste, no entanto, no each
	 * choice ha em uma unica clausula valores pertecentes a blocos diferentes
	 * (o que reduz o numero de testes necessarios) abaixo por exemplo, os dois
	 * valores escolhidos levantam excecoes diferentes, ou seja, duas
	 * caracteristicas estao sendo testadas em um unico teste, posso mante-lo
	 * assim ?
	 * Ab�s, FelBeast
	 */

	public void testAdicionarNovoPinoCorInvalida() throws PosicaoInvalidaException {

		int posicao = 0;
		String cor = "marrom";

		Tentativa tentativa = new Tentativa();

		try {
			tentativa.adicionarPino(posicao, cor);
			fail("Cor invalida");
		} catch (CorInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void testAdicionarNovoPinoPosicaoInvalida() throws CorInvalidaException {

		int posicao1 = -1;
		int posicao2 = 6;
		String cor = "marrom";

		Tentativa tentativa = new Tentativa();

		try {
			tentativa.adicionarPino(posicao1, cor);
			fail("Posicao Invalida");
		} catch (PosicaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			tentativa.adicionarPino(posicao2, cor);
			fail("Posicao Invalida");
		} catch (PosicaoInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void testGetPinoPosicaoValida() throws PosicaoInvalidaException {

		int posicao = 0;
		Tentativa tentativa = new Tentativa();
		tentativa.getPino(posicao);

	}

	public void testGetPinoPosicaoInvalida() {

		int posicao1 = -5;
		int posicao2 = 14;
		
		Tentativa tentativa = new Tentativa();
		
		try {
			tentativa.getPino(posicao1);
			fail("Posicao Invalida");
		} catch (PosicaoInvalidaException e) {
			e.printStackTrace();
		}
		
		try {
			tentativa.getPino(posicao2);
			fail("Posicao Invalida");
		} catch (PosicaoInvalidaException e) {
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

		assertEquals(false, tentativa.ehTentativaIncompleta());

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
	
	public void testCorEhValida(){
		
		String cor1 = "vermelho";
		String cor2 = "azul";
		String cor3 = "amarelo";
		String cor4 = "roxo";
		String cor5 = "verde";
		String cor6 = "cinza";
		
		Tentativa t = new Tentativa();
		
		assertTrue(t.CorEhValida(cor1));
		assertTrue(t.CorEhValida(cor2));
		assertTrue(t.CorEhValida(cor3));
		assertTrue(t.CorEhValida(cor4));
		assertTrue(t.CorEhValida(cor5));
		assertTrue(t.CorEhValida(cor6));
		
	}

	public void testCorEhInvalida(){
		
		String cor = "marrom";
		Tentativa t = new Tentativa();
		assertFalse(t.CorEhValida(cor));
		
	}
	
}
