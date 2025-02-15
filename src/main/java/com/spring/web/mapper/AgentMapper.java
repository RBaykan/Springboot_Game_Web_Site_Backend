package com.spring.web.mapper;

import com.spring.web.entity.Agent;
import com.spring.web.entityDTO.AgentDTO;


public class AgentMapper {

	public static Agent toAgent(AgentDTO dto) {
		
		
		return Agent.builder()
				.id(dto.getId())
				.name(dto.getName())
				.info(dto.getInfo())
				.descSkill(dto.getDescSkill())
				.titleSkill(dto.getTitleSkill())
				.pictureLitle(dto.getPictureLitle())
				.pictureFull(dto.getPictureFull())
				.build();
		
	}
	
	public static AgentDTO toDTO(Agent a) {
		
		return AgentDTO.builder()
				.id(a.getId())
				.name(a.getName())
				.info(a.getInfo())
				.descSkill(a.getDescSkill())
				.titleSkill(a.getTitleSkill())
				.pictureLitle(a.getPictureLitle())
				.pictureFull(a.getPictureFull())
				.build();
	}
}
