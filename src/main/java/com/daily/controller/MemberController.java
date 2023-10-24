package com.daily.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView login(MemberDTO dto,HttpSession session) {
		System.out.println(dto.toString());
		String pw = service.getMemberLogin(dto.getId());
		
		ModelAndView mav = new ModelAndView();
		if(dto.getPw().equals(service.getMemberLogin(dto.getId()))) {
			//session.setAttribute("nick",loginmap.get("name"));
			mav.setViewName("redirect: ../mypage/main");
		} else {
			mav.setViewName("member/login");
			mav.addObject("rs","fail");
		}	
		return mav;
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("register")
	public String register(MemberDTO dto,String checkpw) {
		if(dto.getPw().equals(checkpw)) {
			int rs = service.MemberRegister(dto);
			if(rs == 0) {
				return "redirect: register";
			}
			return "member/login";
		} else {
			return "redirect: register";
		}		
	}
	
	@GetMapping("forgot")
	public String forgot() {
		return "member/forgot";
	}
}
