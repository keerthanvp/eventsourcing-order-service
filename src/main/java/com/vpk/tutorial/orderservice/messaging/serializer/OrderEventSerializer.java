package com.vpk.tutorial.orderservice.messaging.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vpk.tutorial.orderservice.exception.SerializationException;
import org.apache.kafka.common.serialization.Serializer;


public class OrderEventSerializer implements Serializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, Object orderEvent) {
        byte [] bytes = null;
        try{
            bytes = objectMapper.writeValueAsString(orderEvent).getBytes();
        }catch (Exception e){
            throw new SerializationException("Exception while serializing order event: ",e);
        }
        return bytes;
    }
}
