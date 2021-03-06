package com.thesupramarket.backend.accessors;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.thesupramarket.backend.domains.News;

public interface INewsAccessor extends JpaRepository<News, Long> {
	
	//List<Item> findAllByNewsId(Long newsId);

	News findByNewsId(Long newsId);

	News findImgByNewsId(Long newsId);

	List<News> findAllByTitle(String title);

	List<News> findAllByCreatedOn(Date createdOn);

	List<News> findAllByLastUpdated(Date lastUpdated);   

}
