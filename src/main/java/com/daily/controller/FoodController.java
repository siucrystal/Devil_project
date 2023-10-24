package com.daily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daily.dto.FoodDTO;
import com.daily.service.FoodService;

@Controller
@RequestMapping("food")
public class FoodController {
	String view;
	
	@Autowired
	@Qualifier("foodServiceImpl")
	FoodService service;
	
	@GetMapping("foodlist")
	public String foodList(Model model) {
		System.out.println("foodlist");
		List<FoodDTO> list = service.getFoodList();
		model.addAttribute("list",list);
		view ="food/foodlist";
		return view;
	}
	@PostMapping("foodlist")
	public ModelAndView foodList(FoodDTO dto) {
		System.out.println("foodlist-dto");
		List<FoodDTO> list = service.getFoodListSearch(dto);
		ModelAndView mav = new ModelAndView();
		view ="food/foodlist";
		mav.addObject("list",list);
		mav.setViewName(view);
		return mav;
	}
}
