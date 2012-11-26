package tests;

import jogo.CorInvalidaException;
import jogo.FornecedorDaSenha;
import jogo.Jogada;
import jogo.Senha;
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

	}

	public void testJogar() {

		FornecedorDaSenha fornecedorDaSenha = new FornecedorDaSenha();
		fornecedorDaSenha.jogar();

	}

}
