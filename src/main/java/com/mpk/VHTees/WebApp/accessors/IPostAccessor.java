package com.mpk.VHTees.WebApp.accessors;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mpk.VHTees.WebApp.domains.Post;

public interface IPostAccessor extends JpaRepository<Post, Long> {
	
	//List<Item> findAllByPostId(Long postId);

	Post findByPostId(Long postId);

	Post findImgByPostId(Long postId);

	List<Post> findAllByTitle(String title);

	List<Post> findAllByCreatedOn(Date createdOn);

	List<Post> findAllByLastUpdated(Date lastUpdated);   

}
