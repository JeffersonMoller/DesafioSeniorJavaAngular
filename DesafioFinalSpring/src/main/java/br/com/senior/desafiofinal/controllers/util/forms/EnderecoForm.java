/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.senior.desafiofinal.model.Endereco;

/**
 * Classe para cadastros de Endereços
 * 
 * @author Jefferson Möller
 *
 */
public class EnderecoForm {

	@NotNull
	@NotEmpty
	private String logradouro;

	@NotNull
	private Integer numero;

	@NotNull
	@NotEmpty
	private String bairro;

	@NotNull
	@NotEmpty
	private String cidade;

	@NotNull
	@NotEmpty
	@Length(min = 8, max = 8)
	private String cep;

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Metodo que converte para tipo Endereço
	 * 
	 * @return Endereco
	 */
	public Endereco converter() {
		return new Endereco(logradouro, numero, bairro, cidade, cep);
	}
}
