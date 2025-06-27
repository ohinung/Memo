package com.inong.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inong.memo.user.domain.User;
import com.inong.memo.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//API 구성을 위한 controller
@RestController
@RequestMapping("/user")
public class UserRestController {
	
	private UserService userService;
	
	public UserRestController(UserService userService){
		this.userService = userService;
	}
	
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam String loginId
			,@RequestParam String password
			,@RequestParam String name
			,@RequestParam String email){
		Map<String,String> resultMap = new HashMap<>();
		if(userService.addUser(loginId, password, name, email)) {
			resultMap.put("result", "success");
			return resultMap;
		}else {
			resultMap.put("result", "fail");
			return resultMap;
		}
		
	}
	
	@PostMapping("/login")
	public Map<String, String> login(
				@RequestParam String loginId
				,@RequestParam String password
				,HttpServletRequest request){
		User user = userService.getUser(loginId, password);
		
		//mybatis에서 객체가 조회되지 않으면 null이 리턴된다.
		// 리스트가 조회되지 아니하면 빈 리스트가 리턴된다.
		Map<String,String> resultMap = new HashMap<>();
		if(user != null) {
			
			resultMap.put("result", "success");
			//세션을 관리하는 객체
			//요청한 대상 클라이언트의 세션
			HttpSession session = request.getSession();
			
			//로그인이 되었다.
			//사용자 정보를 저장
			//세션은 모든 요청에서 접근하고 사용할 수 있다.
			//세션에 userId라는 키에 값이 저장되어 있으면 로그인 상태이다.
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
		}else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}
}
