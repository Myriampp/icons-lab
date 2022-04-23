package com.alkemy.icons.icons.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.dto.PaisBasicDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.entity.PaisEntity;
@Component
public class PaisMapper {
	
	@Autowired
	private IconMapper iconMapper;
	
	
	
	public PaisEntity PaisDTO2Entity(PaisDTO dto) {
		PaisEntity paisEntity = new PaisEntity();
		
		paisEntity.setImagen(dto.getImagen());
		paisEntity.setDenominacion(dto.getDenominacion());
		paisEntity.setCantidadHabitantes(dto.getCantidadHabitantes());
		paisEntity.setSuperfie(dto.getSuperfie());
		return paisEntity;
	}
		
	private PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
		PaisDTO dto = new PaisDTO();
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		dto.setCantidadHabitantes(entity.getCantidadHabitantes());
		dto.setSuperfie(entity.getSuperfie());
		if(loadIcons) {
			List<IconDTO> iconDTOS =  this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), loadIcons: false);
			dto.setIcons(iconDTOS);
		}		
		return dto;
	}

	//47
		public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
			List<PaisDTO> dtos = new ArrayList<>();
			for (PaisEntity entity : entities) {
				dtos.add(this.paisEntity2DTO(entity, loadIcons));
				
			}
		return dtos;
		}
		//56
		public List<PaisEntity> paisDTOList2Entity(List<PaisDTO> dtos) {
			List<PaisEntity> entities = new ArrayList<>();
			for (PaisDTO dto : dtos) {
				entities.add(this.PaisDTO2Entity(dto));
				
			}
			return entities;
		}
		

	public List<PaisBasicDTO> paisEntitySet2BasicDTOList(Collection<PaisEntity> entities) {
		List<PaisBasicDTO> dtos = new ArrayList<>();

		PaisBasicDTO basicDTO;
		for (PaisEntity entity : entities) {
			basicDTO = new PaisBasicDTO();
			basicDTO.setId(entity.getId());
			basicDTO.setImagen(entity.getImagen());
			basicDTO.setDenominacion(entity.getDenominacion());
			dtos.add(basicDTO);
		}
		return dtos;
	}
	

	

}
