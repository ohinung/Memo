package com.inong.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@Controller
public class PostController {

	@GetMapping("/list-view")
	public String postList() {
		
		return"post/list";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		//세션에 저장한 사용자 정보 삭제 
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		return "redirect:/user/login-view";
	}
}
