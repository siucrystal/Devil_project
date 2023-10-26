package com.daily.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daily.dto.MyFoodDTO;
import com.daily.dto.FoodDTO;
import com.daily.dto.MemberDTO;
import com.daily.dto.PageDTO;
import com.daily.service.FoodService;

@Controller
@RequestMapping("food")
public class FoodController {
	String view;

	@Autowired
	@Qualifier("foodServiceImpl")
	FoodService service;

	@GetMapping("foodlist")
	public String foodList(Model model, PageDTO dto,
			@RequestParam(value="page", required = false, defaultValue = "1" ) int page, HttpSession session) {
		session.setAttribute("id","9");


		if(dto.getCategory() == null) dto.setCategory("");
		if(dto.getName() == null) dto.setName("");

		dto.setPage(page);

		// 리스트
		List<FoodDTO> list = service.getFoodList(dto);
		// 페이지
		PageDTO pageDTO = service.getPageParam(dto);
		// 카테고리
		List<FoodDTO> category = service.getCategory();

		model.addAttribute("list",list);
		model.addAttribute("paging",pageDTO);
		model.addAttribute("category",category);
		view ="food/foodlist";
		System.out.println(dto);
		
		return view;
	}
	@PostMapping("myfood")
	public String myfood(Model model, PageDTO dto,
			@RequestParam(value="page", required = false, defaultValue = "1" ) int page, HttpSession session) {
		session.setAttribute("id","9");
		
		
		if(dto.getCategory() == null) dto.setCategory("");
		if(dto.getName() == null) dto.setName("");
		
		dto.setPage(page);
		
		// 리스트
		List<FoodDTO> list = service.getFoodList(dto);
		// 페이지
		PageDTO pageDTO = service.getPageParam(dto);
		// 카테고리
		List<FoodDTO> category = service.getCategory();
		
		model.addAttribute("list",list);
		model.addAttribute("paging",pageDTO);
		model.addAttribute("category",category);
		view ="food/foodlist";
		System.out.println(dto);
		return view;
	}
	
	@PostMapping("getData")
	@ResponseBody
	public Map<String, Object> getData(int idx){
		HttpSession session ;
		System.out.println(idx);
		System.out.println("getdata");
		
		List<FoodDTO> list = service.getFoodone(idx);
		System.out.println(list);
		Map<String,Object> map = new HashMap<String, Object>();
		if(list.size() != 0) {
			map.put("list", list);
		} else {
			map.put("data", "0");
		}
		return map;
	}
	
	
}
