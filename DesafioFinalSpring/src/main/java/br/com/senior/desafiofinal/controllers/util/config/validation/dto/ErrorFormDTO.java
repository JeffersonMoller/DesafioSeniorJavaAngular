/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.config.validation.dto;

/**
 * Classe criada como modelo filtrado do erro
 * 
 * @author Jefferson Möller
 *
 */
public class ErrorFormDTO {

	private String erro;

	/**
	 * Construtor
	 * 
	 * @param campo
	 * @param erro
	 */
	public ErrorFormDTO(String erro) {
		super();

		this.erro = erro;
	}

	public ErrorFormDTO() {
	}

	/**
	 * @return the erro
	 */
	public String getErro() {
		return erro;
	}

	/**
	 * @param erro the erro to set
	 */
	public void setErro(String erro) {
		this.erro = erro;
	}
	

}
