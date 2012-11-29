package tests;

import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Senha;
import junit.framework.TestCase;

public class SenhaTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetPinoValido() throws PosicaoInvalidaException {
		Senha senha = new Senha();
		
		String cor1 = "laranja";
		String result = null;
		try {
			senha.adicionarPino(cor1);
		} catch (CorInvalidaException e) {
			e.printStackTrace();
		}
		result = senha.getPino(0);
		
		assertEquals("laranja", result);
		
	}
	
	public void testGetPinoInvalido() {
		Senha senha = new Senha();
		
		String result1 = null;
		String result2 = null;
		
		
		try{
			result1 = senha.getPino(7);
			fail("Posicao invalida.");
		} catch (PosicaoInvalidaException e){
			e.printStackTrace();
		}
		
		try{
			result2 = senha.getPino(-1);
			fail("Posicao invalida.");
		} catch (PosicaoInvalidaException f){
			f.printStackTrace();
		}
		
		assertEquals(null, result1);
		assertEquals(null, result2);
	}
	
	public void testAdicionaPinoValido() throws CorInvalidaException, PosicaoInvalidaException {
		Senha senha = new Senha();
		String cor1 = "laranja";
		String cor2 = "azul";
		String cor3 = "verde";
		String cor4 = "roxo";
		
		senha.adicionarPino(cor1);
		senha.adicionarPino(cor2);
		senha.adicionarPino(cor3);
		senha.adicionarPino(cor4);
		
		assertEquals(cor1, senha.getPino(0));
		assertEquals(cor2, senha.getPino(1));
		assertEquals(cor3, senha.getPino(2));
		assertEquals(cor4, senha.getPino(3));
		
	}
	
	public void testAdicionaPinoAMais() throws CorInvalidaException {
		Senha senha = new Senha();
		
		String cor1 = "vermelho";
		String cor2 = "rosa";
		String cor3 = "amarelo";
		String cor4 = "roxo";
		String cor5 = "cinza";
		
		senha.adicionarPino(cor1);
		senha.adicionarPino(cor2);
		senha.adicionarPino(cor3);
		senha.adicionarPino(cor4);
		senha.adicionarPino(cor5);
		
		assertEquals(4, senha.getPinosInseridos());
		try{
			assertEquals("vermelho", senha.getPino(0));
			assertEquals("rosa", senha.getPino(1));
			assertEquals("amarelo", senha.getPino(2));
			assertEquals("roxo", senha.getPino(3));
		}
		catch (PosicaoInvalidaException e){
			e.printStackTrace();
		}
		
		
	}
	
	public void testAdicionaPinoCorInvalida() {
		Senha senha = new Senha();
		String cor1 = "laranja";
		String cor2 = "azul";
		String cor3 = "marrom";
		
		try{
			senha.adicionarPino(cor1);
			senha.adicionarPino(cor2);
			senha.adicionarPino(cor3);
			fail ("Cor invalida");
		}
		catch (CorInvalidaException e){
			e.printStackTrace();
		}
		
		
	}
	
	public void testCorEhValidaFalse() {
		Senha senha = new Senha();
		String cor = null;
		
		assertEquals(false, senha.CorEhValida(cor));
	}
	
	public void testEhSenhaValida() throws CorInvalidaException {
		Senha senha = new Senha();
		String cor1 = "laranja";
		String cor2 = "azul";
		String cor3 = "verde";
		String cor4 = "roxo";
		
		senha.adicionarPino(cor1);
		senha.adicionarPino(cor2);
		senha.adicionarPino(cor3);
		senha.adicionarPino(cor4);
		
		assertEquals(true, senha.ehSenhaValida());
	}

	public void testEhSenhaValidaIncompleta(){
		Senha senha = new Senha();
		
		assertEquals(false, senha.ehSenhaValida());
	}
	
	public void testEhSenhaValidaRepetida() throws CorInvalidaException{
		Senha senha = new Senha();
		String cor1 = "laranja";
		String cor2 = "azul";
		String cor3 = "roxo";
		
		senha.adicionarPino(cor1);
		senha.adicionarPino(cor2);
		senha.adicionarPino(cor2);
		senha.adicionarPino(cor3);
		
		assertEquals(false, senha.ehSenhaValida());
	}
}
