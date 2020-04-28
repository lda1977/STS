package com.alaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {

		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("joca que Furi");
		cliente1.setTelefone("41-55555-9999");
		cliente1.setEmail("juca@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria Rosa");
		cliente2.setTelefone("44-22222-8888");
		cliente2.setEmail("maria@gmail.com");
		
		/* Retorna uma lista com cliente1 e cliente2 */
		return Arrays.asList(cliente1, cliente2);
	}

}
