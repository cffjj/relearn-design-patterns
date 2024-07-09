package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.MQAdapter;
import org.itstack.demo.design.RebateInfo;
import org.itstack.demo.design.cuisine.impl.InsideOrderService;
import org.itstack.demo.design.cuisine.impl.POPOrderAdapterServiceImpl;
import org.itstack.demo.design.mq.CreateAccount;
import org.itstack.demo.design.mq.OrderMq;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {


    @Test
    public void test_MQAdapter() throws ParseException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        SimpleDateFormat s = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date parse = s.parse("2024-07-05 11:11:11");

        CreateAccount createAccount = new CreateAccount();
        createAccount.setNumber("1000001");
        createAccount.setAddress("广州市海珠区");
        createAccount.setAccountDate(parse);
        createAccount.setDesc("在校");
        Map<String, String> link1 = new HashMap<>();
        link1.put("userId","number");
        link1.put("bizId","number");
        link1.put("bizTime","accountDate");
        link1.put("desc","desc");
        RebateInfo rebateInfo1 = MQAdapter.filter(createAccount.toString(), link1);
        System.out.println("（createAccount）设配前：" + createAccount.toString());
        System.out.println("（createAccount）设配后：" + JSON.toJSONString(rebateInfo1));

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("1000001");
        orderMq.setOrderId("100000890193847111");
        orderMq.setSku("机甲乐高");
        orderMq.setCreateOrderTime(parse);

        Map<String, String> link2 = new HashMap<>();
        link2.put("userId","uid");
        link2.put("bizId","orderId");
        link2.put("bizTime","createOrderTime");
        link2.put("desc","sku");
        RebateInfo rebateInfo2 = MQAdapter.filter(orderMq.toString(), link2);
        System.out.println("（orderMq）设配前：" + orderMq.toString());
        System.out.println("（orderMq）设配后：" + JSON.toJSONString(rebateInfo2));
    }

    @Test
    public void test_itAdapter(){
        POPOrderAdapterServiceImpl popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("1000001"));
        InsideOrderService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("1000001"));
    }
}
