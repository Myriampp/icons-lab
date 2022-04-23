package com.alkemy.icons.icons.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContinenteDTO {
	
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
public void setDenominacion(String denominacion) {
	this.denominacion = denominacion;
}
public ContinenteDTO(Long id, String imagen, String denominacion) {
	super();
	this.id = id;
	this.imagen = imagen;
	this.denominacion = denominacion;
}
public ContinenteDTO() {
	// TODO Auto-generated constructor stub
}



}
  
  
  

