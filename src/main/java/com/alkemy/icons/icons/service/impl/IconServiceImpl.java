package com.alkemy.icons.icons.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.CrudRepository;
import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.IconFiltersDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.repository.specifications.IconSpecification;
import com.alkemy.icons.icons.service.IconService;
import com.alkemy.icons.icons.service.PaisService;

@Service
public class IconServiceImpl implements IconService{
		 
	//llamado al repositorio para que se lo use al comunicarse a la base de datos
	//repo
	private IconRepository iconRepository;
	private IconSpecification iconSpecification;
	// MApper
	private IconMapper iconMapper;
	//services
	private PaisService paisService;
	//construcctor
	@Autowired
	public IconServiceImpl(
			IconRepository iconrepository,
			IconSpecification iconSpecification,
			PaisService paisService,
			IconMapper iconMapper
			) {
		this.iconRepository = iconrepository;
		this.iconSpecification = iconSpecification;
		this.iconMapper = iconMapper;
		this.paisService = paisService;
		
	}
	
	
	/*
	 * public List<IconDTO> getAllIcon() { List<IconEntity> entities =
	 * iconRepository.findAll(); List<IconDTO> result =
	 * IconMapper.iconEntityList2DTOList(entities); return result; }
	 */


	@Override
	public IconDTO getDetailsById(Long id) {
		Optional<IconEntity> entity = this.iconRepository.findById(id);
		if (!entity.isPresent()) {}
		throw new ParamNotFound( error: "Id icono no valido");
		IconDTO iconDTO = this.iconMapper.iconEntity2DTO(entity.get(), loadPaises: true);
		return iconDTO;
	}


	@Override
	public List<IconBasicDTO> getAll() {
		List<IconEntity> entities = this.iconRepository.findAll();
		List<IconBasicDTO> iconBasicDTOS = this.iconMapper.iconEntitySet2BasicDTOList(entities);
		return iconBasicDTOS;
	}


	@Override
	public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
		IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
		List<IconDTO> entities = this.iconRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
		List<IconDTO> dtos = this.iconMapper.iconEntitySet2BasicDTOList(entities, loadPaises: true);
	return dtos;
	}
	
	 //Aca queremos guardar 
	
		public IconDTO save(IconDTO iconDTO) {
			IconEntity entity = iconMapper.iconDTO2Entity(iconDTO);
			
			IconEntity entitySaved = iconRepository.save(entity);
			IconDTO result = iconMapper.iconEntity2DTO(entitySaved, loadPaises:false);
			return result;
			
		}


	@Override
	public IconDTO update(Long id, IconDTO iconDTO) {
		Optional<IconEntity> entity = this.iconRepository.findById(id);
		if (!entity.isPresent()) {
			throw new ParamNotFound(error: "Id Icono no valido");
			}
		this.iconMapper.iconEntityRefreshValues(entity.get(), iconDTO);
		IconEntity entitySaved = this.iconRepository.save(entity.get());
		IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, loadPaises: false);
		
		return result;
	}


	@Override
	public void addPais(Long id, Long idPais) {
		IconEntity entity = this.iconRepository.getById(idPais);
		entity.getPaises().size();
		PaisEntity paisEntity = this.paisService.getEntityById(idPais);
		entity.addPais(paisEntity);
		this.iconRepository.save(entity);
		
	}


	@Override
	public void removePais(Long id, Long idPais) {
	IconEntity entity = this.iconRepository.getById(id);
	entity.getPaises().size();
	PaisEntity paisEntity = this.paisService.getEntityById(idPais);
	entity.remove(paisEntity);
	this.iconRepository.save(entity);
	}


	@Override
	public void delete(Long id) {
	this.iconRepository.deleteById(id);
		
	}
}