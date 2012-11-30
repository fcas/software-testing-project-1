package tests;

import jogo.CorInvalidaException;
import jogo.FornecedorDaSenha;
import jogo.Jogada;
import jogo.PosicaoInvalidaException;
import jogo.Senha;
import jogo.Tentativa;
import junit.framework.TestCase;

public class FornecedorDaSenhaTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSetGetFDSJogada() throws CorInvalidaException {

		FornecedorDaSenha fornecedorDaSenha = new FornecedorDaSenha();
		Senha senha = new Senha();
		Jogada jogada = new Jogada();

		String cor0 = "rosa";
		String cor1 = "azul";
		String cor2 = "laranja";
		String cor3 = "vermelho";

		senha.adicionarPino(cor0);
		senha.adicionarPino(cor1);
		senha.adicionarPino(cor2);
		senha.adicionarPino(cor3);

		fornecedorDaSenha.setJogada(jogada);
		fornecedorDaSenha.setSenha(senha);

		assertEquals(jogada, fornecedorDaSenha.getJogada());
		assertEquals(senha, (fornecedorDaSenha.getSenha()));

	}

	public void testCriarSenha() {

		FornecedorDaSenha fornecedorDaSenha = new FornecedorDaSenha();
		fornecedorDaSenha.criarSenha();
		
		/*
		 * Esse método não tem assert, pois o método "criarSenha" da classe FornecedorDaSenha gera
		 * uma senha randômica, logo, não é possível conhecer a expectativa para usar no assert;
		 * e esse método não usa "throws" para nenhuma exceção.
		 * A única exceção (Exception) do método é tratada internamente com try/catch, logo, não há exceptions
		 * para o teste capturar.
		 */

	}

	/* Nao foi criada excecao para quando a jogado nao for setada */
	public void testJogarNullPointer() {

		FornecedorDaSenha fornecedorDaSenha = new FornecedorDaSenha();

		try {
			fornecedorDaSenha.jogar();
			fail("Jogada nao setada");
		} catch (NullPointerException e)
		{}

	}

	public void testJogar() throws PosicaoInvalidaException,
			CorInvalidaException {

		FornecedorDaSenha fornecedorDaSenha = new FornecedorDaSenha();
		Jogada jogada = new Jogada();
		Tentativa tentativa = new Tentativa();

		tentativa.adicionarPino(0, "rosa");
		tentativa.adicionarPino(1, "azul");
		tentativa.adicionarPino(2, "laranja");
		tentativa.adicionarPino(3, "vermelho");

		jogada.setTentativa(tentativa);
		fornecedorDaSenha.setJogada(jogada);

		fornecedorDaSenha.jogar();

	}

}
