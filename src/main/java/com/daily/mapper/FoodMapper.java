package com.daily.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.FoodDTO;
import com.daily.dto.KDRIsDTO;
import com.daily.dto.MemberDTO;
import com.daily.dto.MyFoodDTO;

@Mapper
public interface FoodMapper {

   List<FoodDTO> selectFoodList(Map<String,Object> pagingParams);
   
   int selectFoodListCnt(FoodDTO foodDTO);
   
   FoodDTO selectFood(int idx);
   
   List<FoodDTO> selectCategoryList();
   
   List<MyFoodDTO> selectMyFoodList(Map<String, Object> mmylist);
   
   MyFoodDTO selectMyFood(int idx);
   
   void insertMyFood(MyFoodDTO my);
   
   void updateMyFood(MyFoodDTO dto);
   
   void deleteMyFood(MyFoodDTO dto);

   MemberDTO selectMember(String id);

   KDRIsDTO selectKdris(Map<String, Integer> map);

   List<FoodDTO> getEnergy(double energy);
   List<FoodDTO> getCarb(double carb);
   List<FoodDTO> getProtein(double protein);
   
}