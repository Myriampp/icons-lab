package com.alkemy.icons.icons.service;

import java.util.List;
import java.util.Set;

import com.alkemy.icons.icons.dto.PaisBasicDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.PaisEntity;

public interface PaisService {
	
PaisDTO getDetailsById(Long id);
	
	List<PaisBasicDTO> getAll();
	
	List<PaisDTO> getByFilters(String name, String date, Set<Long> cities, String order);
	
	PaisDTO save(PaisDTO iconDTO);
	
	PaisDTO update(Long id, PaisDTO dto);
	
	void addIcono(Long id, Long idIcono);
	
	void removeIcono(Long id, Long idIcono);
	
	void delete(Long id);

	PaisEntity getEntityById(Long idPais);
}
