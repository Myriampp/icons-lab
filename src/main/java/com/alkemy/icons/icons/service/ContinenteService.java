package com.alkemy.icons.icons.service;

import java.util.List;

import com.alkemy.icons.icons.dto.ContinenteDTO;

public interface ContinenteService {
	//metodo
ContinenteDTO save(ContinenteDTO dto);


List<ContinenteDTO> getAllContinentes();
}
