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
	private int startPage = 1;
	private int endPage = 10;
	@Autowired
	@Qualifier("recipeServiceImpl")
	RecipeService service;

	
	@RequestMapping("main")
	public String main(Model model,@RequestParam Map<String,String> map,Integer pageNum) {
		if(map.get("category") == null) {
			map.put("category", "");
		}
		if(map.get("ingredient") == null) {
			map.put("ingredient", "");
		}
		if(pageNum == null) {
			pageNum = 1;
		}
		
		currentPage = pageNum;
		
		Map<String,Integer> pageMap = new HashMap();
		viewNum = (pageNum-1) * 10;
		pageMap.put("viewnum", viewNum);
		
		ArrayList<String> ingredient_category = service.getIngredientCategory();
		ArrayList<RecipeDTO> ingredient_list = service.getIngredient(map,pageMap);
		int totalpage = service.getIngredientTotalCount(map);
		
		if(endPage <= 10 && totalpage < 10) {
			endPage = totalpage;
		} else if(endPage < 10 && totalpage > 10) {
			endPage = 10;
			startPage = 1;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}
		if(totalpage != 0 && currentPage > totalpage) {
			currentPage = totalpage;
		}
				
		if(currentPage > endPage) {
			startPage += 10;
			endPage += 10;
			if(endPage > totalpage) {
				endPage = totalpage;
			}
		}

		if(currentPage < startPage) {
			startPage -= 10;
			endPage -= 10;
			if(startPage < 1) {
				startPage = 1;
			}
		}
		
		if(totalpage == 0) {
			currentPage = 1;
			startPage = 1;
			endPage = 1;
		}
		
		model.addAttribute("start",startPage);
		model.addAttribute("end",endPage);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("pageNum",totalpage);
		model.addAttribute("category",map.get("category"));
		model.addAttribute("ingredient",map.get("ingredient"));
		model.addAttribute("ingredient_category",ingredient_category);
		model.addAttribute("ingredient_list",ingredient_list);
		
		return "recipe/myrecipe";
	}
}
