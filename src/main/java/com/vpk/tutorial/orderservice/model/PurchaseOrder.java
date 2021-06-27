package com.vpk.tutorial.orderservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Document("Orders")
public class PurchaseOrder implements Serializable {

    @Id
    private Integer orderID;
    private Integer userID;
    private Integer productID;
    private LocalDateTime orderDate;
    private Integer price;
    private OrderStatus orderStatus;
}
