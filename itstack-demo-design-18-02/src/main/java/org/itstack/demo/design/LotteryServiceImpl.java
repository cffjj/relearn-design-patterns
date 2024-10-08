package org.itstack.demo.design;

import java.util.Date;

public class LotteryServiceImpl extends LotteryService{

    private final MinibusTargetService minibusTargetService = new MinibusTargetService();
    @Override
    protected LotteryResult doDraw(String uId) {
        String lottery = minibusTargetService.lottery(uId);
        return new LotteryResult(uId,lottery,new Date());
    }
}
