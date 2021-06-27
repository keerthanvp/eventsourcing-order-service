package com.vpk.tutorial.orderservice.event_handlers;

import com.vpk.tutorial.orderservice.events.OrderEvent;
import com.vpk.tutorial.orderservice.model.OrderStatus;
import com.vpk.tutorial.orderservice.model.PurchaseOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {

    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String,OrderEvent> kafkaTemplate;

    public void publishOrderEvent(PurchaseOrderDTO purchaseOrderDTO, OrderStatus orderStatus){
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setPurchaseOrderDTO(purchaseOrderDTO);
        orderEvent.setOrderStatus(orderStatus);

        try{
            kafkaTemplate.send(topic,orderEvent);
        }catch (Exception e){
            throw new RuntimeException("Exception while pushing the order event to kafka queue",e);
        }
    }
}
