/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.atualiza;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.senior.desafiofinal.model.Cliente;
import br.com.senior.desafiofinal.model.Endereco;
import br.com.senior.desafiofinal.model.Pedido;
import br.com.senior.desafiofinal.repositories.PedidoRepository;

/**
 * Classe usada para atualizaces de informações do Pedido
 * 
 * @author Jefferson Möller
 *
 */
public class AtualizaPedidoDTO {

	@NotNull
	private BigDecimal valorTotal;

	@NotNull
	private Double qtdTotal;

	@NotNull
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
	 * Metodo usado para atualizar
	 * 
	 * @param id
	 * @param pedidoRepository
	 * @return
	 */
	public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {
		Pedido pedido = pedidoRepository.getOne(id);
		pedido.setValorTotal(this.valorTotal);
		pedido.setQtdTotal(this.qtdTotal);
		pedido.setDesconto(this.desconto);
		pedido.setEndereco(this.endereco);
		pedido.setCliente(this.cliente);
		return pedido;
	}

}
