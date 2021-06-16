/**
 * 
 */
package br.com.senior.desafiofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senior.desafiofinal.model.Cliente;

/**
 * @author Jefferson Möller
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
