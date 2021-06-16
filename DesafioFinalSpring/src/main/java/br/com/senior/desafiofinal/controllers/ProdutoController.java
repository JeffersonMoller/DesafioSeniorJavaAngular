/**
 * 
 */
package br.com.senior.desafiofinal.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senior.desafiofinal.controllers.util.atualiza.AtualizaProdutoDTO;
import br.com.senior.desafiofinal.controllers.util.dto.ProdutoDTO;
import br.com.senior.desafiofinal.controllers.util.forms.ProdutoForm;
import br.com.senior.desafiofinal.model.Produto;
import br.com.senior.desafiofinal.repositories.ProdutoRepository;

/**
 * Classe criada como controlador do Produto
 * 
 * @author Jefferson Möller
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	/**
	 * Metodo para Criação de Cliente
	 * 
	 * @param produtoForm
	 * @param builder
	 * @return ResponseEntity<ProdutoDTO>
	 */
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@RequestBody @Valid ProdutoForm produtoForm,
			UriComponentsBuilder builder) {
		Produto produtoConvertido = produtoForm.converter();

		produtoRepository.save(produtoConvertido);
		URI uri = builder.path("/produto/{id}").buildAndExpand(produtoConvertido.getId()).toUri();

		return ResponseEntity.created(uri).body(new ProdutoDTO(produtoConvertido));

	}

	/**
	 * Metodo para buscar Produto pelo id
	 * 
	 * @param id
	 * @return ResponseEntity<ProdutoDTO>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> read(@PathVariable Long id) {
		Optional<Produto> produtoBuscado = produtoRepository.findById(id);
		if (produtoBuscado.isPresent()) {
			Produto produto = produtoBuscado.get();
			return ResponseEntity.ok(new ProdutoDTO(produto));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para alterar informações do produto
	 * 
	 * @param id
	 * @param atualizaProdutoDTO
	 * @return ResponseEntity<ProdutoDTO>
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id,
			@RequestBody @Valid AtualizaProdutoDTO atualizaProdutoDTO) {
		Optional<Produto> produtoBuscado = produtoRepository.findById(id);

		if (produtoBuscado.isPresent()) {
			Produto produto = atualizaProdutoDTO.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDTO(produto));
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para deletar Produto
	 * 
	 * @param id
	 * @return ResponseEntity<Produto>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> delete(@PathVariable Long id) {
		Optional<Produto> produtoBuscado = produtoRepository.findById(id);
		if (produtoBuscado.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/**
	 * Metodo para listar Produto de forma paginada
	 * 
	 * @param pagina
	 * @param qtd
	 * @return Page<ProdutoDTO>
	 */
//	@GetMapping
//	public Page<ProdutoDTO> listPage(@RequestParam int pagina, @RequestParam int qtd) {
//		Pageable paginacao = PageRequest.of(pagina, qtd);
//		return ProdutoDTO.converterPage(produtoRepository.findAll(paginacao));
//	}

	/**
	 * Metodo para listar Produtos
	 * 
	 * @return List<ProdutoDTO>
	 */
	@GetMapping
	public List<ProdutoDTO> list() {
		return ProdutoDTO.converter(produtoRepository.findAll());
	}

}
