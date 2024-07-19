package org.itstack.demo.mydesign;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AuthLink {

    protected String LevelUserId;

    protected String levelName;

    private AuthLink next;

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public AuthLink(String userId, String level) {
        this.LevelUserId = userId;
        this.levelName = level;
    }

    public AuthLink next(){
        return next;
    }

    public AuthLink appendNext(AuthLink authLink){
        this.next = authLink;
        return this;
    }

    public abstract AuthInfo doAuth(String userId, String orderId, Date date);


}
