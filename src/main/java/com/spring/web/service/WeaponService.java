package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.entityDTO.WeaponDTO;

@Service
public interface WeaponService {

	WeaponDTO getModel(Long id);
	
	List<WeaponDTO> getAll(); 
	
	WeaponDTO createModel(WeaponDTO modelDTO);
	
	void delete(Long id);
	
	WeaponDTO updateModel(Long id, WeaponDTO modelDTO);
	
	
}
