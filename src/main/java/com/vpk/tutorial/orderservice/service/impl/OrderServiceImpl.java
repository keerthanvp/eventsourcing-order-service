package com.vpk.tutorial.orderservice.service.impl;

import com.vpk.tutorial.orderservice.dao.OrderDao;
import com.vpk.tutorial.orderservice.event_handlers.OrderEventPublisher;
import com.vpk.tutorial.orderservice.model.OrderRequestDTO;
import com.vpk.tutorial.orderservice.model.PurchaseOrder;
import com.vpk.tutorial.orderservice.model.OrderStatus;
import com.vpk.tutorial.orderservice.model.PurchaseOrderDTO;
import com.vpk.tutorial.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderEventPublisher publisher;

    @Autowired
    private Map<Integer, Integer> productPriceMap;

    @Override
    public PurchaseOrder create(OrderRequestDTO orderRequestDTO) {
        PurchaseOrder purchaseOrder = dtoToEntity(orderRequestDTO);
        publisher.publishOrderEvent(getPurchaseOrderDTO(orderRequestDTO),OrderStatus.CREATED);
        return orderDao.create(purchaseOrder);
    }

    @Override
    public boolean delete(Integer orderID) {
        return orderDao.delete(orderID);
    }

    @Override
    public PurchaseOrder view(Integer orderID) {
        return orderDao.view(orderID);
    }

    @Override
    public List<PurchaseOrder> viewAll(Integer userID) {
        return orderDao.viewAll(userID);
    }

    private PurchaseOrder dtoToEntity(OrderRequestDTO dto){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setOrderID(dto.getOrderID());
        purchaseOrder.setUserID(dto.getUserID());
        purchaseOrder.setProductID(dto.getProductID());
        purchaseOrder.setOrderDate(dto.getOrderDate());
        purchaseOrder.setPrice(productPriceMap.get(dto.getProductID()));
        purchaseOrder.setOrderStatus(OrderStatus.CREATED);
        return purchaseOrder;
    }

    private PurchaseOrderDTO getPurchaseOrderDTO(OrderRequestDTO dto){
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setOrderID(dto.getOrderID());
        purchaseOrderDTO.setUserID(dto.getUserID());
        purchaseOrderDTO.setProductID(dto.getProductID());
        purchaseOrderDTO.setPrice(productPriceMap.get(dto.getProductID()));
        return purchaseOrderDTO;
    }
}
