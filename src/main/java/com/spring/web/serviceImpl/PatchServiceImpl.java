package com.spring.web.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.spring.web.entity.Patch;
import com.spring.web.entityDTO.PatchDTO;
import com.spring.web.exception.NewsNotFound;
import com.spring.web.exception.PatchNotFound;
import com.spring.web.mapper.PatchMapper;
import com.spring.web.repository.PatchRepository;
import com.spring.web.service.PatchService;

@Service
public class PatchServiceImpl implements PatchService {
	

	private final PatchRepository repository;
	
	public PatchServiceImpl(PatchRepository repository) {
		
		this.repository = repository;
	
}

	
	@Override
	public PatchDTO getModel(Long id) {
		Patch model = repository.findById(id).orElseThrow(() -> new PatchNotFound("Not found"));
		
		
		return PatchMapper.model_to_DTO(model);
	}


	@Override
	public List<PatchDTO> getAll() {

		List<Patch> models = repository.findAll();
		

		// TODO Auto-generated method stub
		return models.stream().map(
			
			(model) -> PatchMapper.model_to_DTO(model)

		).collect(Collectors.toList());
	}
	
	@Override
	public PatchDTO createModel(PatchDTO modelDTO) {
		// TODO Auto-generated method stub
		Patch model = PatchMapper.DTO_to_model(modelDTO);
		model.setDate(LocalDate.now());
		
		Patch saved = repository.save(model);
		
		return PatchMapper.model_to_DTO(saved);
	}
	
	@Override
	public void delete(Long id) {

		Patch model = repository.findById(id).orElseThrow(() -> new PatchNotFound("Not found"));
		repository.delete(model);
	}
	
	
	@Override
	public PatchDTO updateModel(Long id, PatchDTO modelDTO) {
		Patch model = repository.findById(id).orElseThrow(
				() -> new NewsNotFound("Not found content by id: " + id)
				);
		
		model.setTitle(modelDTO.getTitle());
		model.setContent(modelDTO.getContent());
		model.setPicture(modelDTO.getPicture());
		
	
	
		Patch saved = repository.save(model);
		
		
		
		return PatchMapper.model_to_DTO(saved);
	}
}
