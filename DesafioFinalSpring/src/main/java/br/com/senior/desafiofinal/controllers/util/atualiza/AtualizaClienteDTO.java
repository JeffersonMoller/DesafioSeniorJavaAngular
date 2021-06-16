/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.atualiza;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import br.com.senior.desafiofinal.controllers.util.config.validation.CpfCnpjUtils;
import br.com.senior.desafiofinal.controllers.util.config.validation.minhasexception.DesafioValidationException;
import br.com.senior.desafiofinal.enuns.TipoEnum;
import br.com.senior.desafiofinal.model.Cliente;
import br.com.senior.desafiofinal.repositories.ClienteRepository;

/**
 * Classe usada para atualizaces de informações do Cliente
 * 
 * @author Jefferson Möller
 *
 */
public class AtualizaClienteDTO {

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
	 * Metodo usado para atualizar e verificar se CPF é valido
	 * 
	 * @param codigo
	 * @param clienteRepository
	 * @return Optional<Cliente>
	 * @throws DesafioValidationException
	 */
	public Optional<Cliente> atualizar(Long codigo, ClienteRepository clienteRepository)
			throws DesafioValidationException {
		Cliente cliente = clienteRepository.getOne(codigo);

		if (CpfCnpjUtils.isValid(this.documento)) {
			cliente.setNome(this.nome);
			cliente.setDocumento(this.documento);

			if (documento.length() == 11) {
				cliente.setTipoEnum(TipoEnum.FISICO);
			} else {
				cliente.setTipoEnum(TipoEnum.JURIDICO);
			}
			
			return Optional.of(cliente);
		}

		throw new DesafioValidationException("Documento inválido");
	}

}
