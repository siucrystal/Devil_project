package com.daily.serviceImpl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daily.dto.RecipeDTO;
import com.daily.dto.UserRecipeDTO;
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
		ArrayList<RecipeDTO> recipedto = recipe.getIngredient(map,pageMap);
		return recipedto;
	}

	@Override
	public int getIngredientTotalCount(Map<String, String> map) {
		int totalPage = recipe.getIngredientTotalCount(map);
		totalPage /= 10;
		if(totalPage > 1 && totalPage%10 > 0) {		
			totalPage += 1;
		}
		return totalPage;
	}
	
	@Override
	public RecipeDTO getIngredientIdx(int idx) {
		return recipe.getIngredientIdx(idx);
	}

	@Override
	public int insertIngredient(RecipeDTO dto) {
		// TODO Auto-generated method stub
		return recipe.insertIngredient(dto);
	}
	
	public ArrayList<RecipeDTO> getIngredientID(String id) {
		return recipe.getIngredientID(id);
	}
	
	public int deleteIngrdient(Map<String,String> map) {
		return recipe.deleteIngrdient(map);
	}
	
	public int updateIngrdientGram(Map<String,String> map) {
		return recipe.updateIngrdientGram(map);
	}
	
	public int userRecipeStore(ArrayList<RecipeDTO> list,Map<String,String> map) {
		return recipe.userRecipeStore(list, map);
	}
	
	public ArrayList<UserRecipeDTO> getUserRecipe(String id) {
		return recipe.getUserRecipe(id);
	}
	
	public int deleteRecipeStoreIngredient(String id) {
		return recipe.deleteRecipeStoreIngredient(id);
	}
	
	public int deleteUserRecipe(Map<String,String> map) {
		return recipe.deleteUserRecipe(map);
	}
	
	public ArrayList<RecipeDTO> getUserRecipeIngredient(Map<String,String> map) {
		return recipe.getUserRecipeIngredient(map);
	}
}
