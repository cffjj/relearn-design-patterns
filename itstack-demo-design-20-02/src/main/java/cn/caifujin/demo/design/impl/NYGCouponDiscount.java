package cn.caifujin.demo.design.impl;

import cn.caifujin.demo.design.ICouponDiscount;

import java.math.BigDecimal;

public class NYGCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }
}
