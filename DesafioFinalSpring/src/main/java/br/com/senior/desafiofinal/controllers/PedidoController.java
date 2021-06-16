/**
 * 
 */
package br.com.senior.desafiofinal.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senior.desafiofinal.controllers.util.atualiza.AtualizaPedidoDTO;
import br.com.senior.desafiofinal.controllers.util.dto.PedidoDTO;
import br.com.senior.desafiofinal.controllers.util.forms.PedidoForm;
import br.com.senior.desafiofinal.model.Pedido;
import br.com.senior.desafiofinal.repositories.PedidoRepository;

/**
 * Classe criada como controlador do Pedido
 * 
 * @author Jefferson Möller
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;

	/**
	 * Metodo para Criação de Pedido
	 * 
	 * @param pedidoForm
	 * @param builder
	 * @return ResponseEntity<PedidoDTO>
	 */
	@PostMapping
	public ResponseEntity<PedidoDTO> create(@RequestBody @Valid PedidoForm pedidoForm, UriComponentsBuilder builder) {
		Pedido pedidoConvertido = pedidoForm.converter();

		pedidoRepository.save(pedidoConvertido);
		URI uri = builder.path("/pedido/{id}").buildAndExpand(pedidoConvertido.getId()).toUri();

		return ResponseEntity.created(uri).body(new PedidoDTO(pedidoConvertido));

	}

	/**
	 * Metodo para buscar Pedido pelo id
	 * 
	 * @param id
	 * @return ResponseEntity<Object>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> read(@PathVariable Long id) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(id);
		if (pedidoBuscado.isPresent()) {
			Pedido itensDePedido = pedidoBuscado.get();
			return ResponseEntity.ok(new PedidoDTO(itensDePedido));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para alterar informações do Pedido
	 * 
	 * @param id
	 * @param atualizaPedidoDto
	 * @return ResponseEntity<PedidoDTO>
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PedidoDTO> update(@PathVariable Long id,
			@RequestBody @Valid AtualizaPedidoDTO atualizaPedidoDto) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(id);

		if (pedidoBuscado.isPresent()) {
			Pedido pedido = atualizaPedidoDto.atualizar(id, pedidoRepository);
			return ResponseEntity.ok(new PedidoDTO(pedido));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para deletar Pedido
	 * 
	 * @param id
	 * @return ResponseEntity<Pedido>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Pedido> delete(@PathVariable Long id) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(id);
		if (pedidoBuscado.isPresent()) {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para listar Pedido de forma Paginada
	 * 
	 * @param pagina
	 * @param qtd
	 * @return Page<PedidoDTO>
	 */
	@GetMapping
	public Page<PedidoDTO> list(@RequestParam int pagina, @RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
		return PedidoDTO.converter(pedidoRepository.findAll(paginacao));
	}

}
