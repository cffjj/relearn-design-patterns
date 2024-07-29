package cn.caifujin.demo.design.impl;

import cn.caifujin.demo.design.HttpClient;
import cn.caifujin.demo.design.NetMall;
import com.alibaba.fastjson.JSON;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaoBaoNetMall extends NetMall {
    public TaoBaoNetMall(String uId, String password) {
        super(uId, password);
    }

    @Override
    protected boolean login(String uId, String password) {
        logger.info("模拟淘宝用户登录：{} {}",uId,password);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String,String> map = new ConcurrentHashMap<>();
        if (m9.find()){
            map.put("name",m9.group());
        }
        map.put("price","324.54");
        logger.info("模拟淘宝商品爬虫解析：{} | {} 元 {}",map.get("name"),map.get("price"),skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("模拟淘宝生成商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }
}
