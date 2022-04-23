package com.alkemy.icons.icons.entity;

import java.util.*;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pais")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class PaisEntity {
	@Id
	@Column
@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String denominacion;
@Column(name= " cant_habitantes")
private Long cantidadHabitantes;
private Long superfie; //m2


/* para ir a buscar información trae al objeto de tipo continente */

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "continente_id", insertable = false, updatable = false)
private ContinenteEntity continente;


/*
 * //para guardar información del país y actualizar
 */
@Column(name = "continente_id", nullable = false)
private Long continenteId;




@ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
})
@JoinTable(
		name = "icon_pais",
		joinColumns = {@JoinColumn(name = "pais_id")},
		inverseJoinColumns = {@JoinColumn(name="icon_id")}
		)
private Set<IconEntity> icons = new HashSet<>();

public boolean equals(Object obj) {
	if(obj == null)
		return false;
	if(getClass() != obj.getClass())
		return false;
	final PaisEntity other = (PaisEntity) obj;
	return other.id == this.id;
	

	
	
	
	
	
}

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

public ContinenteEntity getContinente() {
	return continente;
}

public void setContinente(ContinenteEntity continente) {
	this.continente = continente;
}

public Long getContinenteId() {
	return continenteId;
}

public void setContinenteId(Long continenteId) {
	this.continenteId = continenteId;
}

public Set<IconEntity> getIcons() {
	return icons;
}

public void setIcons(Set<IconEntity> icons) {
	this.icons = icons;
}

	




}
