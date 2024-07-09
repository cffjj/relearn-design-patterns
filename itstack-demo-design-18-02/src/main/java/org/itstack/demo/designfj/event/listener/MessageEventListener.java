package org.itstack.demo.designfj.event.listener;

import org.itstack.demo.designfj.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEventListener implements EventListener<LotteryResult>{
    private Logger logger = LoggerFactory.getLogger(org.itstack.demo.design.event.listener.MessageEventListener.class);
    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给用户 {} 发送短信通知(短信)：{}", result.getuId(), result.getMsg());
    }
}
