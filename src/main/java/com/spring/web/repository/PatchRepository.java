package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.web.entity.Patch;

public interface PatchRepository extends JpaRepository<Patch, Long> {

}
