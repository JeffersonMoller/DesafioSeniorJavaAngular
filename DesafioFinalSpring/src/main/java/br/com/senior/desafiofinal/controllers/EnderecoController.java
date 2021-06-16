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

import br.com.senior.desafiofinal.controllers.util.atualiza.AtualizaEnderecoDTO;
import br.com.senior.desafiofinal.controllers.util.dto.EnderecoDTO;
import br.com.senior.desafiofinal.controllers.util.forms.EnderecoForm;
import br.com.senior.desafiofinal.model.Endereco;
import br.com.senior.desafiofinal.repositories.EnderecoRepository;

/**
 * Classe criada como controlador do Endereço
 * 
 * @author Jefferson Möller
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;

	/**
	 * Metodo para Criação de Endereco
	 * 
	 * @param enderecoForm
	 * @param builder
	 * @return ResponseEntity<EnderecoDTO>
	 */
	@PostMapping
	public ResponseEntity<EnderecoDTO> create(@RequestBody @Valid EnderecoForm enderecoForm,
			UriComponentsBuilder builder) {
		Endereco enderecoConvertido = enderecoForm.converter();

		enderecoRepository.save(enderecoConvertido);
		URI uri = builder.path("/endereco/{id}").buildAndExpand(enderecoConvertido.getId()).toUri();

		return ResponseEntity.created(uri).body(new EnderecoDTO(enderecoConvertido));

	}

	/**
	 * Metodo para Buscar Endereco pelo id
	 * 
	 * @param id
	 * @return ResponseEntity<EnderecoDTO>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> read(@PathVariable Long id) {
		Optional<Endereco> enderecobuscado = enderecoRepository.findById(id);
		if (enderecobuscado.isPresent()) {
			Endereco endereco = enderecoRepository.getOne(id);
			return ResponseEntity.ok(new EnderecoDTO(endereco));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para alteração de informações de endereço
	 * 
	 * @param id
	 * @param atualizaEnderecoDto
	 * @return ResponseEntity<EnderecoDTO>
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDTO> update(@PathVariable Long id,
			@RequestBody @Valid AtualizaEnderecoDTO atualizaEnderecoDto) {
		Optional<Endereco> enderecoBuscado = enderecoRepository.findById(id);

		if (enderecoBuscado.isPresent()) {
			Endereco endereco = atualizaEnderecoDto.atualizar(id, enderecoRepository);
			return ResponseEntity.ok(new EnderecoDTO(endereco));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para deletar Endereço
	 * 
	 * @param id
	 * @return ResponseEntity<Endereco>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Endereco> delete(@PathVariable Long id) {
		Optional<Endereco> enderecoBuscado = enderecoRepository.findById(id);
		if (enderecoBuscado.isPresent()) {
			enderecoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para Listar Endereço de forma Paginada
	 * 
	 * @param pagina
	 * @param qtd
	 * @return Page<EnderecoDTO>
	 */
	@GetMapping
	public Page<EnderecoDTO> list(@RequestParam int pagina, @RequestParam int qtd) {
		Pageable paginacao = PageRequest.of(pagina, qtd);
		return EnderecoDTO.converter(enderecoRepository.findAll(paginacao));
	}

}
