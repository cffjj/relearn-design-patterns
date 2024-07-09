package org.itstack.demo.designfj.event;


import org.itstack.demo.designfj.event.listener.EventListener;

import java.util.*;

public class EventManager<T> {

    Map<Enum<EventType>, List<EventListener<T>>> map = new HashMap<>();

    public EventManager(Enum<EventType>... enums) {
        for (Enum<EventType> AnEnum : enums) {
            map.put(AnEnum,new ArrayList<>());
        }
    }

    public enum EventType{
        MQ,MESSAGE
    }

    /**
     * 订阅消息
     */
    public void subscribe(Enum<EventType> eventTypeEnum,EventListener<T> eventListener){
        List<EventListener<T>> listeners = map.get(eventTypeEnum);
        if (!Objects.isNull(listeners)){
            listeners.add(eventListener);
        }
    }

    public void notify(Enum<EventType> eventTypeEnum, T t){
        List<EventListener<T>> listeners = map.get(eventTypeEnum);
        for (EventListener<T> listener : listeners) {
            listener.doEvent(t);
        }
    }
}
