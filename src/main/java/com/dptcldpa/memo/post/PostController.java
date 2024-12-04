package com.dptcldpa.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

	// 메모 입력
	@GetMapping("/create-view")
	public String memoInput() {
		
		return "post/create";
		
	}
	
	// 메모 리스트
	@GetMapping("/list-view")
	public String 
	
}
