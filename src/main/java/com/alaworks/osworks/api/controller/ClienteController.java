package com.alaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alaworks.osworks.domain.model.Cliente;
import com.alaworks.osworks.domain.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {	
		return ClienteRepository.findAll();
		//return ClienteRepository.findByNomeContaining("Ju");
	}

}
