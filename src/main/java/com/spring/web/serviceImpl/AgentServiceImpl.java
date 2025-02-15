package com.spring.web.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.spring.web.entity.Agent;
import com.spring.web.entityDTO.AgentDTO;
import com.spring.web.exception.AgentNotFound;
import com.spring.web.mapper.AgentMapper;
import com.spring.web.repository.AgentRepository;
import com.spring.web.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	private final AgentRepository repository;
	
	@Override
	public AgentDTO getAgent(Long id) {
		Agent agent = repository.findById(id).orElseThrow(() -> new AgentNotFound("Not found"));
		
		return AgentMapper.toDTO(agent);
	}

	public AgentServiceImpl(AgentRepository repository) {

		this.repository = repository;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AgentDTO> getAll() {

		List<Agent> agents = repository.findAll();
		for(Agent agent : agents) {
		}

		// TODO Auto-generated method stub
		return agents.stream().map(
			
			(agent) -> AgentMapper.toDTO(agent)

		).collect(Collectors.toList());
	}
	
	@Override
	public AgentDTO createAgent(AgentDTO agentDTO) {
		// TODO Auto-generated method stub
		Agent agent = AgentMapper.toAgent(agentDTO);
		
		Agent saved = repository.save(agent);
		
		return AgentMapper.toDTO(saved);
	}
	
	@Override
	public void delete(Long id) {

		Agent agent = repository.findById(id).orElseThrow(() -> new AgentNotFound("Not found"));
		repository.delete(agent);
	}
	
	
	@Override
	public AgentDTO updateAgent(Long id, AgentDTO agentDTO) {
		Agent agent = repository.findById(id).orElseThrow(
				() -> new AgentNotFound("Not found content by id: " + id)
				);
		
		agent.setName(agentDTO.getName());
		agent.setInfo(agentDTO.getInfo());
		agent.setDescSkill(agentDTO.getDescSkill());
		agent.setTitleSkill(agentDTO.getTitleSkill());
		agent.setPictureLitle(agentDTO.getPictureLitle());
		agent.setPictureFull(agentDTO.getPictureFull());
		
	
	
		Agent savedAgent = repository.save(agent);
		
		
		
		return AgentMapper.toDTO(savedAgent);
	}
}
