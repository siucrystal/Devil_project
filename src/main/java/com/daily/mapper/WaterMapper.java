package com.daily.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.daily.dto.WaterDTO;

@Mapper
public interface WaterMapper {
	int getWaterAccure(WaterDTO dto);
	int getOne(String id);
	int WaterUpdate(WaterDTO dto);
	WaterDTO getWaterOne(String id);
}
