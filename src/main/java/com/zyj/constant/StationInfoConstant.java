package com.zyj.constant;

public class StationInfoConstant {

    //
    public static final String OPERATORID="";

    public static final String COUNTRY_CODE = "CN";//充电站国家代码，固定为CN，中国

    //    public static String EQUIPMENTOWNERID = "MA2TDK504";
    public static String AreaCode = "530112";  //地区编码，参照GB/T2260-2015，昆明固定为530112 ，西山区
    public static String STATION_NAME = "中科智充（昆明大悦城充电站）"; //充电站名称
    public static String STATION_ID = "ccaccf0febca4b88a5df212c6c8c1f9c"; //充电站id
    public static String ADDRESS = "云南省昆明市环城南路168号大悦城负二层D区"; //昆明充电站详细地址
    public static int STATION_TYPE = 1; //站点类型，昆明固定为1，公共
    public static int STATION_STATUS = 50; //站点状态，昆明固定为50，正常使用

    public static float STATION_LNG = 102.713881f; //经度，GCJ-02坐标系

    public static float STATION_LAT = 25.022278f; //纬度，GCJ-02坐标系

    public static int CONSTRUCTION = 9; //建设场所，昆明固定值为9，大型建筑配建停车场

    /*国家标准；1:2011 2:2015*/
    public static final int NATIONAL_STANDARD = 2;
}
