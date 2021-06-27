package com.vpk.tutorial.orderservice.event_handlers;

import com.vpk.tutorial.orderservice.dao.OrderDao;
import com.vpk.tutorial.orderservice.events.InventoryEvent;
import com.vpk.tutorial.orderservice.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventHandler {

    @Autowired
    private OrderDao orderDao;

    public void handleInventoryEvent(InventoryEvent inventoryEvent){
        switch (inventoryEvent.getInventoryStatus()){
            case RESERVED:
                orderDao.updatePurchaseOrderStatus(inventoryEvent.getInventoryDTO().getOrderID(), OrderStatus.APPROVED);
                break;
            case REJECTED:
                orderDao.updatePurchaseOrderStatus(inventoryEvent.getInventoryDTO().getOrderID(), OrderStatus.REJECTED);
                break;
        }
    }
}
