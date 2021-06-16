/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.config.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.senior.desafiofinal.controllers.util.config.validation.dto.ErrorFormDTO;
import br.com.senior.desafiofinal.controllers.util.config.validation.minhasexception.DesafioValidationException;

/**
 * Classe que retorna os erros do quando Bean validation não foram atendidos
 * 
 * @author Jefferson Möller
 *
 */

@RestControllerAdvice
public class ErroValidationHandler {

	@Autowired
	private MessageSource messageSource;

	private String messageErro = "";

	/**
	 * Metodo criado para concatenar as mensagens de erros
	 * 
	 * @param messageErro
	 */
	public void setMessageErro(String messageErro) {
		this.messageErro = "O campo " + messageErro ;
	}

	/**
	 * Metodo criado para devolver mensagem de erro
	 * 
	 * @return String
	 */
	public String getMessageErro() {
		return messageErro;
	}

	/**
	 * Metodo que retorna erros quando algo particular não foi atendido
	 * 
	 * @param exception
	 * @return ErrorFormDTO
	 */
	@ExceptionHandler(DesafioValidationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorFormDTO handler(DesafioValidationException exception) {

		ErrorFormDTO dto = new ErrorFormDTO(exception.getMessage());

		return dto;

	}

	/**
	 * Metodo que retorna erro quando algum BeanValidation não foi atendido
	 * 
	 * @param exception
	 * @return ErrorFormDTO
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorFormDTO handler(MethodArgumentNotValidException exception) {

		ErrorFormDTO dto = new ErrorFormDTO();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		fieldErrors.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			setMessageErro(e.getField() + " " + message);
		});

		dto.setErro(getMessageErro());
		
		
		return dto;
	}

}
