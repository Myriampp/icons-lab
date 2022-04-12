package com.alkemy.icons.icons.entity;

import java.time.LocalDate;

import java.util.*;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name="icon")
@Getter
@Setter

public class IconEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private Long id;
	private String imagen;
	private String denominacion;
	
	@Column(name = "Edad")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaNacimiento;
	//aca no sé si hay q hacer el calculo o poner un numero fijo como edad 
	
	private Long altura;
	
	private String historia;
	
	
	@ManyToMany(mappedBy = "icons")
	private List<PaisEntity> paises = new ArrayList<>();
	

	
}
