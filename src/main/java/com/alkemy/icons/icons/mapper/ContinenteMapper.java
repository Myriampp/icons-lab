package com.alkemy.icons.icons.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.ContinenteEntity;


@Component
public class ContinenteMapper {

	//metodo para parsear una DTO en entidad 
	public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
		ContinenteEntity continenteEntity = new ContinenteEntity();
		
		continenteEntity.setImagen(dto.getImagen());
		continenteEntity.setDenominacion(dto.getDenominacion());
		return continenteEntity;
	}
	
	//trasforma entidad a DTO
	public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity) {
		ContinenteDTO dto = new ContinenteDTO();
		
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		return dto;
	}
	
	
	//transforma una lista	
	
	public List<ContinenteDTO> continenteEntityList2DTOList(List<ContinenteEntity> entities){
	List<ContinenteDTO> dtos = new ArrayList<>();
	// con este for recorre los datos q llegan y los parsea a dto
	for (ContinenteEntity entity : entities) {
		dtos.add(this.continenteEntity2DTO(entity));
	}
	return dtos;
	
}
	}
	