package com.example.rafael.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rafael.api.domain.Categoria;
import com.example.rafael.api.repositories.CategoriaRepository;
import com.example.rafael.api.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
