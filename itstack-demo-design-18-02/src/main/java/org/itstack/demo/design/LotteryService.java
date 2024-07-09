package org.itstack.demo.design;

import org.itstack.demo.design.event.EventManager;
import org.itstack.demo.design.event.listener.MQEventListener;
import org.itstack.demo.design.event.listener.MessageEventListener;

public abstract class LotteryService {

    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ,EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId){
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notify(EventManager.EventType.MQ,lotteryResult);
        eventManager.notify(EventManager.EventType.Message,lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
