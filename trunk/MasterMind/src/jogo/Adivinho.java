package jogo;

import java.util.Scanner;

/**
 * classe que representa o pr�prio usu�rio do nosso jogo. O adivinho adivinha a
 * senha do jogo em cada uma de suas jogadas. Ele tem 10 jogadas para tentar
 * descobrir a senha(que � o objetivo do jogo).
 * 
 * Essa classe Implementa a Interface Jogador que tamb�m implementada por
 * FornecedorDaSenha: quem elabora a senha para ser adivinhada.
 * 
 */
public class Adivinho implements Jogador {
	/**
	 * O atributo jogadaTurno � a jogada atual do jogo. O jogo tem 10 jogadas no
	 * m�ximo, sendo que cada jogada consiste em uma adivinha��o da senha(feita
	 * pelo adivinho) e um retorno(um feedback fornecido pelo fornecedor da
	 * senha) com base na adivinha��o feita pelo adivinho
	 */
	Jogada jogadaTurno;

	public Adivinho() {

	}

	/**
	 * A classe Jogo chama esse m�todo para passar ao adivinho e ao fornecedor
	 * da senha a jogada atual do jogo(o jogo tem 10 jogadas, como j�
	 * explicado).
	 */
	public void setJogada(Jogada jog) {
		jogadaTurno = jog;

	}

	/**
	 * m�todo chamado quando o Adivinho termina de jogar. Ap�s ele escolher as
	 * cores dos pinos que ele acha que � a senha correta, ele realiza uma
	 * tentativa para a jogada atual. Dependendo da tentativa, ele pode at�
	 * ganhar o jogo se tiver acertado a senha correta.
	 * 
	 * @param tentativaJogador
	 *            � a tentativa completa(com 4 pinos) que o jogador fez para
	 *            tentar acertar a senha.
	 */
	public void realizarTentativa(Tentativa tentativaJogador) {
		jogadaTurno.setTentativa(tentativaJogador);
	}

	/**
	 * cada vez que o adivinho for jogar, ele vai fazer uma tentativa para
	 * descobrir a senha correta. Essa tentativa tem de ter 4 pinos para ser
	 * completa. Ap�s o jogador selecionar os 4 pinos da tentativa, ele vai
	 * realizar a tentativa de acertar a senha.
	 */
	public void jogar() {
		Tentativa tentativaJogador = new Tentativa();
		while (tentativaJogador.ehTentativaIncompleta() == true) {
			this.adicionarNovoPinoATentativa(tentativaJogador);
		}
		this.realizarTentativa(tentativaJogador);

	}

	/**
	 * esse m�todo vai ser chamado enquanto o Adivinho joga. Nele, o jogo pede
	 * para o usu�rio digitar uma nova cor de pino para a tentativa dele.
	 * Digitando uma cor v�lida, o pino ser� inserido na tentativa passada como
	 * par�metro do m�todo. Esse m�todo � chamado v�rias vezes dentro de
	 * Adivinho.jogar() at� o jogador ter decidido uma tentativa completa(4
	 * pinos) para a senha. Caso o jogador digite uma cor inv�lida para o jogo,
	 * esse m�todo pega a exce��o CorInvalidaException e informa ao usu�rio que
	 * a cor que ele informou n�o � v�lida para o jogo. Ele captura a exce��o
	 * PosicaoInvalidaException se tentarmos adicionar um pino em uma tentativa
	 * com 4 pinos(cada tentativa tem, no m�ximo, 4 pinos). Tecnicamente, Essa
	 * exce��o nunca ocorre se o jogo funciona sem bugs.
	 * 
	 * @param tentativa
	 *            � a tentativa(conjunto de pinos) atual do jogador. � a
	 *            tentativa na qual adicionaremos um novo pino ap�s o m�todo.
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
					.println("posicao para inserir pino na jogada do jogador � inv�lida");
		} catch (CorInvalidaException e) {
			System.out
					.println("cor inv�lida para novo pino a ser inserido na tentativa do jogador."
							+ "Tente novamente.");
		} scanIn.close();
	}

}
