package com.springboot.socialmedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.socialmedia.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
