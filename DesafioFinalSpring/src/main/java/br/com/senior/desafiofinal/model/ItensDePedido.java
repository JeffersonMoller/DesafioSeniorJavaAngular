/**
 * 
 */
package br.com.senior.desafiofinal.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe que representa a entidade Itens de Pedido
 * @author Jefferson Möller
 *
 */

@Entity
public class ItensDePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long codigo;
	private BigDecimal valorUnitario;
	private String unidadeMedida;

	@OneToOne
	private Produto produto;

	@ManyToOne
	private Pedido pedido;

	/**
	 * Construtor Vazio
	 */
	public ItensDePedido() {
		super();
	}

	/**
	 * @param id
	 * @param codigo
	 * @param valorUnitario
	 * @param unidadeMedida
	 * @param produto
	 * @param pedido
	 */
	public ItensDePedido(Long codigo, BigDecimal valorUnitario, String unidadeMedida, Produto produto, Pedido pedido) {
		super();
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.unidadeMedida = unidadeMedida;
		this.produto = produto;
		this.pedido = pedido;
	}

	/**
	 * @param id
	 * @param codigo
	 * @param valorUnitario
	 * @param unidadeMedida
	 * @param produto
	 * @param pedido
	 */
	public ItensDePedido(Long id, Long codigo, BigDecimal valorUnitario, String unidadeMedida, Produto produto,
			Pedido pedido) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.unidadeMedida = unidadeMedida;
		this.produto = produto;
		this.pedido = pedido;
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
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the valorUnitario
	 */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * @param valorUnitario the valorUnitario to set
	 */
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * @return the unidadeMedida
	 */
	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	/**
	 * @param unidadeMedida the unidadeMedida to set
	 */
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	/**
	 * @return the produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "ItensDePedido [id=" + id + ", codigo=" + codigo + ", valorUnitario=" + valorUnitario
				+ ", unidadeMedida=" + unidadeMedida + ", produto=" + produto + ", pedido=" + pedido + "]";
	}

}
