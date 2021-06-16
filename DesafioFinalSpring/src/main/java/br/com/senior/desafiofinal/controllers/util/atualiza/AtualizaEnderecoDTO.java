/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.atualiza;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.senior.desafiofinal.model.Endereco;
import br.com.senior.desafiofinal.repositories.EnderecoRepository;

/**
 * Classe usada para atualizaces de informações do Endereco
 * 
 * @author Jefferson Möller
 *
 */
public class AtualizaEnderecoDTO {

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
	 * Metodo usado para atualizar
	 * 
	 * @param id
	 * @param enderecoRepository
	 * @return
	 */
	public Endereco atualizar(Long id, EnderecoRepository enderecoRepository) {
		Endereco endereco = enderecoRepository.getOne(id);
		endereco.setLogradouro(this.logradouro);
		endereco.setNumero(this.numero);
		endereco.setBairro(this.bairro);
		endereco.setCidade(this.cidade);
		endereco.setCep(this.cep);
		return endereco;
	}

}
