package com.daily.service;

import java.util.List;
import java.util.Map;

import com.daily.dto.FoodDTO;
import com.daily.dto.KDRIsDTO;
import com.daily.dto.MyFoodDTO;

public interface FoodService {
   
   List<FoodDTO> selectFoodList(FoodDTO foodDTO);
   FoodDTO selectFoodListCnt(FoodDTO foodDTO);
   List<FoodDTO> selectCategoryList();
   
   List<MyFoodDTO> selectMyFoodList(Map<String, Object> mmylist);
   List<MyFoodDTO> insertMyFood(Map<String,Object> map);
   List<MyFoodDTO> updateMyFood(Map<String, Integer> map);   
   List<MyFoodDTO> deleteMyFood(Map<String, Integer> map);
   KDRIsDTO selectKdris(String id);
   MyFoodDTO selectMyEat(String id);
   List<FoodDTO> recommendFoodList(String id);   
}