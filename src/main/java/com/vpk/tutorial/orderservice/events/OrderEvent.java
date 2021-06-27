package com.vpk.tutorial.orderservice.events;

import com.vpk.tutorial.orderservice.model.OrderStatus;
import com.vpk.tutorial.orderservice.model.PurchaseOrderDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderEvent implements Serializable {

    private static final long SERIAL_VERSION_UID = 101;
    private PurchaseOrderDTO purchaseOrderDTO;
    private OrderStatus orderStatus;
}
