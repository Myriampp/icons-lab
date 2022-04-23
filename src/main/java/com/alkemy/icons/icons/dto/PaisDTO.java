package com.alkemy.icons.icons.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaisDTO {

	private Long id;
	private String imagen;
	private String denominacion;
	private Long cantidadHabitantes;
	private Long superfie;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public Long getCantidadHabitantes() {
		return cantidadHabitantes;
	}
	public void setCantidadHabitantes(Long cantidadHabitantes) {
		this.cantidadHabitantes = cantidadHabitantes;
	}
	public Long getSuperfie() {
		return superfie;
	}
	public void setSuperfie(Long superfie) {
		this.superfie = superfie;
	}
	public PaisDTO(Long id, String imagen, String denominacion, Long cantidadHabitantes, Long superfie) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.denominacion = denominacion;
		this.cantidadHabitantes = cantidadHabitantes;
		this.superfie = superfie;
	}
	public PaisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setIcons(List<IconDTO> iconDTOS) {
		// TODO Auto-generated method stub
		
	}
	

}
