package com.daily.serviceImpl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.RecipeDTO;
import com.daily.mapper.RecipeMapper;
import com.daily.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeMapper recipe;
	
	@Override
	public ArrayList<String> getIngredientCategory() {
		ArrayList<String> category = recipe.getIngredientCategory(); 
		return category;
	}
	
	@Override
	public ArrayList<RecipeDTO> getIngredient(Map<String,String> map,Map<String,Integer> pageMap) {
		System.out.println("서비스!!!");
		System.out.println(map.get("category"));
		System.out.println(map.get("ingredient"));
		ArrayList<RecipeDTO> recipedto = recipe.getIngredient(map,pageMap);
		return recipedto;
	}

	@Override
	public int getIngredientTotalCount(Map<String, String> map) {
		int TotalPage = recipe.getIngredientTotalCount(map) / 10;
		System.out.println("전체페이지 : " + TotalPage);
		return TotalPage;
	}
	
}
