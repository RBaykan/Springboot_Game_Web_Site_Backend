package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

}
