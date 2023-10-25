package com.daily.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.daily.dto.RecipeDTO;

public interface RecipeService {
	ArrayList<String> getIngredientCategory();
	ArrayList<RecipeDTO> getIngredient(Map<String,String> map,Map<String,Integer> pageMap);
	int getIngredientTotalCount(Map<String, String> map);
}
