/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.senior.desafiofinal.enuns.TipoEnum;
import br.com.senior.desafiofinal.model.Cliente;

/**
 * Classe usada para retorno filtrado de Cliente
 * 
 * @author Jefferson Möller
 *
 */
public class ClienteDTO {
	private Long codigo;
	private String nome;
	private String documento;
	private TipoEnum tipoEnum;

	/**
	 * Construtor ClienteDTO
	 * 
	 * @param cliente
	 */
	public ClienteDTO(Cliente cliente) {
		super();
		this.codigo = cliente.getCodigo();
		this.nome = cliente.getNome();
		documento = cliente.getDocumento();
		this.tipoEnum = cliente.getTipoEnum();
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

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
	 * Metodo que retorna Lista Convertida Paginada
	 * 
	 * @param clientes
	 * @return Page<ClienteDTO>
	 */
	public static Page<ClienteDTO> converterPage(Page<Cliente> clientes) {
		return clientes.map(ClienteDTO::new);
	}

	/**
	 * Metodo que retorna Lista Convertida
	 * 
	 * @param clientes
	 * @return List<ClienteDTO>
	 */
	public static List<ClienteDTO> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
