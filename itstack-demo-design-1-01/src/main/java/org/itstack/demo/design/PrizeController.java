package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.card.IQiYiCardService;
import org.itstack.demo.design.coupon.CouponResult;
import org.itstack.demo.design.coupon.CouponService;
import org.itstack.demo.design.goods.DeliverReq;
import org.itstack.demo.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrizeController {
    private final Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq awardReq){
        String reqJson = JSON.toJSONString(awardReq);
        AwardRes awardRes = null;

        try {
            logger.info("奖品发放开始{} req：{}",awardReq.getuId(),reqJson);

            if (awardReq.getAwardType() == 1){
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(awardReq.getuId(), awardReq.getAwardNumber(), awardReq.getBizId());

                if ("0000".equals(couponResult.getCode())){
                    awardRes = new AwardRes("0000", "发放成功");
                }else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            }else if (awardReq.getAwardType() == 2){
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(awardReq.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(awardReq.getuId()));
                deliverReq.setSku(awardReq.getAwardNumber());
                deliverReq.setOrderId(awardReq.getBizId());
                deliverReq.setConsigneeUserName(awardReq.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(awardReq.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(awardReq.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess){
                    awardRes = new AwardRes("0000","发放成功");
                }else {
                    awardRes = new AwardRes("0001","发放失败");
                }
            }else if (awardReq.getAwardType() == 3){
                String userPhoneNumber = queryUserPhoneNumber(awardReq.getuId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(userPhoneNumber,awardReq.getAwardNumber());
                awardRes = new AwardRes("0000","发放成功");
            }
            logger.info("奖品发放完毕 {}",awardReq.getuId());
        }catch (Exception e){
            logger.error("奖品发放失败{} req:{}",awardReq.getuId(), reqJson, e);
            awardRes = new AwardRes("0001",e.getMessage());
        }


        return awardRes;


    }



    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }



}
