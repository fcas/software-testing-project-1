package tests;

import jogo.Jogo;
import junit.framework.TestCase;

public class JogoTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testJogo(){
		Jogo jogo = new Jogo();
		assertEquals(true, true);
	}
}