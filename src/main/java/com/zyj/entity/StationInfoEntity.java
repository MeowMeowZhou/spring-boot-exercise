package com.zyj.entity;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyj.constant.SmartConstant;
import com.zyj.constant.StationInfoConstant;
import lombok.Data;

/**
 * Table: tb_charging_station
 */
@Data
public class StationInfoEntity {

    /*充电站ID，运营商自定义的唯一编码,<=20字符*/
    @JSONField(name = "StationID",ordinal = 1)
    private String stationID;

    /*运营商ID,9位的组织机构代码*/
    @JSONField(name = "OperatorID",ordinal = 2)
    private String operatorID = SmartConstant.SMART_CONF.OPERATORID;

    /*设备所属方ID，设备所属运营平台组织机构代码，昆明的与运营商ID相同*/
    @JSONField(name = "EquipmentOwnerID",ordinal = 3)
    private String equipmentOwnerID = SmartConstant.SMART_CONF.OPERATORID;
    
    /*充电站名称*/
    @JSONField(name = "StationName",ordinal = 4)
    private String stationName ;
    
    /*充电站国家代码*/
    @JSONField(name = "CountryCode",ordinal = 5)
    private String countryCode = StationInfoConstant.COUNTRY_CODE;

    /*充电站省市辖区编码,填写内容为参照GB/T2260-2013*/
    @JSONField(name = "AreaCode",ordinal = 6)
    private String areaCode = StationInfoConstant.AreaCode;

    /*详细地址*/
    @JSONField(name = "Address",ordinal = 7)
    private String address;

    /*客服务电话，例如400的电话*/
    @JSONField(name = "ServiceTel",ordinal = 8)
    private String serviceTel;

    /*站点类型*/
    @JSONField(name = "StationType",ordinal = 9)
    private int stationType = StationInfoConstant.STATION_TYPE;

    /*站点状态*/
    @JSONField(name = "StationStatus",ordinal = 10)
    private int stationStatus = StationInfoConstant.STATION_STATUS;

    /*车位数量*/
    @JSONField(name = "ParkNums",ordinal = 11)
    private int parkNums;

    /*经度，GCJ-02坐标系*/
    @JSONField(name = "StationLng",ordinal = 12)
    private float stationLng = StationInfoConstant.STATION_LNG;

    /*纬度，GCJ-02坐标系*/
    @JSONField(name = "StationLat",ordinal = 13)
    private float stationLat = StationInfoConstant.STATION_LAT;

    /*建设场所*/
    @JSONField(name = "Construction",ordinal = 14)
    private int construction = StationInfoConstant.CONSTRUCTION;

    /*充电设备信息列表，该充电站所有充电设备信息对象集合*/
    @JSONField(name = "EquipmentInfos",ordinal = 15)
    private List<EquipmentInfoEntity> equipmentInfos;
}