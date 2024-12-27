package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.Weapon;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

}
