package com.alik.demo.repo;

import com.alik.demo.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Long> {


}
