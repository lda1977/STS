package com.alaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.validation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alaworks.osworks.domain.model.Cliente;
import com.alaworks.osworks.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@GetMapping
	public List<Cliente> listar() {	
		return ClienteRepository.findAll();
		//return ClienteRepository.findByNomeContaining("Ju");
	}
	
	/* 
	 * buscando no banco de dados por cliente */
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = ClienteRepository.findById(clienteId);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
			
		}
		
		return ResponseEntity.notFound().build();
	}
	/* Adicionando no Banco novo Cliente */
	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return ClienteRepository.save(cliente);
	}

	/* Atualizando no banco de dados a tabela cliente id 1 */
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar (@PathVariable Long clienteId, 
			@RequestBody Cliente cliente){
		if(!ClienteRepository.existsById(clienteId)) {
			
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		cliente = ClienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	/* Metodo Deleta recebedo o Id di cliente */
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		
		if(!ClienteRepository.existsById(clienteId)) {
			
			return ResponseEntity.notFound().build();
		}
		ClienteRepository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}
}
