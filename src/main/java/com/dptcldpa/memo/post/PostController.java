package com.dptcldpa.memo.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dptcldpa.memo.post.domain.Post;
import com.dptcldpa.memo.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	// 메모 입력
	@GetMapping("/create-view")
	public String memoInput() {
		
		return "post/create";
		
	}
	
	// 메모 리스트
	@GetMapping("/list-view")
	public String memoList(
			Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> memoList = postService.getPostList(userId);
		
		model.addAttribute("memoList", memoList);
		
		return "post/list";
		
	}
	
	@GetMapping("/detail-view")
	public String memoDetail(
			@RequestParam("id") int id
			, Model model) {
		
		Post memo = postService.getPost(id);
		
		model.addAttribute("memo", memo);
		
		return "post/detail";
		
	}
	
}
