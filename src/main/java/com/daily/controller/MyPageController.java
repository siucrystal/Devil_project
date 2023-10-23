package com.daily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage")
public class MyPageController {

	@RequestMapping("main")
	public String main() {
		
		return "mypage/main";
	}
}
