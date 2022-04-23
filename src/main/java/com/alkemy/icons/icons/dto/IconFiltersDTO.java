package com.alkemy.icons.icons.dto;


import java.util.*;
import lombok.*;
import java.io.*;

@Getter
@Setter
public class IconFiltersDTO {
	
	private String name;
	private String date;
	private Set<Long> cities;
	private String order;
	
	public IconFiltersDTO(String name, String date, Set<Long> cities, String order) {
	this.name= name;
	this.date= date;
	this.cities = cities;
	this.order = order;
	
	}
	
public boolean isAsc() {
	return this.order.compareToIgnoreCase(str: "ASC") ==0;
	}

public boolean isDesc() {
	return this.order.compareToIgnoreCase(str: "Desc")==0;
	}

public String getName() {
	// TODO Auto-generated method stub
	return null;
}

}
}
