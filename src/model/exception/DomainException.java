package model.exception;

//Domain porque a entidade de dominion reservation pode lançar uma exceção
public class DomainException extends Exception {
	private static final long serialVersionUID = 1L;

	//passo como argumento uma menssagem que fica armazenada na exceção
	public DomainException(String msg) {
		super(msg);
	}
}
