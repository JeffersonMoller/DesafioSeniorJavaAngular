/**
 * 
 */
package br.com.senior.desafiofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senior.desafiofinal.model.Produto;

/**
 * @author Jefferson Möller
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
