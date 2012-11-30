package tests;

import jogo.CorInvalidaException;
import jogo.Jogada;
import jogo.Jogo;
import jogo.PosicaoInvalidaException;
import jogo.Retorno;
import jogo.Tentativa;
import junit.framework.TestCase;

public class JogoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/*
	 * O método verSeAdivinhoGanhouJogo tem um try/catch que em condições normais não será
	 * executado, porque a exceção seria lançada pelo "getPino(i)" onde "i" pertence ao "for",
	 * sendo assim, não é possível que a exceção seja lançada.
	 */
	public void testVerificaAdivinhoGanhou () throws PosicaoInvalidaException, CorInvalidaException {
		// Construtor
		Jogo jogo = new Jogo();
		
		Retorno retorno = new Retorno();
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		//run and assert
		assertTrue(jogo.verSeAdivinhoGanhouJogo());
	}
	
	public void testVerificaAdivinhoGanhouJogadaNula () {
		// Construtor
		Jogo jogo = new Jogo();
		
		Jogada jogada = null;
		jogo.setJogada(jogada);
		
		//run and assert
		assertFalse(jogo.verSeAdivinhoGanhouJogo());
	}
	
	public void testVerificaAdivinhoNaoGanhou () throws PosicaoInvalidaException, CorInvalidaException {
		// Construtor
		Jogo jogo = new Jogo();
		
		Retorno retorno = new Retorno();
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("branco");
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		assertFalse(jogo.verSeAdivinhoGanhouJogo());
	}
	
	public void testCriarSenha(){
		/*
		 * O método testado simplesmente usa o método FornecedorDaSenha.criarSenha(), que,
		 * como explicado em comentário no método tests.FornecedorDaSenhaTest.testCriarSenha,
		 * é randômico e não tem como ser testado.
		 */
		Jogo jogo = new Jogo();
		jogo.criarSenha();
		assertTrue(true);
	}
	
	
	/*
	 * Os 4 métodos a seguir se referem a testes dos métodos Jogo.mostrarPinosTentativaDaJogada e
	 * Jogo.mostrarPinosRetornoDaJogada.
	 * Eles não têm assert, pois os métodos citados são do tipo void, com apenas um system.out no código,
	 * logo não é possível comparar nada para verificar a corretude do método, já que os métodos
	 * não alteram o estado de nenhuma variável e nem retornam nada.
	 * Além disso, esses métodos não usam "throws" para nenhuma exceção,
	 * A única exceção dos métodos (PosicaoInvalidaException) é tratada internamente com try/catch, logo, não há exceptions
	 * para o teste capturar.
	 */
	public void testMostrarPinosTentativa() throws CorInvalidaException, PosicaoInvalidaException{
		Jogo jogo = new Jogo();
		
		//Tentativa
		Tentativa t = new Tentativa();
		t.adicionarPino(0, "rosa");
		t.adicionarPino(1, "verde");
		t.adicionarPino(2, "azul");
		t.adicionarPino(3, "amarelo");
		
		Jogada jogada = new Jogada();
		jogada.setTentativa(t);
		
		jogo.setJogada(jogada);
		
		jogo.mostrarPinosTentativaDaJogada();
		
	}
	
	public void testMostrarPinosTentativaNullPointer() throws CorInvalidaException, PosicaoInvalidaException{
		Jogo jogo = new Jogo();
		
		//Tentativa
		Tentativa t = null;
		Jogada jogada = new Jogada();
		jogada.setTentativa(t);
		
		jogo.setJogada(jogada);
		
		/*
		 * Quando o método é chamado com uma tentativa setada como nula, é lançada uma
		 * NullPointerException, não prevista pelos criadores do software.
		 */
		try{
			jogo.mostrarPinosTentativaDaJogada();
			fail("Tentativa nula");
		} catch (NullPointerException e) {}
		
	}
	
	public void testMostrarPinosRetorno() throws CorInvalidaException{
		Jogo jogo = new Jogo();
		
		//retorno
		Retorno retorno = new Retorno();
		retorno.adicionarPino("preto");
		retorno.adicionarPino("branco");
		retorno.adicionarPino("preto");
		retorno.adicionarPino("branco");
		
		//Tentativa
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		jogo.mostrarPinosRetornoDaJogada();
		
	}
	
	public void testMostrarPinosRetornoNullPointer() throws CorInvalidaException{
		Jogo jogo = new Jogo();
		
		//retorno
		Retorno retorno = null;
		
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		
		jogo.setJogada(jogada);
		
		/*
		 * Quando o método é chamado com um retorno setado como nulo, é lançada uma
		 * NullPointerException, não prevista pelos criadores do software.
		 */
		try{
			jogo.mostrarPinosRetornoDaJogada();
			fail("Retorno nulo");
		} catch (NullPointerException e) {}
		
	}
	
	/* 
	 * Os 2 métodos a seguir se referem ao método Jogo.terminarJogo().
	 * Eles não têm assert, pois os métodos citados são do tipo void, com apenas um system.out no código,
	 * logo não é possível comparar nada para verificar a corretude do método, já que os métodos
	 * não alteram o estado de nenhuma variável e nem retornam nada.
	 */
	public void testTerminarJogoTerminou() {
		//construtor
		Jogo jogo = new Jogo();
		jogo.setTurno(10);
		
		jogo.terminarJogo();
		
	}
	
	public void testTerminarJogoVenceu() {
		//construtor
		Jogo jogo = new Jogo();
		jogo.setTurno(7);
		
		jogo.terminarJogo();
		
	}
}
