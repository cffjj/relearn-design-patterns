package cn.caifujin.demo.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class NetMall {
    protected Logger logger = LoggerFactory.getLogger(NetMall.class);

    String uId;
    String password;

    public NetMall(String uId, String password) {
        this.uId = uId;
        this.password = password;
    }

    public String generateGoodsPoster(String skuUrl){
        if (!login(uId,password)) return null;
        Map<String, String> reptile = reptile(skuUrl);
        return createBase64(reptile);

    }

    protected abstract boolean login(String uId,String password);

    protected abstract Map<String,String> reptile(String skuUrl);

    protected abstract String createBase64(Map<String,String> goodsInfo);
}
