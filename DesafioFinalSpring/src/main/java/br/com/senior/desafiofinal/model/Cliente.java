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

import br.com.senior.desafiofinal.enuns.TipoEnum;

/**
 * Classe que representa a Entidade Cliente
 * 
 * @author Jefferson Möller
 *
 */

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Codigo;

	@Enumerated(EnumType.STRING)
	private TipoEnum tipoEnum;

	private String nome;

	private String documento;

	/**
	 * Construtor vazio
	 */
	public Cliente() {
		super();
	}

	/**
	 * @param nome
	 * @param documento
	 * @param enumTipo
	 */
	public Cliente(String nome, String documento, TipoEnum tipoEnum) {
		this.nome = nome;
		this.documento = documento;
		this.tipoEnum = tipoEnum;
	}

	/**
	 * @param codigo
	 * @param nome
	 * @param documento
	 * @param enumTipo
	 */
	public Cliente(Long codigo, String nome, String documento, TipoEnum tipoEnum) {
		super();
		this.Codigo = codigo;
		this.nome = nome;
		this.documento = documento;
		this.tipoEnum = tipoEnum;
	}

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return Codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}

	/**
	 * @return the enumTipo
	 */
	public TipoEnum getTipoEnum() {
		return tipoEnum;
	}

	/**
	 * @param enumTipo the enumTipo to set
	 */
	public void setTipoEnum(TipoEnum enumTipo) {
		this.tipoEnum = enumTipo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoEnum == null) ? 0 : tipoEnum.hashCode());
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
		Cliente other = (Cliente) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoEnum != other.tipoEnum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [Codigo=" + Codigo + ", nome=" + nome + ", Documento=" + documento + ", tipoEnum=" + tipoEnum
				+ "]";
	}

}
