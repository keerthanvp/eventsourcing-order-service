package com.vpk.tutorial.orderservice.events;

import com.vpk.tutorial.orderservice.model.InventoryDTO;
import com.vpk.tutorial.orderservice.model.InventoryStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryEvent implements Serializable {

    private static final long SERIAL_VERSION_UID = 101;
    private InventoryDTO inventoryDTO;
    private InventoryStatus inventoryStatus;

}
