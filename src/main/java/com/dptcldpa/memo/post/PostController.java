package com.dptcldpa.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

	// 메모 입력
	@GetMapping("/create-view")
	public String memoList() {
		
		return "post/create";
		
	}
	

	
}
