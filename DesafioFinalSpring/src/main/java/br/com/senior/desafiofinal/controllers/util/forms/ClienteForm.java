/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.forms;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import br.com.senior.desafiofinal.controllers.util.config.validation.CpfCnpjUtils;
import br.com.senior.desafiofinal.controllers.util.config.validation.minhasexception.DesafioValidationException;
import br.com.senior.desafiofinal.enuns.TipoEnum;
import br.com.senior.desafiofinal.model.Cliente;

/**
 * Classe para cadastros de Clientes
 * 
 * @author Jefferson Möller
 *
 */
public class ClienteForm {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	private String documento;

	private TipoEnum tipoEnum;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @return the enumTipo
	 */
	public TipoEnum getTipoEnum() {
		return tipoEnum;
	}

	/**
	 * Metodo que verifica CPF ou CNPJ e converte para Cliente
	 * 
	 * @return Optional<Cliente>
	 * @throws DesafioValidationException
	 */
	public Optional<Cliente> converter() throws Exception {

		if (CpfCnpjUtils.isValid(documento)) {
			if (documento.length() == 11) {
				return Optional.of(new Cliente(nome, documento, TipoEnum.FISICO));
			}
			return Optional.of(new Cliente(nome, documento, TipoEnum.JURIDICO));
		}

		throw new DesafioValidationException("Documento inválido");
	}

}
