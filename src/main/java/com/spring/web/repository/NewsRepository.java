package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {

}
