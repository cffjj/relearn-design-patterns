package cn.caifujin.demo.design;

import cn.caifujin.demo.design.ICouponDiscount;

import java.math.BigDecimal;

public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice){
        return couponDiscount.discountAmount(couponInfo,skuPrice);
    }
}
