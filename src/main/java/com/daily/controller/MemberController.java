package com.daily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daily.dto.MemberDTO;
import com.daily.service.MemberService;



@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@RequestMapping("main")
	public String main() {
		return "member/login";
	}
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(MemberDTO dto) {
		System.out.println(dto.toString());
		String pw = service.getMemberLogin(dto.getId());
		if(dto.getPw().equals(service.getMemberLogin(dto.getId()))) {
			return "redirect: ../mypage/main";
		} else {
			return "redirect: login";
		}				
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("register")
	public String register(MemberDTO dto,String checkpw) {
		if(dto.getPw().equals(checkpw)) {
			service.MemberRegister(dto);
			return "member/login";
		} else {
			return "redirect: register";
		}
		
		
		
		
	}
}
