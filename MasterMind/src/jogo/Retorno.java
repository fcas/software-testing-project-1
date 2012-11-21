package jogo;

/**
 * 
 * Representa o "Retorno" que o "FornecedorDaSenha" gera assim que compara a
 * verdadeira senha e a tentativa do "Adivinho"
 */
public class Retorno {
	/**
	 * Quantidade de pinos j� inseridos
	 */
	private int pinosInseridos;

	/**
	 * Representa��o do retorno para o Adivinho indicando se ele acertou a
	 * posi��o -ou- posi��o e cor de um pino na tentativa
	 * 
	 * As strings do arranjo s�o as cores dos pinos(preto - acertou posi��o e
	 * cor do pino, ou branco - acertou apenas cor)
	 */
	private String retorno[];

	public Retorno() {

		// setando "retorno" arranjo de 4 strings

		retorno = new String[4];
		for (int i = 0; i < 4; i++) {
			retorno[i] = "nenhum";
		}

		// setando "pinosInseridos"
		pinosInseridos = 0;
	}

	/**
	 * se j� houver 4 pinos, o novo pino n�o ser� adicionado
	 * 
	 * @param corPino
	 *            "preto" ou "branco" sen�o exception � lan�ada
	 * @throws CorInvalidaException
	 */
	public void adicionarPino(String corPino) throws CorInvalidaException {
		if (corPino != "branco" && corPino != "preto") {
			throw new CorInvalidaException();
		} else if (pinosInseridos != 4) {
			retorno[pinosInseridos] = corPino;
			pinosInseridos++;
		}
	}

	/**
	 * 
	 * @param posicao
	 *            de 0 a 3 (v�lida) sen�o exception � lan�ada
	 * @return cor do pino que est� naquela posi��o
	 * @throws PosicaoInvalidaException
	 */
	public String getPino(int posicao) throws PosicaoInvalidaException {
		if (posicao >= 0 && posicao <= 3) {
			return retorno[posicao];
		} else {
			throw new PosicaoInvalidaException();
		}
	}

	/**
	 * 
	 * @return quantidade de pinos inseridos
	 */
	public int getPinosInseridos() {
		return pinosInseridos;
	}

}