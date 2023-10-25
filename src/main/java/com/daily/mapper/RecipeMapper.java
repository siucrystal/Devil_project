package com.daily.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.RecipeDTO;

@Mapper
public interface RecipeMapper {
	ArrayList<String> getIngredientCategory();
	ArrayList<RecipeDTO> getIngredient(Map<String, String> map,Map<String,Integer> pageMap);
	int getIngredientTotalCount(Map<String, String> map);
}
