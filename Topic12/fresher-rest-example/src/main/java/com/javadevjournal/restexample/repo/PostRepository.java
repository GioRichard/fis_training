package com.javadevjournal.restexample.repo;

import com.javadevjournal.restexample.data.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
