package com.daily.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daily.dto.RecipeDTO;
import com.daily.service.RecipeService;

@Controller
@RequestMapping("recipe")
public class RecipeController {
	private int currentPage = 1;
	private int viewNum = 0;
		
	@Autowired
	@Qualifier("recipeServiceImpl")
	RecipeService service;

	
	@RequestMapping("main")
	public String main(Model model,@RequestParam Map<String,String> map,Integer pageNum) {
		if(map.get("category") == null) {
			System.out.println("ddd");
			map.put("category", "");
		}
		if(map.get("ingredient") == null) {
			map.put("ingredient", "");
		}
		if(pageNum == null) {
			pageNum = 1;
		}
		System.out.println(map.get("category")+"dfasdfsd");
		
		Map<String,Integer> pageMap = new HashMap();
		viewNum = (pageNum-1) * 10;
		pageMap.put("viewnum", viewNum);
		
		ArrayList<String> ingredient_category = service.getIngredientCategory();
		ArrayList<RecipeDTO> ingredient_list = service.getIngredient(map,pageMap);
		int totalpage = service.getIngredientTotalCount(map);
		System.out.println(totalpage);
		
		model.addAttribute("pageNum",totalpage);
		model.addAttribute("category",map.get("category"));
		model.addAttribute("ingredient",map.get("ingredient"));
		model.addAttribute("ingredient_category",ingredient_category);
		model.addAttribute("ingredient_list",ingredient_list);
		
		return "recipe/myrecipe";
	}
}
