package com.spring.web.mapper;


import com.spring.web.entity.Weapon;
import com.spring.web.entityDTO.WeaponDTO;


public class WeaponMapper {
	
	public static Weapon DTO_to_model(WeaponDTO dto) {
		
		return Weapon.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.content(dto.getContent())
					
					.picture(dto.getPicture())
				.build();
	}
	
	
	public static WeaponDTO model_to_DTO(Weapon model) {
		
		return WeaponDTO.builder()
				.id(model.getId())
				.title(model.getTitle())
				.content(model.getContent())
				
				.picture(model.getPicture())
				.build();
	}

}
