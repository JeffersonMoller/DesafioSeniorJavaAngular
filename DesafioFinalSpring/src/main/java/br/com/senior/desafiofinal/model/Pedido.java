/**
 * 
 */
package br.com.senior.desafiofinal.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.senior.desafiofinal.enuns.SituacaoPedidoEnum;

/**
 * Classe que representa a entidade Pedido
 * @author Jefferson Möller
 *
 */

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private SituacaoPedidoEnum situacaoPedidoEnum;

	private LocalDateTime dataCriacao;
	private BigDecimal valorTotal;
	private Double qtdTotal;
	private Double desconto;
	@OneToOne
	private Endereco endereco;

	@ManyToOne
	private Cliente cliente;

	/**
	 * Construtor Vazio
	 */
	public Pedido() {
		super();
	}

	/*
	 * @param endereco
	 * 
	 * @param cliente
	 */
	public Pedido(Endereco endereco, Cliente cliente) {
		this.situacaoPedidoEnum = SituacaoPedidoEnum.ABERTO;
		this.dataCriacao = LocalDateTime.now();
		this.valorTotal = new BigDecimal("0.0");
		this.qtdTotal = 0.0;
		this.desconto = 0.0;
		this.endereco = endereco;
		this.cliente = cliente;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the enumSituacao
	 */
	public SituacaoPedidoEnum getSituacaoPedidoEnum() {
		return situacaoPedidoEnum;
	}

	/**
	 * @param enumSituacao the enumSituacao to set
	 */
	public void setSituacaoPedidoEnum(SituacaoPedidoEnum situacaoPedidoEnum) {
		this.situacaoPedidoEnum = situacaoPedidoEnum;
	}

	/**
	 * @return the dataCriacao
	 */
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the qtdTotal
	 */
	public Double getQtdTotal() {
		return qtdTotal;
	}

	/**
	 * @param qtdTotal the qtdTotal to set
	 */
	public void setQtdTotal(Double qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	/**
	 * @return the desconto
	 */
	public Double getDesconto() {
		return desconto;
	}

	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", situacaoPedidoEnum=" + situacaoPedidoEnum + ", dataCriacao=" + dataCriacao
				+ ", valorTotal=" + valorTotal + ", qtdTotal=" + qtdTotal + ", desconto=" + desconto + ", endereco="
				+ endereco + ", cliente=" + cliente + "]";
	}

}
