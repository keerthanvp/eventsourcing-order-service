package com.vpk.tutorial.orderservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryDTO implements Serializable {

    private Integer orderID;
    private Integer productID;
}
