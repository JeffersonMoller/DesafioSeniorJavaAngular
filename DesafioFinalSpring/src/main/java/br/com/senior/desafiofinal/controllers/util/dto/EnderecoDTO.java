/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.dto;

import org.springframework.data.domain.Page;

import br.com.senior.desafiofinal.model.Endereco;

/**
 * Classe usada para retorno filtrado de Endereco
 * 
 * @author Jefferson Möller
 *
 */
public class EnderecoDTO {
	private Long id;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String cep;

	/**
	 * Construtor
	 * 
	 * @param id
	 * @param logradouro
	 * @param numero
	 * @param bairro
	 * @param cidade
	 * @param cep
	 */
	public EnderecoDTO(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.cep = endereco.getCep();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

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
	 * Metodo que retorna Lista Paginada
	 * 
	 * @param endereco
	 * @return Page<EnderecoDTO>
	 */
	public static Page<EnderecoDTO> converter(Page<Endereco> endereco) {
		return endereco.map(EnderecoDTO::new);
	}

}
