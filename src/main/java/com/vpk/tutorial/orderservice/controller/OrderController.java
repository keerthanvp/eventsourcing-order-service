package com.vpk.tutorial.orderservice.controller;

import com.vpk.tutorial.orderservice.model.OrderRequestDTO;
import com.vpk.tutorial.orderservice.model.PurchaseOrder;
import com.vpk.tutorial.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@RequestBody OrderRequestDTO orderRequestDTO){
        return new ResponseEntity<>(orderService.create(orderRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam Integer orderID){
        return new ResponseEntity<>(orderService.delete(orderID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PurchaseOrder> view(@RequestParam Integer orderID){
        return new ResponseEntity<>(orderService.view(orderID), HttpStatus.OK);
    }

    @GetMapping("/{userID}}")
    public ResponseEntity<List<PurchaseOrder>> viewAll(@PathVariable Integer userID){
        return new ResponseEntity<>(orderService.viewAll(userID), HttpStatus.OK);
    }

}
