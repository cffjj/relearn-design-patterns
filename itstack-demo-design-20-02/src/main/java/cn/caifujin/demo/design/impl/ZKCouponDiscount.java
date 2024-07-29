package cn.caifujin.demo.design.impl;

import cn.caifujin.demo.design.ICouponDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ZKCouponDiscount implements ICouponDiscount<Double> {
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, RoundingMode.HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return new BigDecimal("0.01");
        return discountAmount;
    }
}
