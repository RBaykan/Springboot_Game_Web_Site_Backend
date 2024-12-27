package com.spring.web.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.spring.web.entity.News;
import com.spring.web.entityDTO.NewsDTO;
import com.spring.web.exception.NewsNotFound;
import com.spring.web.mapper.NewsMapper;
import com.spring.web.repository.NewsRepository;
import com.spring.web.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	private final NewsRepository repository;
	
	@Override
	public NewsDTO getNews(Long id) {
		News news = repository.findById(id).orElseThrow(() -> new NewsNotFound("Not found"));
		
		
		
		return NewsMapper.model_to_DTO(news);
	}

	public NewsServiceImpl(NewsRepository repository) {
		
			this.repository = repository;
		
	}

	@Override
	public List<NewsDTO> getAll() {

		List<News> news = repository.findAll();
		

		// TODO Auto-generated method stub
		return news.stream().map(
			
			(n) -> NewsMapper.model_to_DTO(n)

		).collect(Collectors.toList());
	}
	
	@Override
	public NewsDTO createNews(NewsDTO newsDTO) {
		// TODO Auto-generated method stub
		News news = NewsMapper.DTO_to_model(newsDTO);
		news.setDate(LocalDate.now());
		
		News saved = repository.save(news);
		
		return NewsMapper.model_to_DTO(saved);
	}
	
	@Override
	public void delete(Long id) {

		News news = repository.findById(id).orElseThrow(() -> new NewsNotFound("Not found"));
		repository.delete(news);
	}
	
	
	@Override
	public NewsDTO updateNews(Long id, NewsDTO newsDTO) {
		News news = repository.findById(id).orElseThrow(
				() -> new NewsNotFound("Not found content by id: " + id)
				);
		
		news.setTitle(newsDTO.getTitle());
		news.setContent(newsDTO.getContent());
		news.setPicture(newsDTO.getPicture());
		
	
	
		News saved = repository.save(news);
		
		
		
		return NewsMapper.model_to_DTO(saved);
	}
}
