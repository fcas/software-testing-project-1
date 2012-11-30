package jogo;

import java.util.Scanner;

/**
 * classe que representa o proprio usuario do nosso jogo. O adivinho adivinha a
 * senha do jogo em cada uma de suas jogadas. Ele tem 10 jogadas para tentar
 * descobrir a senha(que eh o objetivo do jogo).
 * 
 * Essa classe Implementa a Interface Jogador que tambem implementada por
 * FornecedorDaSenha: quem elabora a senha para ser adivinhada.
 * 
 */
public class Adivinho implements Jogador {
	/**
	 * O atributo jogadaTurno eh a jogada atual do jogo. O jogo tem 10 jogadas no
	 * maximo, sendo que cada jogada consiste em uma adivinhacao da senha(feita
	 * pelo adivinho) e um retorno(um feedback fornecido pelo fornecedor da
	 * senha) com base na adivinhacao feita pelo adivinho
	 */
	Jogada jogadaTurno;

	public Adivinho() {

	}

	/**
	 * A classe Jogo chama esse metodo para passar ao adivinho e ao fornecedor
	 * da senha a jogada atual do jogo(o jogo tem 10 jogadas, como ja
	 * explicado).
	 */
	public void setJogada(Jogada jog) {
		jogadaTurno = jog;

	}

	/**
	 * Metodo chamado quando o Adivinho termina de jogar. Apos ele escolher as
	 * cores dos pinos que ele acha que eh a senha correta, ele realiza uma
	 * tentativa para a jogada atual. Dependendo da tentativa, ele pode ate
	 * ganhar o jogo se tiver acertado a senha correta.
	 * 
	 * @param tentativaJogador
	 *            eh a tentativa completa(com 4 pinos) que o jogador fez para
	 *            tentar acertar a senha.
	 */
	public void realizarTentativa(Tentativa tentativaJogador) {
		jogadaTurno.setTentativa(tentativaJogador);
	}

	/**
	 * cada vez que o adivinho for jogar, ele vai fazer uma tentativa para
	 * descobrir a senha correta. Essa tentativa tem de ter 4 pinos para ser
	 * completa. Apos o jogador selecionar os 4 pinos da tentativa, ele vai
	 * realizar a tentativa de acertar a senha.
	 */
	
	/*
	 * Método não-testável pois depende de outro método não-testável.
	 */
	public void jogar() {
		Tentativa tentativaJogador = new Tentativa();
		while (tentativaJogador.ehTentativaIncompleta() == true) {
			this.adicionarNovoPinoATentativa(tentativaJogador);
		}
		this.realizarTentativa(tentativaJogador);
	}
	
	/**Método desenvolvido pelos testadores com a ideia de simular um Stub**/
	public void jogarTestadores() throws PosicaoInvalidaException, CorInvalidaException {
		Tentativa tentativaJogador = new Tentativa();
		tentativaJogador.adicionarPino(0, "laranja");
		tentativaJogador.adicionarPino(1, "verde");
		tentativaJogador.adicionarPino(2, "azul");
		tentativaJogador.adicionarPino(3, "roxo");
		
		while (tentativaJogador.ehTentativaIncompleta() == true) {
			this.scannerTestadores(tentativaJogador);
		}
		this.realizarTentativa(tentativaJogador);
	}

	/**
	 * esse metodo vai ser chamado enquanto o Adivinho joga. Nele, o jogo pede
	 * para o usuario digitar uma nova cor de pino para a tentativa dele.
	 * Digitando uma cor valida, o pino sera inserido na tentativa passada como
	 * parametro do metodo. Esse metodo eh chamado varias vezes dentro de
	 * Adivinho.jogar() ate o jogador ter decidido uma tentativa completa(4
	 * pinos) para a senha. Caso o jogador digite uma cor invalida para o jogo,
	 * esse metodo pega a excecao CorInvalidaException e informa ao usuario que
	 * a cor que ele informou nao eh valida para o jogo. Ele captura a excecao
	 * PosicaoInvalidaException se tentarmos adicionar um pino em uma tentativa
	 * com 4 pinos(cada tentativa tem, no maximo, 4 pinos). Tecnicamente, Essa
	 * excecao nunca ocorre se o jogo funciona sem bugs.
	 * 
	 * @param tentativa
	 *            eh a tentativa(conjunto de pinos) atual do jogador. Eh a
	 *            tentativa na qual adicionaremos um novo pino apos o metodo.
	 */
	
	/*
	 * Warning dos testadores: O scanner scanIn não é fechado pelos desenvolvedores do software.
	 * Método não-testável pois depende da entrada do usuário com o teclado.
	 */
	  public void adicionarNovoPinoATentativa(Tentativa tentativa) {
		System.out.println("digite um novo pino para sua tentativa. ");
		System.out
				.println("Ele pode ser vermelho, azul, rosa, amarelo, roxo, verde, cinza ou laranja.");
		Scanner scanIn = new Scanner(System.in);
		String corPino = scanIn.nextLine();
		int posicaoDoNovoPino = tentativa.quantosPinosJaForamAdicionados();
		try {
			tentativa.adicionarPino(posicaoDoNovoPino, corPino);
			System.out.println("pino colocado com sucesso:" + corPino);
		} catch (PosicaoInvalidaException e) {
			System.out
					.println("posicao para inserir pino na jogada do jogador eh invalida");
		} catch (CorInvalidaException e) {
			System.out
					.println("cor invalida para novo pino a ser inserido na tentativa do jogador."
							+ "Tente novamente.");
		}
	}
	
	  /**Método desenvolvido pelos testadores com a ideia de simular um Stub**/
	public void adicionarNovoPinoATentativaTestadores(Tentativa tentativa, String corPino) {

		int posicaoDoNovoPino = tentativa.quantosPinosJaForamAdicionados();
		try {
			tentativa.adicionarPino(posicaoDoNovoPino, corPino);
			System.out.println("pino colocado com sucesso:" + corPino);
		} catch (PosicaoInvalidaException e) {
			System.out
					.println("posicao para inserir pino na jogada do jogador eh invalida");
		} catch (CorInvalidaException e) {
			System.out
					.println("cor invalida para novo pino a ser inserido na tentativa do jogador."
							+ "Tente novamente.");
		}
	}
	
	/**Método desenvolvido pelos testadores com a ideia de simular um Stub**/
	public void scannerTestadores(Tentativa tentativa){
		
		Scanner scanIn = new Scanner(System.in);
		
		System.out.println("digite um novo pino para sua tentativa. ");
		System.out.println("Ele pode ser vermelho, azul, rosa, amarelo, roxo, verde, cinza ou laranja.");
		
		String corPino = scanIn.nextLine();
		
		this.adicionarNovoPinoATentativaTestadores(tentativa, corPino);
		scanIn.close();
	}
	//
	

}
