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

import br.com.senior.desafiofinal.controllers.util.atualiza.AtualizaItensDePedidoDTO;
import br.com.senior.desafiofinal.controllers.util.dto.ItensDePedidoDTO;
import br.com.senior.desafiofinal.controllers.util.forms.ItensDePedidoForm;
import br.com.senior.desafiofinal.model.ItensDePedido;
import br.com.senior.desafiofinal.repositories.ItensDePedidoRepository;

/**
 * Classe criada como controlador do Itens de Pedido
 * 
 * @author Jefferson Möller
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/itensdepedido")
public class ItensDePedidoController {

	@Autowired
	ItensDePedidoRepository itensDePedidoRepository;

	/**
	 * Metodo para Criação de Itens de Pedido
	 * 
	 * @param itensDePedidoForm
	 * @param builder
	 * @return ResponseEntity<ItensDePedidoDTO>
	 */
	@PostMapping
	public ResponseEntity<ItensDePedidoDTO> create(@RequestBody @Valid ItensDePedidoForm itensDePedidoForm,
			UriComponentsBuilder builder) {
		ItensDePedido itensDePedidoConvertido = itensDePedidoForm.converter();

		itensDePedidoRepository.save(itensDePedidoConvertido);
		URI uri = builder.path("/itensdepedido/{id}").buildAndExpand(itensDePedidoConvertido.getId()).toUri();

		return ResponseEntity.created(uri).body(new ItensDePedidoDTO(itensDePedidoConvertido));

	}

	/**
	 * Metodo para buscar Itens de Pedido pelo id
	 * 
	 * @param id
	 * @return ResponseEntity<ItensDePedidoDTO>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ItensDePedidoDTO> read(@PathVariable Long id) {
		Optional<ItensDePedido> itensDePedidoBuscado = itensDePedidoRepository.findById(id);

		if (itensDePedidoBuscado.isPresent()) {
			ItensDePedido itensDePedido = itensDePedidoBuscado.get();
			return ResponseEntity.ok(new ItensDePedidoDTO(itensDePedido));
		}
		return ResponseEntity.notFound().build();

	}

	/**
	 * Metodo para alterar informações de Itens de Pedido
	 * 
	 * @param id
	 * @param atualizaItensDePedidoDTO
	 * @return ResponseEntity<ItensDePedidoDTO>
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ItensDePedidoDTO> update(@PathVariable Long id,
			@RequestBody @Valid AtualizaItensDePedidoDTO atualizaItensDePedidoDTO) {
		Optional<ItensDePedido> itensDePedidoBuscado = itensDePedidoRepository.findById(id);

		if (itensDePedidoBuscado.isPresent()) {
			ItensDePedido itensDePedido = atualizaItensDePedidoDTO.atualizar(id, itensDePedidoRepository);
			return ResponseEntity.ok(new ItensDePedidoDTO(itensDePedido));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para deletar Itens de Pedido
	 * 
	 * @param id
	 * @return ResponseEntity<ItensDePedido>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ItensDePedido> delete(@PathVariable Long id) {
		Optional<ItensDePedido> itensDePedidoBuscado = itensDePedidoRepository.findById(id);
		if (itensDePedidoBuscado.isPresent()) {
			itensDePedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para listar Itens de Pedido de forma Paginada
	 * 
	 * @param pagina
	 * @param qtd
	 * @return Page<ItensDePedidoDTO>
	 */
	@GetMapping
	public Page<ItensDePedidoDTO> list(@RequestParam int pagina, @RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
		return ItensDePedidoDTO.converter(itensDePedidoRepository.findAll(paginacao));
	}

}
