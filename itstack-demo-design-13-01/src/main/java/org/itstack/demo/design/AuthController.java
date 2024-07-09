package org.itstack.demo.design;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthController {
   private SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {
      //三级审批
      Date date = AuthService.queryAuthInfo("1000013", orderId);
      if (null == date) return new AuthInfo("0001","单号：",orderId,"状态：待三级审批负责人 ","小菜");

      if (authDate.after(f.parse("2024-07-01 00:00:00")) && authDate.before(f.parse("2024-07-010 00:00:00"))){
         date = AuthService.queryAuthInfo("1000012",orderId);
         if (null == date) return new AuthInfo("0001","单号：",orderId,"状态：待二级审批负责人 ","中菜");
      }

      if (authDate.after(f.parse("2024-07-01 00:00:00")) && authDate.before(f.parse("2024-07-010 00:00:00"))){
         date = AuthService.queryAuthInfo("1000011",orderId);
         if (null == date) return new AuthInfo("0001","单号：",orderId,"状态：待一级审批负责人 ","大菜");
      }
      return new AuthInfo("0001","单号",orderId,"状态：审批完成");
   }
}
