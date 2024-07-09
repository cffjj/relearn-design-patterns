package org.itstack.demo.designfj.event.listener;

import org.itstack.demo.designfj.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MQEventListener implements EventListener<LotteryResult>{
    private Logger logger = LoggerFactory.getLogger(org.itstack.demo.design.event.listener.MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录用户 {} 摇号结果(MQ)：{}", result.getuId(), result.getMsg());
    }

}
