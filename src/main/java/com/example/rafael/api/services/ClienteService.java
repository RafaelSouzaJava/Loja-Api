package com.example.rafael.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rafael.api.domain.Cliente;
import com.example.rafael.api.repositories.ClienteRepository;
import com.example.rafael.api.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrato! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
