package com.test.wxpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
@org.springframework.stereotype.Service
public class Service {
    private static final Logger log = LoggerFactory.getLogger(Service.class);
    //下单
    public Map<String, String> createOrder() throws Exception{
        Map<String,String> map = new HashMap<String,String>();
        map.put("appid","wx00ca1e91ddfbbbd2");
        map.put("mch_id","1403407402");
        map.put("nonce_str","5K8264ILTKCH16CQ2502SI8ZNMTM57VS");//随机码
        map.put("body","test");
        map.put("out_trade_no","12345678");
        map.put("total_fee","1");
        map.put("spbill_create_ip","192.168.1.151");
        map.put("notify_url","http://wusc.wicp.io:31336/notifi");//回调地址
        map.put("trade_type","NATIVE");
        map.put("product_id","98765432");
       /* map.put("openid",1);*/
        map.put("sign",WxUtil.generateSignature(map, "EfdRhg2534RHJVFrfjnbEF61Fhulk25D"));//签名
        String requestXML = WxUtil.getMap2Xml(map);
        log.info(requestXML);
        String result = WxUtil.postData("https://api.mch.weixin.qq.com/pay/unifiedorder",requestXML);
        Map<String, String> resultMap= WxUtil.xmlToMap(result);
        return resultMap;
    }
}
