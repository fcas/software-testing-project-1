package jogo;

/**
 * Classe que representa uma tentativa realizada pelo Adivinho para tentar adivinhar uma Senha
 * criada pelo FornecedorDeSenha.
 */
public class Tentativa 
{
	/**
	 * "tentativa" � um Arranjo de 4 posi��es que engloba Strings. Cada String deveria conter
	 * uma cor v�lida utilizada pelo sistema que representa cada pino que o Adivinho
	 * mandou inserir na Tentativa.
	 */
	private String tentativa[];
	
	/**
	 * Inicialmente todos os pinos da tentativa ser�o inicializados com a String "nenhum" que
	 * significa "nenhuma cor ainda foi escolhida pelo Adivinho".
	 */
	public Tentativa()
	{
		tentativa = new String[4];
		for(int i = 0; i < 4; i++)
		{
			tentativa[i] = "nenhum";
		}
	}
	
	/**
	 * -> Fun��o que representa a adi��o novo pino � tentativa. Para isso, � necess�rio 
	 * ser informada a posi��o que o novo pino ir� ocupar na Tentativa e a cor do novo pino.
	 * -> Caso a posi��o seja menor que 0 ou maior que 3, uma exce��o "PosicaoInvalidaException" 
	 * � lan�ada, pois uma tentativa s� deveria conter 4 pinos no m�ximo.
	 * -> Caso a cor do novo pino n�o seja uma cor v�lida, uma exce��o "CorInvalidaException" 
	 * � lan�ada
	 * @param posicao
	 * @param cor
	 * @throws PosicaoInvalidaException
	 * @throws CorInvalidaException
	 */
	public void adicionarPino(int posicao,String cor) throws PosicaoInvalidaException,CorInvalidaException
	{
		if(posicao < 0 || posicao > 3)
		{
			throw new PosicaoInvalidaException();
		}
		else if(CorEhValida(cor) == false)
		{
			throw new CorInvalidaException();
		}
		else
		{
			tentativa[posicao] = cor;
		}
	}
	
	/**
	 * Fun��o que retorna a cor do pino da posi��o informada no arranjo "tentativa".
	 * Caso a posi��o seja menor que 0 ou maior que 3, uma exce��o "PosicaoInvalidaException"
	 * � lan�ada.
	 * A fun��o ir� retornar "nenhum" se nenhum pino foi adicionado � aquela posi��o.
	 * @param posicao
	 * @return
	 * @throws PosicaoInvalidaException
	 */
	public String getPino(int posicao) throws PosicaoInvalidaException
	{
		if(posicao < 0 || posicao > 3)
		{
			throw new PosicaoInvalidaException();
		}
		else
		{
			return tentativa[posicao];
		}
	}
	
	
	/**
	 * Caso a Tentativa ainda n�o possua quatro pinos, 
	 * essa fun��o retorna true, sen�o retorna false.
	 * @return
	 */
	public boolean ehTentativaIncompleta()
	{
		//uma tentativa incompleta � aquela que tem como pino "nenhum".
		for(int i = 0; i < 4; i++)
		{
			if(this.tentativa[i] == "nenhum")
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Fun��o que verifica se uma cor "c1" (passada como par�metro) � uma das cores 
	 * utilizadas pelo sistema. Se c1 for "vermelho", "azul", "rosa", "amarelo", "roxo",
	 * "verde", "cinza" ou "laranja", ent�o c1 � uma cor v�lida. Sen�o, � uma cor inv�lida.
	 * @param c1
	 * @return
	 */
	public boolean CorEhValida(String c1)
	{
		if((c1.compareTo("vermelho") == 0) ||
				(c1.compareTo("azul") == 0) ||
				(c1.compareTo("rosa") == 0) ||
				(c1.compareTo("amarelo") == 0) ||
				(c1.compareTo("roxo") == 0) ||
				(c1.compareTo("verde") == 0) ||
				(c1.compareTo("cinza") == 0) ||
				(c1.compareTo("laranja") == 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Fun��o que retorna a quantidade de pinos j� inseridos na Tentativa. 
	 * Esse n�mero � �til quando o Adivinho for adicionar novos pinos na tentativa
	 * para que ele saiba onde adicionar os pinos que faltam para completar essa Tentativa 
	 * (uma tenativa deve ter 4 pinos).
	 * @return
	 */
	public int quantosPinosJaForamAdicionados()
	{
		int pinosAdicionados = 0;
		for(int i = 0; i < tentativa.length; i++)
		{
			if(tentativa[i].compareTo("nenhum") == 0)
			{
				return pinosAdicionados;
			}
			else
			{
				pinosAdicionados = pinosAdicionados + 1;
			}
		}
		
		return pinosAdicionados;
	}
	
}
