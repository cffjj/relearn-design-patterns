package org.itstack.demo.mydesign.cuisine.impl;

import org.itstack.demo.design.AuthService;
import org.itstack.demo.mydesign.AuthInfo;
import org.itstack.demo.mydesign.AuthLink;

import java.text.ParseException;
import java.util.Date;

public class Level2AuthLink extends AuthLink {

    private Date beginDate = f.parse("2024-07-05 00:00:00");
    private Date endDate = f.parse("2024-07-31 00:00:00");

    public Level2AuthLink(String userId, String level) throws ParseException {
        super(userId, level);
    }

    @Override
    public AuthInfo doAuth(String userId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(LevelUserId, orderId);
        if (null == date){
            return new AuthInfo("0001","单号：",orderId," 状态：待二级审批负责人 ",levelName);
        }
        AuthLink next = super.next();
        if (null == next){
            return new AuthInfo("0000","单号：",orderId," 状态：二级审批完成负责人"," 时间：",f.format(date),"审批人：",levelName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)){
            return new AuthInfo("0000","单号：",orderId," 状态：二级审批完成负责人"," 时间：",f.format(date),"审批人：",levelName);
        }
        return next.doAuth(userId,orderId,authDate);
    }
}
