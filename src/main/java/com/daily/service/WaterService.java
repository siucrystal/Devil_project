package com.daily.service;

import com.daily.dto.WaterDTO;

public interface WaterService {
	int getWaterAccure(WaterDTO dto);
	int getOne(String id);
	int WaterUpdate(WaterDTO dto);
	WaterDTO getWaterOne(String id);
}
