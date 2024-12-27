package com.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.entityDTO.AgentDTO;

@Service
public interface AgentService {

	AgentDTO getAgent(Long id);
	
	List<AgentDTO> getAll(); 
	
	AgentDTO createAgent(AgentDTO agentDTO);
	
	void delete(Long id);
	
	AgentDTO updateAgent(Long id, AgentDTO agentDto);
	
	
}
