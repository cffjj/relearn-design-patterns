package org.itstack.demo.designfj;

import org.itstack.demo.designfj.event.EventManager;
import org.itstack.demo.designfj.event.listener.MQEventListener;
import org.itstack.demo.designfj.event.listener.MessageEventListener;

public abstract class LotteryService {
    private EventManager<LotteryResult> eventManager;

    public LotteryService() {
        eventManager = new EventManager<>(EventManager.EventType.MQ,EventManager.EventType.MESSAGE);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.MESSAGE,new MessageEventListener());
    }

    public LotteryResult draw(String uId){

        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ,lotteryResult);
        eventManager.notify(EventManager.EventType.MESSAGE,lotteryResult);
        return lotteryResult;
    }

    public abstract LotteryResult doDraw(String uId);
}
