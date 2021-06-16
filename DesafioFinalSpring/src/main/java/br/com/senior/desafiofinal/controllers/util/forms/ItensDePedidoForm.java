/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.senior.desafiofinal.model.ItensDePedido;
import br.com.senior.desafiofinal.model.Pedido;
import br.com.senior.desafiofinal.model.Produto;

/**
 * Classe usada para cadastros de Itens de Pedido
 * 
 * @author Jefferson Möller
 *
 */
public class ItensDePedidoForm {

	@NotNull
	private Long codigo;

	@NotNull
	private BigDecimal valorUnitario;

	@NotNull
	@NotEmpty
	private String unidadeMedida;

	@NotNull
	private Produto produto;

	@NotNull
	private Pedido pedido;

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
	 * Metodo converte para ItensDePedido
	 * 
	 * @return ItensDePedido
	 */
	public ItensDePedido converter() {
		return new ItensDePedido(codigo, valorUnitario, unidadeMedida, produto, pedido);
	}

}
