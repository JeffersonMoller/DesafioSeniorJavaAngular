/**
 * 
 */
package br.com.senior.desafiofinal.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senior.desafiofinal.controllers.util.atualiza.AtualizaClienteDTO;
import br.com.senior.desafiofinal.controllers.util.dto.ClienteDTO;
import br.com.senior.desafiofinal.controllers.util.forms.ClienteForm;
import br.com.senior.desafiofinal.model.Cliente;
import br.com.senior.desafiofinal.repositories.ClienteRepository;

/**
 * Classe criada como controlador do Cliente
 * 
 * @author Jefferson Möller
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	/**
	 * Metodo para Criação de Cliente
	 * 
	 * @param clienteForm
	 * @param builder
	 * @return ResponseEntity<ClienteDTO>
	 * @throws Exception
	 */
	
	@PostMapping
	public ResponseEntity<ClienteDTO> create(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder builder)
			throws Exception {

		Optional<Cliente> clienteConvertido = clienteForm.converter();

		if (clienteConvertido.isPresent()) {
			clienteRepository.save(clienteConvertido.get());
			URI uri = builder.path("/cliente/{codigo}").buildAndExpand(clienteConvertido.get().getCodigo()).toUri();
			return ResponseEntity.created(uri).body(new ClienteDTO(clienteConvertido.get()));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para buscar Cliente pelo Id
	 * 
	 * @param codigo
	 * @return ResponseEntity<ClienteDTO>
	 */
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteDTO> read(@PathVariable Long codigo) {
		Optional<Cliente> clienteBuscado = clienteRepository.findById(codigo);

		if (clienteBuscado.isPresent()) {
			Cliente cliente = clienteRepository.getOne(codigo);
			return ResponseEntity.ok(new ClienteDTO(cliente));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para Alterar informações de Cliente
	 * 
	 * @param codigo
	 * @param atualizaClienteDto
	 * @return ResponseEntity<ClienteDTO>
	 */
	@PutMapping("/{codigo}")
	@Transactional
	public ResponseEntity<ClienteDTO> update(@PathVariable Long codigo,
			@RequestBody @Valid AtualizaClienteDTO atualizaClienteDto) throws Exception {
		Optional<Cliente> cliente = atualizaClienteDto.atualizar(codigo, clienteRepository);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDTO(cliente.get()));
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}

	/**
	 * Metodo para deletar CLiente
	 * 
	 * @param codigo
	 * @return ResponseEntity<Cliente>
	 */
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Cliente> delete(@PathVariable Long codigo) {
		Optional<Cliente> clienteBuscado = clienteRepository.findById(codigo);

		if (clienteBuscado.isPresent()) {
			clienteRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para Listar CLiente de forma Paginada
	 * 
	 * @param pagina
	 * @param qtd
	 * @return Page<ClienteDTO>
	 */
//	@GetMapping
//	public Page<ClienteDTO> listPagination(@RequestParam int pagina, @RequestParam int qtd) {
//		Pageable paginacao = PageRequest.of(pagina, qtd);
//		return ClienteDTO.converterPage(clienteRepository.findAll(paginacao));
//	}
	
	/**
	 * Metodo para Listar CLiente 
	 * @return List<ClienteDTO>
	 */
	@GetMapping
	public List<ClienteDTO> list() {
		return ClienteDTO.converter(clienteRepository.findAll());
	}

}
