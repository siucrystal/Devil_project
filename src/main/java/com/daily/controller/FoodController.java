package com.daily.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daily.dto.FoodDTO;
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
			@RequestParam(value="page", required = false, defaultValue = "1" ) int page) {
			if(dto.getCategory() == null) dto.setCategory("");
			if(dto.getName() == null) dto.setName("");
			
			dto.setPage(page);
			
			System.out.println("foodlist");
			System.out.println("초기"+dto);
			// 리스트
			List<FoodDTO> list = service.getFoodList(dto);
			// 페이지
			PageDTO pageDTO = service.getPageParam(dto);
			
			List<FoodDTO> category = service.getCategory();
			
			System.out.println(pageDTO);
			
			model.addAttribute("list",list);
			model.addAttribute("paging",pageDTO);
			model.addAttribute("category",category);
			view ="food/foodlist";
		System.out.println(dto);
		return view;
	}
}
