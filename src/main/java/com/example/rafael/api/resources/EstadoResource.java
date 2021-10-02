package com.example.rafael.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.rafael.api.domain.Cidade;
import com.example.rafael.api.domain.Estado;
import com.example.rafael.api.domain.dto.CidadeDTO;
import com.example.rafael.api.domain.dto.EstadoDTO;
import com.example.rafael.api.services.CidadeService;
import com.example.rafael.api.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> estado = estadoService.findAll();
		List<EstadoDTO> listDto = estado.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value = "/{estadoId}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> cidades = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDto = cidades.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
