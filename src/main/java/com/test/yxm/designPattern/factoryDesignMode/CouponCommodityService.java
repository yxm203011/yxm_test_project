package com.test.yxm.designPattern.factoryDesignMode;

import java.util.Map;

public class CouponCommodityService implements  ICommodity{
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println("优惠券");
    }
}
