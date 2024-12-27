package com.spring.web.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.spring.web.entity.Weapon;
import com.spring.web.entityDTO.WeaponDTO;
import com.spring.web.exception.WeaponNotFound;
import com.spring.web.mapper.WeaponMapper;
import com.spring.web.repository.WeaponRepository;
import com.spring.web.service.WeaponService;

@Service
public class WeaponServiceImpl implements WeaponService {
	

	private final WeaponRepository repository;
	
	public WeaponServiceImpl(WeaponRepository repository) {
		
		this.repository = repository;
	
}

	
	@Override
	public WeaponDTO getModel(Long id) {
		Weapon model = repository.findById(id).orElseThrow(() -> new WeaponNotFound("Not found"));
		
		
		return WeaponMapper.model_to_DTO(model);
	}


	@Override
	public List<WeaponDTO> getAll() {

		List<Weapon> models = repository.findAll();
		

		// TODO Auto-generated method stub
		return models.stream().map(
			
			(model) -> WeaponMapper.model_to_DTO(model)

		).collect(Collectors.toList());
	}
	
	@Override
	public WeaponDTO createModel(WeaponDTO modelDTO) {
		// TODO Auto-generated method stub
		Weapon model = WeaponMapper.DTO_to_model(modelDTO);
		
		
		Weapon saved = repository.save(model);
		
		return WeaponMapper.model_to_DTO(saved);
	}
	
	@Override
	public void delete(Long id) {

		Weapon model = repository.findById(id).orElseThrow(() -> new WeaponNotFound("Not found"));
		repository.delete(model);
	}
	
	
	@Override
	public WeaponDTO updateModel(Long id, WeaponDTO modelDTO) {
		Weapon model = repository.findById(id).orElseThrow(
				() -> new WeaponNotFound("Not found content by id: " + id)
				);
		
		model.setTitle(modelDTO.getTitle());
		model.setContent(modelDTO.getContent());
		model.setPicture(modelDTO.getPicture());
		
	
	
		Weapon saved = repository.save(model);
		
		
		
		return WeaponMapper.model_to_DTO(saved);
	}
}
