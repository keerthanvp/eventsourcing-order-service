package com.vpk.tutorial.orderservice.dao.impl;

import com.mongodb.MongoWriteException;
import com.vpk.tutorial.orderservice.dao.OrderDao;
import com.vpk.tutorial.orderservice.exception.DaoWriteException;
import com.vpk.tutorial.orderservice.model.OrderStatus;
import com.vpk.tutorial.orderservice.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PurchaseOrder create(PurchaseOrder purchaseOrder) {
        PurchaseOrder order;
        try{
            order = mongoTemplate.insert(purchaseOrder);
        }catch (MongoWriteException mongoWriteException){
            throw new DaoWriteException("Exception while inserting ",mongoWriteException);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public Boolean delete(Integer orderID) {
        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(orderID));
            mongoTemplate.remove(query,"Orders");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public PurchaseOrder view(Integer orderID) {
        PurchaseOrder purchaseOrder;
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(orderID));
            purchaseOrder = mongoTemplate.findOne(query,PurchaseOrder.class);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return purchaseOrder;
    }

    @Override
    public List<PurchaseOrder> viewAll(Integer userID) {
        List<PurchaseOrder> purchaseOrders;
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("userID").is(userID));
            purchaseOrders = mongoTemplate.find(query, PurchaseOrder.class,"Orders");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return purchaseOrders;
    }

    @Override
    public void updatePurchaseOrderStatus(Integer orderID, OrderStatus orderStatus) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(orderID));
            Update update = new Update();
            update.set("orderStatus",orderStatus);
            mongoTemplate.updateMulti(query,update,PurchaseOrder.class);
        }catch (Exception e){
            throw new RuntimeException("Exception while updating purchase order status",e);
        }
    }

}
