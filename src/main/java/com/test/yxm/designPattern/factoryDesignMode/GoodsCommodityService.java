package com.test.yxm.designPattern.factoryDesignMode;

import java.util.Map;

public class GoodsCommodityService implements ICommodity{
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        System.out.println("实物商品");
    }
}
