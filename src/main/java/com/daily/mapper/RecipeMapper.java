package com.daily.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.daily.dto.RecipeDTO;
import com.daily.dto.UserRecipeDTO;

@Mapper
public interface RecipeMapper {
	ArrayList<String> getIngredientCategory();
	ArrayList<RecipeDTO> getIngredient(Map<String, String> map,Map<String,Integer> pageMap);
	int getIngredientTotalCount(Map<String, String> map);
	RecipeDTO getIngredientIdx(int idx);
	int insertIngredient(RecipeDTO dto);
	ArrayList<RecipeDTO> getIngredientID(String id);
	int deleteIngrdient(Map<String,String> map);
	int updateIngrdientGram(Map<String,String> map);
	int userRecipeStore(@Param("list") ArrayList<RecipeDTO> list,@Param("additionalData") Map<String,String> map);
	ArrayList<UserRecipeDTO> getUserRecipe(String id);
	int deleteRecipeStoreIngredient(String id);
	int deleteUserRecipe(Map<String,String> map);
	ArrayList<RecipeDTO> getUserRecipeIngredient(Map<String,String> map);
}
