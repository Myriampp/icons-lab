package com.alkemy.icons.icons.controller;
import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.alkemy.icons.icons.service.IconService;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("icons")

public class IconController {

	private IconService iconService;

	@Autowired
	public IconController(IconService iconService) {
		this.iconService = iconService;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IconBasicDTO>> getAll(){
		List<IconBasicDTO> icons= this.iconService.getAll();
		return ResponseEntity.ok(icons);
	}
	
	//
	@GetMapping("/{id}")
	public ResponseEntity<IconDTO> getDetailsById(@PathVariable Long Id){
	IconDTO icon = this.iconService.getDetailsById(Id);
	return ResponseEntity.ok(icon);
	}
	
	//
	@GetMapping
	public ResponseEntity<List<IconDTO>> getDetailsByFilters(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String date,
			@RequestParam(required = false) Set<Long> cities,
			@RequestParam(required = false, defaultValue = "ASC") String order
			){
		         List<IconDTO> icons = this.iconService.getByFilters(name, date, cities, order);
		         return ResponseEntity.ok(icons);
	}	
	//crear
	@PostMapping
	public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon){
		IconDTO result = this.iconService.save(icon);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	//actualizar
	@PutMapping("/{id}")
	public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon){
		IconDTO result = this.iconService.update(id, icon);
		return ResponseEntity.ok().body(result);
	}
	
	//eliminar con id
	@DeleteMapping("/{id}")
	public ResponseEntity<IconDTO> delete(@PathVariable Long id){
	this.iconService.delete(id);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	//eliminar el pais del icono
	@DeleteMapping("/{id}/pais/{idPais}")
	public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idPais){
		this.iconService.removePais(id, idPais);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	//crear el icono con el id del pais
	@PostMapping("{id}/pais/{idPais}")
	public ResponseEntity<Void> addPais(@PathVariable Long id, @PathVariable Long idPais){
	this.iconService.addPais(id, idPais);
	return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
	
	
	
	
	
}
