package com.vpk.tutorial.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderRequestDTO implements Serializable {

    private Integer orderID;
    private Integer userID;
    private Integer productID;
    private LocalDateTime orderDate;
}
