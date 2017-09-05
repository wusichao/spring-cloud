package com.test.wxpay;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@RestController
public class WxController {
    @Autowired
    private Service service;
    @RequestMapping(value = "getQGcodePay",produces = "image/jpeg;charset=UTF-8")
    public byte[] getQGcodePay() throws Exception{
        //1.下单
        Map<String, String>  resultMap= service.createOrder();
        if("SUCCESS".equals(resultMap.get("return_code"))){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedImage image= MatrixToImageWriter.writeInfoToJpgBuff(resultMap.get("code_url"));
            ImageIO.write( image,"JPEG", baos);
            return baos.toByteArray();
        }
        return null;

    }
    @RequestMapping(value = "notifi")
    public String notifi(){
        System.out.println("回调成功");
    return "支付回调成功";
    }

}
