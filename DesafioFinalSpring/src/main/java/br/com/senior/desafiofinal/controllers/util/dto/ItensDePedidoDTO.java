/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import br.com.senior.desafiofinal.model.ItensDePedido;
import br.com.senior.desafiofinal.model.Pedido;
import br.com.senior.desafiofinal.model.Produto;

/**
 * Classe usada para retorno filtrado de Itens de Pedido
 * 
 * @author Jefferson Möller
 *
 */
public class ItensDePedidoDTO {

	private Long id;
	private Long codigo;
	private BigDecimal valorUnitario;
	private String unidadeMedida;
	private Produto produto;
	private Pedido pedido;

	/**
	 * Construtor
	 * 
	 * @param id
	 * @param codigo
	 * @param valorUnitario
	 * @param unidadeMedida
	 * @param produto
	 * @param pedido
	 */
	public ItensDePedidoDTO(ItensDePedido itensDePedido) {
		super();
		this.id = itensDePedido.getId();
		this.codigo = itensDePedido.getCodigo();
		this.valorUnitario = itensDePedido.getValorUnitario();
		this.unidadeMedida = itensDePedido.getUnidadeMedida();
		this.produto = itensDePedido.getProduto();
		this.pedido = itensDePedido.getPedido();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @return the valorUnitario
	 */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * @return the unidadeMedida
	 */
	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * Metodo que retorna Lista Paginada
	 * 
	 * @param itensDePedido
	 * @return Page<ItensDePedidoDTO>
	 */
	public static Page<ItensDePedidoDTO> converter(Page<ItensDePedido> itensDePedido) {
		return itensDePedido.map(ItensDePedidoDTO::new);
	}

}
