package br.com.senior.desafiofinal.controllers.util.config.validation.minhasexception;

/**
 * Classe para lançamento de Exceptions particulares
 * 
 * @author Jefferson Möller
 *
 */
public class DesafioValidationException extends Exception {

	private static final long serialVersionUID = 1149241039409861914L;

	public DesafioValidationException(String msg) {
		super(msg);
	}

}
