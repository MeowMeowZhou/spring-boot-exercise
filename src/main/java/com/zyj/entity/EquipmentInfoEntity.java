package com.zyj.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

@Data
public class EquipmentInfoEntity {

     /*设备唯一编码，对同一运营商，保证唯一，<=23字符*/
    @JSONField(name = "EquipmentID",ordinal = 1)
    private String equipmentID;

    /*设备类型 1：直流设备 2：交流设备 3：交直流一体设备*/
    @JSONField(name = "EquipmentType",ordinal = 2)
    private int equipmentType;

    /*充电设备总功率，保留小数点后一位*/
    @JSONField(name = "Power",ordinal = 3)
    private double power;

    /* 该充电设备所有的充电设备接口的信息对象集合*/
    @JSONField(name = "ConnectorInfos",ordinal = 4)
    private List<ConnectorInfoEntity> connectorInfos;

}
