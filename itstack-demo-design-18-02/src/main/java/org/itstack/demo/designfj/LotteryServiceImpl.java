package org.itstack.demo.designfj;

import org.itstack.demo.design.MinibusTargetService;

import java.util.Date;

public class LotteryServiceImpl extends LotteryService{
    @Override
    public LotteryResult doDraw(String uId) {
        MinibusTargetService minibusTargetService = new MinibusTargetService();
        String lottery = minibusTargetService.lottery(uId);
        return new LotteryResult(uId,lottery,new Date());
    }
}
