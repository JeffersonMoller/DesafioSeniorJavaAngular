/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.senior.desafiofinal.model.Produto;

/**
 * Classe usada para cadastro de Produtos
 * 
 * @author Jefferson Möller
 *
 */
public class ProdutoForm {

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
	 * Metodo converte para Produto
	 * 
	 * @return Produto
	 */
	public Produto converter() {
		return new Produto(codigo, descricao, unidadeDeMedida, qtdTotal);
	}
}
