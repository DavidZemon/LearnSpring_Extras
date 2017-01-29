package com.uprr.app.tng.spring.purchaseorder;

import com.uprr.app.tng.spring.purchaseorder.config.PurchaseOrderConfig;
import com.uprr.app.tng.spring.purchaseorder.service.PurchaseOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PurchaseOrderConfig.class)
public class PurchaseOrderServiceIT {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Test
    public void test() throws Exception {
        this.purchaseOrderService.purchaseOrder("2345");
    }
}
