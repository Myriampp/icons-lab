package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/continentes")

public class ContinenteController {
	
	@Autowired
	private ContinenteService continenteService;
	
	/* Endpoint para guardar el continente*/
	
	@PostMapping("/save")
	public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
		
		/*	save continente //201, continente Guardado*/	
		
		ContinenteDTO continenteGuardado = continenteService.save(continente);

		return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
  }
	
	@GetMapping
	public ResponseEntity<List<ContinenteDTO>> getAll(){
		List<ContinenteDTO> continentes = this.continenteService.getAllContinentes();
		return ResponseEntity.ok().body(continentes);
		
		
	}
	

}
