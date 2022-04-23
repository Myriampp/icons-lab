package com.alkemy.icons.icons.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.icons.dto.PaisBasicDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;


@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisMapper paisMapper;
	
	 
	//llamado al repositorio para que se lo use al comunicarse a la base de datos
	@Autowired
	private PaisRepository paisRepository;
	
	/* Aca queremos guardar */
	
	public PaisDTO save(PaisDTO dto) {
		PaisEntity entity = paisMapper.iconDTO2Entity(dto);
		/* datos guardado en forma de entidad*/
		PaisEntity entitySaved = paisRepository.save(entity);
		PaisDTO result = paisMapper.iconEntity2DTO(entitySaved);
		return result;
		
	}

	
	public List<PaisDTO> getAllPais() {
		List<PaisEntity> entities = paisRepository.findAll();
		List<PaisDTO> result = PaisMapper.iconEntityList2DTOToList(entities);
		return result;
	}


	@Override
	public PaisDTO getDetailsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PaisBasicDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PaisDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public PaisDTO update(Long id, PaisDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addIcono(Long id, Long idIcono) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeIcono(Long id, Long idIcono) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}