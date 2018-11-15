package me.mingshan.saga.api.order.model.vo;

import me.mingshan.saga.api.order.enums.OrderStatus;

import java.io.Serializable;

/**
 * @author mingshan
 */
public class OrderVO implements Serializable {
    private String id;
    private long userId;
    private long productId;
    private int price;
    private OrderStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
