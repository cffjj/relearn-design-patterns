package cn.caifujin.demo.design.impl;

import cn.caifujin.demo.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("o");

        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;

        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return new BigDecimal("0.01");
        return discountAmount;
    }
}
