package com.zyj.constant;

/**
 * 常量
 *
 * @ClassName DataConstant
 * @Author 朱兴邦
 * @CreateDate： 2020/3/23 9:59
 * @Version 1.0
 */
public interface SmartConstant {


    Integer FAILREASON_0 = 0; // 失败原因，0:无；1:无此运营商；2:密钥错误；3～99:自定义
    Integer FAILREASON_NO_OPERATOR = 1; // 失败原因，0:无；1:无此运营商；2:密钥错误；3～99:自定义
    Integer FAILREASON_KEY_ERROR = 2; // 失败原因，0:无；1:无此运营商；2:密钥错误；3～99:自定义
    Integer TOKEN_VALID_TIME = 7200; // token 有效期限  7200秒
    Integer TOKEN_STORE_TIME = 5000; // token 存在redis时间  本地存放


    interface DATA_STATE {
        Integer SUCCESS = 0;  //0成功
        Integer ERROR = 1;    //1失败
    }


    interface TOKEN {
        // 发送token  本地生成发送给成都
        String OUR_TOKEN = "connection:chengdu:send:token";
        // 发送token  本地生成发送给成都token最终有效期时间yyyy-MM-dd HH:mm:ss
        String OUR_TOKEN_ENDTIME = "connection:chengdu:send:tokenEndTime";
        // 接收token  成都token本地接收验证
        String THEIR_TOKEN = "connection:chengdu:accept:token";
    }

    interface REDIS_DB {
        int DB_1 = 1;
        int DB_10 = 10;
        int DB_11 = 11;
        int DB_12 = 12;
    }

    interface SMART_CONF {
        /*数据（Data）加密密钥与向量*/
        String SECRET = "cdz-cd-ty-1.0.0-";     //密钥  运营商分配加密秘钥;
        String VECTOR = "zkzl-cd-ty-1.0.0";    //向量  运营商分配初始化向量;

        // #运营商标识，长度为9的固定标识，昆明固定为MA6NNDH83
        String OPERATORID = "MA6NNDH83";

        //token秘钥  运营商分配token秘钥
        String OPERATORSECRET = "casmrc-token-km-ty";

        // 我们请求第三方平台 传我们的运营商标识   第三方请求我们的平台 传第三方运营商标识
        // 第三方运营商标识
        String THIRD_OPERATORID = "765367656";

        //#签名密钥  运营商分配签名秘钥
        String SIGNATUREKEY = "zkzl-sign-cd-ty-";
    }

}
