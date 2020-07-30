package com.zyj.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.zyj.constant.StationInfoConstant;
import lombok.Data;

@Data
public class ConnectorInfoEntity {

    /*充电设备接口编码，同一运营商内唯一，<=26字符*/
    @JSONField(name = "ConnectorID",ordinal = 1)
    private String connectorID;

    /*充电设备接口类型*/
    @JSONField(name = "ConnectorType",ordinal = 2)
    private int connectorType;

    /*额定电压上限*/
    @JSONField(name = "VoltageUpperLimits",ordinal = 3)
    private int voltageUpperLimits;

    /*额定电压下限*/
    @JSONField(name = "VoltageLowerLimits",ordinal = 4)
    private int voltageLowerLimits;

    /*额定电流*/
    @JSONField(name = "Current",ordinal = 5)
    private int current ;

    /*额定功率*/
    @JSONField(name = "Power",ordinal = 6)
    private float power;

    /*国家标准；1:2011 2:2015*/
    @JSONField(name = "NationalStandard",ordinal = 7)
    private int nationalStandard = StationInfoConstant.NATIONAL_STANDARD;

}
