package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.entityDTO.PatchDTO;

@Service
public interface PatchService {

	PatchDTO getModel(Long id);
	
	List<PatchDTO> getAll(); 
	
	PatchDTO createModel(PatchDTO modelDTO);
	
	void delete(Long id);
	
	PatchDTO updateModel(Long id, PatchDTO modelDTO);
	
	
}
