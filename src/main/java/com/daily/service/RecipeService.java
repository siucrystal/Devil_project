package com.daily.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.daily.dto.RecipeDTO;
import com.daily.dto.UserRecipeDTO;

public interface RecipeService {
	ArrayList<String> getIngredientCategory();
	ArrayList<RecipeDTO> getIngredient(Map<String,String> map,Map<String,Integer> pageMap);
	int getIngredientTotalCount(Map<String, String> map);
	RecipeDTO getIngredientIdx(int idx);
	int insertIngredient(RecipeDTO dto);
	ArrayList<RecipeDTO> getIngredientID(String id);
	int deleteIngrdient(Map<String,String> map);
	int updateIngrdientGram(Map<String,String> map);
	int userRecipeStore(ArrayList<RecipeDTO> list,Map<String,String> map);
	ArrayList<UserRecipeDTO> getUserRecipe(String id);
	int deleteRecipeStoreIngredient(String id);	
	int deleteUserRecipe(Map<String,String> map);
	ArrayList<RecipeDTO> getUserRecipeIngredient(Map<String,String> map);
	int deleteUserIngrdient(Map<String,String> map);
}
