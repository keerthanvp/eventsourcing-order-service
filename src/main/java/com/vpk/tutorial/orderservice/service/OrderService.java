package com.vpk.tutorial.orderservice.service;

import com.vpk.tutorial.orderservice.model.OrderRequestDTO;
import com.vpk.tutorial.orderservice.model.PurchaseOrder;

import java.util.List;

public interface OrderService {
    PurchaseOrder create(OrderRequestDTO orderRequestDTO);
    boolean delete(Integer orderID);
    PurchaseOrder view(Integer orderID);
    List<PurchaseOrder> viewAll(Integer userID);
}
