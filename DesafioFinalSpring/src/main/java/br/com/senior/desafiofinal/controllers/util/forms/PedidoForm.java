/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.senior.desafiofinal.model.Cliente;
import br.com.senior.desafiofinal.model.Endereco;
import br.com.senior.desafiofinal.model.Pedido;

/**
 * Classe usada para cadastro de Pedidos
 * 
 * @author Jefferson Möller
 *
 */
public class PedidoForm {

	private BigDecimal valorTotal;
	private Double qtdTotal;
	private Double desconto;

	@NotNull
	private Endereco endereco;

	@NotNull
	private Cliente cliente;

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @return the qtdTotal
	 */
	public Double getQtdTotal() {
		return qtdTotal;
	}

	/**
	 * @return the desconto
	 */
	public Double getDesconto() {
		return desconto;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Metodo converte para Pedido
	 * 
	 * @return Pedido
	 */
	public Pedido converter() {
		return new Pedido(endereco, cliente);
	}

}
