package org.itstack.demo.mydesign.cuisine.impl;

import org.itstack.demo.design.AuthService;
import org.itstack.demo.mydesign.AuthInfo;
import org.itstack.demo.mydesign.AuthLink;

import java.util.Date;

public class Level1AuthLink extends AuthLink {
    public Level1AuthLink(String userId, String level) {
        super(userId, level);
    }

    @Override
    public AuthInfo doAuth(String userId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(LevelUserId, orderId);

        if (null == date){
            return new AuthInfo("0001","单号：",orderId,"状态：待一级审批负责人 ",levelName);
        }

        AuthLink next = super.next();
        if (next == null) {
            return new AuthInfo("0000","单号：",orderId,"状态：一级审批完成负责人","时间：",f.format(date)," 审批人：",levelName);
        }
        return next.doAuth(userId,orderId,authDate);
    }
}
