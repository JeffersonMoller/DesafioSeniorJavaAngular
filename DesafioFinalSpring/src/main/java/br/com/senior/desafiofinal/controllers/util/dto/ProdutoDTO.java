/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.senior.desafiofinal.enuns.StatusEnum;
import br.com.senior.desafiofinal.model.Produto;

/**
 * Classe usada para retorno filtrado de Produto
 * 
 * @author Jefferson Möller
 *
 */
public class ProdutoDTO {

	private Long id;
	private StatusEnum statusEnum;
	private Long codigo;
	private String descricao;
	private String unidadeDeMedida;
	private Double qtdTotal;

	/**
	 * Construtor
	 * 
	 * @param id
	 * @param statusEnum
	 * @param codigo
	 * @param descricao
	 * @param unidadeDeMedida
	 * @param qtdTotal
	 */
	public ProdutoDTO(Produto produto) {
		super();
		this.id = produto.getId();
		this.codigo = produto.getCodigo();
		this.statusEnum = produto.getStatusEnum();
		this.descricao = produto.getDescricao();
		this.unidadeDeMedida = produto.getUnidadeDeMedida();
		this.qtdTotal = produto.getQtdTotal();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

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
	 * Metodo que retorna Lista Paginada
	 * 
	 * @param produto
	 * @return Page<ProdutoDTO>
	 */
	public static Page<ProdutoDTO> converterPage(Page<Produto> produto) {
		return produto.map(ProdutoDTO::new);
	}
	
	/**
	 * Metodo que retorna Lista Convertida
	 * 
	 * @param produto
	 * @return List<ProdutoDTO>
	 */
	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
