package org.itstack.demo.designfj.event.listener;

import org.itstack.demo.designfj.LotteryResult;

public interface EventListener<T> {

    void doEvent(T t);
}
