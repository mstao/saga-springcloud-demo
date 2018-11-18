package me.mingshan.saga.order.util;

import me.mingshan.saga.api.order.enums.OrderStatus;

import java.util.EnumSet;

/**
 * @author mingshan
 */
public class OrderStatusUtil {

     public static OrderStatus getOrderStatusFormCode(int code) {
         EnumSet<OrderStatus> allOf = EnumSet.allOf(OrderStatus.class);

         for (OrderStatus orderStatus : allOf) {
             if (orderStatus.getCode() == code) {
                 return orderStatus;
             }
         }

         throw new IllegalArgumentException("Order status code is incorrect");
     }
}
