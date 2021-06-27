package com.vpk.tutorial.orderservice.event_handlers;

import com.vpk.tutorial.orderservice.events.InventoryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventConsumer {

    @Autowired
    InventoryEventHandler inventoryEventHandler;

    @KafkaListener(id = "inventoryEvent",topics = "#{'${spring.kafka.consumer.topic}'.split(',')}",containerFactory = "kafkaListenerContainerFactory")
    public void listen(InventoryEvent inventoryEvent){
        System.out.println("Consumed: "+inventoryEvent);
        inventoryEventHandler.handleInventoryEvent(inventoryEvent);
    }

}
