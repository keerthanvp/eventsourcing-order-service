package com.vpk.tutorial.orderservice.dao;

import com.vpk.tutorial.orderservice.model.OrderStatus;
import com.vpk.tutorial.orderservice.model.PurchaseOrder;

import java.util.List;

public interface OrderDao {
    PurchaseOrder create(PurchaseOrder purchaseOrder);
    Boolean delete(Integer orderID);
    PurchaseOrder view(Integer orderID);
    List<PurchaseOrder> viewAll(Integer userID);
    void updatePurchaseOrderStatus(Integer orderID, OrderStatus orderStatus);
}
