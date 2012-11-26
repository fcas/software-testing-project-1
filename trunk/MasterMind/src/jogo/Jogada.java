package jogo;

/**
 * Classe representando um turno do jogo. O jogo tem um limite maximo de 10
 * jogadas e nessas 10 jogadas o jogador tem de encontrar a senha correta para
 * ganhar. Uma Jogada consiste em uma adivinhacao da senha(feita pelo adivinho)
 * e um retorno(um feedback fornecido pelo fornecedor da senha) com base na
 * adivinhacao feita pelo adivinho. Esse retorno indica se, na tentativa do
 * adivinho, ele conseguiu acertar a cor de um pino ou ate a cor e posicao de um
 * pino na senha.
 */
public class Jogada {
	/**
	 * O atributo tentativa eh a tentativa(conjunto de pinos) do adivinho na
	 * jogada.
	 */
	private Tentativa tentativa;

	/**
	 * O atributo retorno eh o retorno(conjunto de pinos) criado com base na
	 * adivinhacao feita pelo adivinho.
	 */
	private Retorno retorno;

	/**
	 * inicialmente, tentativa e retorno s�o nulas porque o Adivinho ainda n�o
	 * fez tentativa nenhuma.
	 */
	public Jogada() {
		tentativa = null;
		retorno = null;
	}

	public void setTentativa(Tentativa t) {
		tentativa = t;
	}

	public void setRetorno(Retorno r) {
		retorno = r;
	}

	public Tentativa getTentativa() {

		return this.tentativa;
	}

	public Retorno getRetorno() {

		return this.retorno;
	}
}
