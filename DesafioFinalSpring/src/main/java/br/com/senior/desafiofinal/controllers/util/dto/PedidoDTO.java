/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.senior.desafiofinal.model.Cliente;
import br.com.senior.desafiofinal.model.Endereco;
import br.com.senior.desafiofinal.model.Pedido;

/**
 * Classe usada para retorno filtrado de Pedido
 * @author Jefferson Möller
 *
 */
public class PedidoDTO {

	private Long id;
	private LocalDateTime dataCriacao;
	private BigDecimal valorTotal;
	private Double qtdTotal;
	private Double desconto;
	private Endereco endereco;
	private Cliente cliente;

	/**
	 * Construtor
	 * @param dataCriacao
	 * @param valorTotal
	 * @param qtdTotal
	 * @param desconto
	 * @param endereco
	 * @param cliente
	 */
	public PedidoDTO(Pedido pedido) {
		super();
		this.id = pedido.getId();
		this.dataCriacao = pedido.getDataCriacao();
		this.valorTotal = pedido.getValorTotal();
		this.qtdTotal = pedido.getQtdTotal();
		this.desconto = pedido.getDesconto();
		this.endereco = pedido.getEndereco();
		this.cliente = pedido.getCliente();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the dataCriacao
	 */
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

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
	 * @return the cep
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
	 * Metodo que retorna Lista Paginada
	 * 
	 * @param pedido
	 * @return Page<PedidoDTO>
	 */
	public static Page<PedidoDTO> converter(Page<Pedido> pedido) {
		return pedido.map(PedidoDTO::new);
	}

}
