package com.alkemy.icons.icons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;

@Service 
public class ContinenteServiceImpl implements ContinenteService {
	
	@Autowired
	private ContinenteMapper continenteMapper;
	
	
	//llamado al repositorio para que se lo use al comunicarse a la base de datos
	@Autowired
	private ContinenteRepository continenteRepository;
	
	/* Aca queremos guardar */
	
	public ContinenteDTO save(ContinenteDTO dto) {
		ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
		/* datos guardado en forma de entidad*/
		ContinenteEntity entitySaved = continenteRepository.save(entity);
		
		ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
		return result;
		
	}

	
	public List<ContinenteDTO> getAllContinentes() {
		List<ContinenteEntity> entities = continenteRepository.findAll();
		List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
		return result;
	}

	/*
	 * public List<ContinenteEntity> findAll() { List<ContinenteEntity> continentes
	 * = continenteRepository.findAll(); for (ContinenteEntity continente :
	 * continentes) { log.info("El continente: " + continente.getName() + " " +
	 * continente.getLastName()); } return contienentes; }
	 */

}
