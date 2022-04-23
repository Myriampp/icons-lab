package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IconBasicDTO {

	private Long id;
	private String imagen;
	private String denominacion;
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
	public void setDenominacion(String denominancion) {
		this.denominacion = denominancion;
	}
	


	
}
