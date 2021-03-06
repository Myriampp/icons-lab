package com.alkemy.icons.icons.mapper;
import org.hibernate.annotations.Where;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import java.util.Optional;
@Component
public class IconMapper {

	@Autowired
	private PaisMapper paisMapper;

	public IconEntity iconDTO2Entity(IconDTO dto) {
		IconEntity entity = new IconEntity();

		entity.setImagen(dto.getImagen());
		entity.setDenominacion(dto.getDenominacion());
		entity.setFechaCreacion(this.string2LocalDate(dto.getFechaCreacion()));
		entity.setAltura(dto.getAltura());
		entity.setHistoria(dto.getHistoria());
		return entity;
	}

	public IconDTO iconEntity2DTO(IconEntity entity, boolean loadPaises) {
	IconDTO dto = new IconDTO();
	dto.setId(entity.getId());
	dto.setImagen(entity.getImagen());
	 dto.setDenominacion(entity.getDenominacion());
	 dto.setFechaCreacion(entity.getFechaCreacion().toString());
	 dto.setAltura(entity.getAltura());
	 dto.setHistoria(entity.getHistoria());
	 if (loadPaises) {
		 
		 List<PaisDTO> paisesDTO = this.paisMapper.paisEntityList2DTOList(entity.getPaises(), loadIcon: FALSE);
	 dto.setPaises(paisesDTO);
	 }
	 return dto;
	}

	private LocalDate string2LocalDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}

	public void iconEntityRefreshValues(IconEntity entity, IconDTO iconDTO) {
		entity.setImagen(iconDTO.getImagen());
		entity.setDenominacion(iconDTO.getDenominacion());
		entity.setFechaCreacion(this.string2LocalDate(iconDTO.getFechaCreacion()));
		entity.setAltura(iconDTO.getAltura());
		entity.setHistoria(iconDTO.getHistoria());

	}

	public Set<IconEntity> iconDTOListEntity(List<IconDTO> dtos) {
		Set<IconEntity> entities = new HashSet<>();
		for (IconDTO dto : dtos) {
			entities.add(this.iconDTO2Entity(dto));

		}
		return entities;
	}

	public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadPaises) {
		List<IconDTO> dtos = new ArrayList<>();
		for (IconEntity entity : entities) {
			dtos.add(this.iconEntity2DTO(entity, loadPaises));
		}
		return dtos;
	}

// lista de iconos basicos
	public List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<IconEntity> entities) {
		List<IconBasicDTO> dtos = new ArrayList<>();

		IconBasicDTO basicDTO;
		for (IconEntity entity : entities) {
			basicDTO = new IconBasicDTO();
			basicDTO.setId(entity.getId());
			basicDTO.setImagen(entity.getImagen());
			basicDTO.setDenominacion(entity.getDenominacion());
			dtos.add(basicDTO);
		}
		return dtos;
	}

}
