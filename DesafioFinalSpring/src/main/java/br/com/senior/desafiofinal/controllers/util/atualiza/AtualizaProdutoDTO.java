/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.atualiza;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.senior.desafiofinal.enuns.StatusEnum;
import br.com.senior.desafiofinal.model.Produto;
import br.com.senior.desafiofinal.repositories.ProdutoRepository;

/**
 * Classe usada para atualizaces de informações do Produto
 * @author Jefferson Möller
 *
 */
public class AtualizaProdutoDTO {

	@NotNull
	private StatusEnum statusEnum;
	
	@NotNull
	private Long codigo;
	
	@NotNull
	@NotEmpty
	private String descricao;
	
	@NotNull
	@NotEmpty
	private String unidadeDeMedida;
	
	@NotNull
	private Double qtdTotal;

	/**
	 * @return the statusEnum
	 */
	public StatusEnum getStatusEnum() {
		return statusEnum;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the unidadeDeMedida
	 */
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	/**
	 * @return the qtdTotal
	 */
	public Double getQtdTotal() {
		return qtdTotal;
	}

	/**
	 * Metodo usado para atualizar
	 * 
	 * @param id
	 * @param produtoRepository
	 * @return
	 */
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		produto.setCodigo(id);
		produto.setDescricao(descricao);
		produto.setUnidadeDeMedida(unidadeDeMedida);
		produto.setQtdTotal(qtdTotal);
		produto.setStatusEnum(statusEnum);
		return produto;
	}

}
