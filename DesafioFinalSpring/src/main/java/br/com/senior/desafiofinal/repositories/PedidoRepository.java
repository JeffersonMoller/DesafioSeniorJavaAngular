/**
 * 
 */
package br.com.senior.desafiofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senior.desafiofinal.model.Pedido;

/**
 * @author Jefferson Möller
 *
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
