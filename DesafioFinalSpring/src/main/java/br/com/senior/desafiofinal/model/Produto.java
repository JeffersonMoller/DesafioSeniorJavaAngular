/**
 * 
 */
package br.com.senior.desafiofinal.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.senior.desafiofinal.enuns.StatusEnum;

/**
 * Classe que representa a entidade Produto
 * @author Jefferson Möller
 *
 */

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private StatusEnum statusEnum;

	private Long codigo;
	private String descricao;
	private String unidadeDeMedida;

	private Double qtdTotal;

	/**
	 * Construtor Vazio
	 */
	public Produto() {
		super();
	}

	/**
	 * @param id
	 * @param codigo
	 * @param descricao
	 * @param unidadeDeMedida
	 * @param qtdTotal
	 */
	public Produto(Long codigo, String descricao, String unidadeDeMedida, Double qtdTotal) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeDeMedida = unidadeDeMedida;
		this.statusEnum = StatusEnum.ATIVO;
		this.qtdTotal = qtdTotal;
	}

	/**
	 * @param id
	 * @param codigo
	 * @param descricao
	 * @param unidadeDeMedida
	 * @param qtdTotal
	 */
	public Produto(Long id, Long codigo, String descricao, String unidadeDeMedida, Double qtdTotal) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeDeMedida = unidadeDeMedida;
		this.statusEnum = StatusEnum.ATIVO;
		this.qtdTotal = qtdTotal;
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the unidadeDeMedida
	 */
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	/**
	 * @param unidadeDeMedida the unidadeDeMedida to set
	 */
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	/**
	 * @return the statusEnum
	 */
	public StatusEnum getStatusEnum() {
		return statusEnum;
	}

	/**
	 * @param statusEnum the statusEnum to set
	 */
	public void setStatusEnum(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qtdTotal == null) ? 0 : qtdTotal.hashCode());
		result = prime * result + ((statusEnum == null) ? 0 : statusEnum.hashCode());
		result = prime * result + ((unidadeDeMedida == null) ? 0 : unidadeDeMedida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qtdTotal == null) {
			if (other.qtdTotal != null)
				return false;
		} else if (!qtdTotal.equals(other.qtdTotal))
			return false;
		if (statusEnum != other.statusEnum)
			return false;
		if (unidadeDeMedida == null) {
			if (other.unidadeDeMedida != null)
				return false;
		} else if (!unidadeDeMedida.equals(other.unidadeDeMedida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", unidadeDeMedida="
				+ unidadeDeMedida + ", statusEnum=" + statusEnum + ", qtdTotal=" + qtdTotal + "]";
	}

}
