package com.spring.web.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.spring.web.entity.Map;
import com.spring.web.entityDTO.MapDTO;
import com.spring.web.exception.MapNotFound;
import com.spring.web.mapper.MapMapper;
import com.spring.web.repository.MapRepository;
import com.spring.web.service.MapService;

@Service
public class MapServiceImpl implements MapService {
	

	private final MapRepository repository;
	
	public MapServiceImpl(MapRepository repository) {
		
		this.repository = repository;
	
}

	
	@Override
	public MapDTO getModel(Long id) {
		Map model = repository.findById(id).orElseThrow(() -> new MapNotFound("Not found"));
		
		
		return MapMapper.model_to_DTO(model);
	}


	@Override
	public List<MapDTO> getAll() {

		List<Map> models = repository.findAll();
		

		// TODO Auto-generated method stub
		return models.stream().map(
			
			(model) -> MapMapper.model_to_DTO(model)

		).collect(Collectors.toList());
	}
	
	@Override
	public MapDTO createModel(MapDTO modelDTO) {
		// TODO Auto-generated method stub
		Map model = MapMapper.DTO_to_model(modelDTO);
		model.setDate(LocalDate.now());
		
		Map saved = repository.save(model);
		
		return MapMapper.model_to_DTO(saved);
	}
	
	@Override
	public void delete(Long id) {

		Map model = repository.findById(id).orElseThrow(() -> new MapNotFound("Not found"));
		repository.delete(model);
	}
	
	
	@Override
	public MapDTO updateModel(Long id, MapDTO modelDTO) {
		Map model = repository.findById(id).orElseThrow(
				() -> new MapNotFound("Not found content by id: " + id)
				);
		
		model.setTitle(modelDTO.getTitle());
		model.setContent(modelDTO.getContent());
		model.setPicture(modelDTO.getPicture());
		
	
	
		Map saved = repository.save(model);
		
		
		
		return MapMapper.model_to_DTO(saved);
	}
}
