/**
 * 
 */
package br.com.senior.desafiofinal.controllers.util.atualiza;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.senior.desafiofinal.model.ItensDePedido;
import br.com.senior.desafiofinal.model.Pedido;
import br.com.senior.desafiofinal.model.Produto;
import br.com.senior.desafiofinal.repositories.ItensDePedidoRepository;

/**
 * Classe usada para atualizaces de informações do Itens de Pedido
 * 
 * @author Jefferson Möller
 *
 */
public class AtualizaItensDePedidoDTO {

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
	 * Metodo usado para atualizar
	 * 
	 * @param id
	 * @param itensDePedidoRepository
	 * @return
	 */
	public ItensDePedido atualizar(Long id, ItensDePedidoRepository itensDePedidoRepository) {
		ItensDePedido itensDePedido = itensDePedidoRepository.getOne(id);
		itensDePedido.setCodigo(id);
		itensDePedido.setValorUnitario(valorUnitario);
		itensDePedido.setUnidadeMedida(unidadeMedida);
		itensDePedido.setProduto(produto);
		itensDePedido.setPedido(pedido);

		return itensDePedido;
	}
}
