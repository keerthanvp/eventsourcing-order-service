package com.vpk.tutorial.orderservice.messaging.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpk.tutorial.orderservice.events.InventoryEvent;
import com.vpk.tutorial.orderservice.events.OrderEvent;
import com.vpk.tutorial.orderservice.exception.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class OrderEventDeserializer implements Deserializer<InventoryEvent> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public InventoryEvent deserialize(String s, byte[] bytes) {
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        InventoryEvent inventoryEvent;
        try{
            inventoryEvent = objectMapper.readValue(bytes, InventoryEvent.class);
        }catch (Exception e){
            throw new SerializationException("Exception in deserializing order event",e);
        }
        return inventoryEvent;
    }
}

