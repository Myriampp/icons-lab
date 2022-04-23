package com.alkemy.icons.icons.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;


public interface IconService {

	IconDTO getDetailsById(Long id);
	
	List<IconBasicDTO> getAll();
	
	List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);
	
	IconDTO save(IconDTO iconDTO);
	
	IconDTO update(Long id, IconDTO dto);
	
	void addPais(Long id, Long idPais);
	
	void removePais(Long id, Long idPais);
	
	void delete(Long id);
	
}
