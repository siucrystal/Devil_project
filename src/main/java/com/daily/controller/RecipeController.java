package com.daily.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daily.dto.RecipeDTO;
import com.daily.dto.UserRecipeDTO;
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
	
	
	@PostMapping("getData")
	@ResponseBody
	public Map<String,ArrayList<RecipeDTO>> insertData(HttpSession session) {
		String id = (String)session.getAttribute("id");
	
		ArrayList<RecipeDTO> keeplist = service.getIngredientID(id);
		Map<String,ArrayList<RecipeDTO>> keepData = new HashMap<String, ArrayList<RecipeDTO>>();
		keepData.put("keep", keeplist);
		return keepData;
	}
	
	
	
	@PostMapping("insertData")
	@ResponseBody
	public int getData(int idx,HttpSession session) {
		String id = (String)session.getAttribute("id");
		int rs = 0;
		if(idx > 0) {
			RecipeDTO dto = service.getIngredientIdx(idx);
			dto.setId(id);
			rs = service.insertIngredient(dto);
		}
				
		return rs;
	}

	@PostMapping("deleteData")
	@ResponseBody
	public int deleteData(int idx,String name,HttpSession session) {
		String id = (String)session.getAttribute("id");
				
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("idx", idx + "");
		map.put("recipe_name", name);
		
		int rs = service.deleteIngrdient(map);
		if(rs == 1 && name != null) {
			service.deleteUserIngrdient(map);
		}
				
		return rs;
	}
	
	@PostMapping("updateGram")
	@ResponseBody
	public int updateGram(int idx,double gram,HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("idx", idx + "");
		map.put("gram", gram + "");
		
		int rs = service.updateIngrdientGram(map);
				
		return rs;
	}
	
	@PostMapping("recipeStore")
	@ResponseBody
	public int recipeStore(String name,HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		ArrayList<RecipeDTO> keeplist = service.getIngredientID(id);

		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		service.userRecipeStore(keeplist, map);
		int rs = service.deleteRecipeStoreIngredient(id);
		
		return rs;
	}
	
	@PostMapping("getUserRecipe")
	@ResponseBody
	public Map<String,ArrayList<UserRecipeDTO>> getUserRecipe(HttpSession session) {
		String id = (String)session.getAttribute("id");
		
		ArrayList<UserRecipeDTO> userRecipeList = service.getUserRecipe(id);
		Map<String,ArrayList<UserRecipeDTO>> userRecipeData = new HashMap<String, ArrayList<UserRecipeDTO>>();
		userRecipeData.put("userRecipe", userRecipeList);
		
		return userRecipeData;
	}
	
	@PostMapping("deleteRecipe")
	@ResponseBody
	public int deleteRecipe(String name,HttpSession session) {
		String id = (String)session.getAttribute("id");
		Map<String,String> userRecipeMap = new HashMap<String,String>();
		userRecipeMap.put("id", id);
		userRecipeMap.put("recipe_name",name);
		
		int rs = service.deleteUserRecipe(userRecipeMap);
		return rs;
	}
	
	@PostMapping("updateRecipe")
	@ResponseBody
	public int updateRecipe(String name,HttpSession session) {
		String id = (String)session.getAttribute("id");
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("recipe_name", name);
		service.deleteRecipeStoreIngredient(id);
		ArrayList<RecipeDTO> userRecipeIngredient = service.getUserRecipeIngredient(map);
		System.out.println(userRecipeIngredient.toString());
		for(RecipeDTO dto : userRecipeIngredient) {
			service.insertIngredient(dto);
		}
		
		int rs = 0;
		return rs;
	}
	
	@PostMapping("newRecipe")
	@ResponseBody
	public int newRecipe(HttpSession session) {
		String id = (String)session.getAttribute("id");
		int rs = service.deleteRecipeStoreIngredient(id);
		return 0;
	}
	
}

