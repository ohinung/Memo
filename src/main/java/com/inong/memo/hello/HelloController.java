package com.inong.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "hello World";
	}
	
	@GetMapping("/hellothymeleaf")
	public String hellothymeleaf() {
		return "hello/hello"; 
	}

}
