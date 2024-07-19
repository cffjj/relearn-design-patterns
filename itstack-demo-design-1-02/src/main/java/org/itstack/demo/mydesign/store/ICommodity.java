package org.itstack.demo.mydesign.store;

import java.util.Map;

public interface ICommodity {

    void sendCommodity(String uId, String commodityId, String buzId, Map<String,String> extMap);
}
