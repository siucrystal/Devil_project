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
		MemberDTO getdto = service.getMemberLogin(dto.getId());
		
		ModelAndView mav = new ModelAndView();
		if(getdto != null && dto.getPw().equals(getdto.getPw())) {
			session.setAttribute("id",getdto.getId());
			session.setAttribute("name",getdto.getName());
			mav.setViewName("redirect: ../mypage/main");
		} else {
			mav.setViewName("member/login");
			mav.addObject("rs",0);
		}	
		return mav;
	}
	
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("register")
	public ModelAndView register(MemberDTO dto,String checkpw) {
		int rs = service.MemberRegister(dto);
		
		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("member/login");
			return mav;
		} else {
			mav.setViewName("member/register");
			mav.addObject("rs",rs);
			mav.addObject("pw",dto.getPw());
			mav.addObject("checkpw",checkpw);
			mav.addObject("name",dto.getName());
			mav.addObject("age", dto.getAge());
			mav.addObject("sex", dto.getSex());
			return mav;
		}
		

	}
	
	@GetMapping("forgot")
	public String forgot() {
		return "member/forgot";
	}
	
	@PostMapping("forgot")
	public ModelAndView forgot(MemberDTO dto) {
		int rs = service.updateMemberPassword(dto);
		ModelAndView mav = new ModelAndView();
		if(rs == 1) {
			mav.setViewName("redirect: login");
			return mav;
		} else {
			mav.setViewName("member/forgot");
			mav.addObject("rs",rs);
			return mav;
		}
		
	}
}
