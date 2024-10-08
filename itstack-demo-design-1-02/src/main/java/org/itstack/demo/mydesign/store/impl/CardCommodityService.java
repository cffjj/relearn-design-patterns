package org.itstack.demo.mydesign.store.impl;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.card.IQiYiCardService;
import org.itstack.demo.mydesign.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CardCommodityService implements ICommodity {

    Logger logger = LoggerFactory.getLogger(CardCommodityService.class);
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        String phone = queryUserMobile(uId);
        iQiYiCardService.grantToken(phone,"iqiyi3243243243");
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserMobile(String uId) {
        return "15200101232";
    }
}
