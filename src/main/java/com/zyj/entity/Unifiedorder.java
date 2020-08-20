package com.zyj.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
* 微信统一下单实体类，共23个字段
* */
@Data
@XStreamAlias("xml")
public class Unifiedorder {

    //微信分配的公众账号ID（企业号corpid即为此appId）
    private String appid;

    //微信支付分配的商户号
    private String mch_id;

    //终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"，非必填
    private String device_info;

    //随机字符串，不长于32位。推荐随机数生成算法
    private String nonce_str;

    //签名
    private String sign;

    //签名类型，目前支持HMAC-SHA256和MD5，默认为MD5，非必填
    private String sign_type;

    //商品简单描述，该字段须严格按照规范传递，具体请见参数规定
    private String body;

    //商品详情，非必填
    private String detail;

    //附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据，非必填
    private String attach;

    //	商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
    private String out_trade_no;

    //货币类型:符合ISO 4217标准的三位字母代码，默认人民币：CNY，非必填
    private String fee_type;

    //订单总金额，单位为分
    private int total_fee;

    //必须传正确的用户端IP,支持ipv4、ipv6格式，获取方式详见获取用户ip指引
    private String spbill_create_ip;

    //订单生成时间，格式为yyyyMMddHHmmss，非必填
    private String time_start;

    //订单失效时间，格式为yyyyMMddHHmmss，非必填
    private String time_expire;

    //商品标记，代金券或立减优惠功能的参数，非必填
    private String goods_tag;

    //接收微信支付异步通知回调地址
    private String notify_url;

    //交易类型:H5支付的交易类型为MWEB
    private String trade_type;

    //trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。非必填
    private String product_id;

    //no_credit--指定不能使用信用卡支付，非必填
    private String limit_pay;

    //trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识，非必填（公众号内才用到这个）
    private String openid;

    /* 电子发票入口开放标识，非必填*/
    private String recepit;

    //微信h5支付时候的场景信息官方的信息模板 {"h5_info"://h5支付固定传"h5_info"
    public String scene_info ;

    public static void main(String[] args) {
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{Unifiedorder.class});
        xStream.autodetectAnnotations(true);
        xStream.alias("xml",Unifiedorder.class);

        String xml = "<xml>" +
                "<appid>wx2421b1c4370ec43b</appid>" +
                "<attach>支付测试</attach>" +
                "<body>H5支付测试</body>" +
                "<mch_id>10000100</mch_id>" +
                "<nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>" +
                "<notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>" +
                "<openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>" +
                "<out_trade_no>1415659990</out_trade_no>" +
                "<spbill_create_ip>14.23.150.211</spbill_create_ip>" +
                "<total_fee>1</total_fee>" +
                "<trade_type>MWEB</trade_type>" +
                "<sign>0CB01533B8C1EF103065174F50BCA001</sign>" +
                "</xml>";
        Object o = xStream.fromXML(xml);
        System.out.println(o);
        try {
            System.out.println(MessageDigest.getInstance("md5").digest("123".getBytes()).toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


}
