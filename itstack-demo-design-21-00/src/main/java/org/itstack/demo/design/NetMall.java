package org.itstack.demo.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class NetMall {

    protected Logger logger = LoggerFactory.getLogger(NetMall.class);

    String uId; //用户id
    String password;//用户密码

    public NetMall(String uId, String password) {
        this.uId = uId;
        this.password = password;
    }

    /**
     * 生成商品推广海报
     * @param skuUrl 商品链接
     * @return
     */
    public String generateGoodsPoster(String skuUrl){
        if (!login(uId,password)) return null;
        Map<String, String> reptile = reptile(skuUrl);
        return createBase64(reptile);
    }

    //模拟登陆
    protected abstract boolean login(String uId,String password);

    protected abstract Map<String,String> reptile(String skuUrl);

    protected abstract String createBase64(Map<String,String> goodsInfo);
}
