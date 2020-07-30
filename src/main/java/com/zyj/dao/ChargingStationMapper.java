package com.zyj.dao;

import com.zyj.entity.StationInfoEntity;

import java.util.List;
import java.util.Map;

public interface ChargingStationMapper {

    List<StationInfoEntity> selectInfo(Map<String, Object> params);
}