package com.dptcldpa.memo.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dptcldpa.memo.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	
	
}
