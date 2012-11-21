package jogo;

/**
 * Classe que representa uma exce��o que deve ser lan�ada quando alguma classe
 * tenta acessar alguma posi��o que � maior que a capacidade do arranjo ou menor que 0
 * Por exemplo: Se uma classe desejasse acessar a posi��o 4 de um arranjo de 4 posi��es,
 * seria lan�ada uma PosicaoInvalidaException, pois um arranjo de tamanho = 4 deveria
 * somente poder ser acessado atrav�s dos �ndices 0, 1, 2 ou 3 (Lembrem-se que o �ndice
 * inicial de um arranjo � 0). 
 *
 */
@SuppressWarnings("serial")
public class PosicaoInvalidaException extends Exception
{
	public PosicaoInvalidaException()
	{
		super("posicao invalida para um pino");
	}

}
