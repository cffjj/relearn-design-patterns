package cn.caifujin.demo.design.impl;

import cn.caifujin.demo.design.ICouponDiscount;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return new BigDecimal("0.01");
        return discountAmount;
    }
}
