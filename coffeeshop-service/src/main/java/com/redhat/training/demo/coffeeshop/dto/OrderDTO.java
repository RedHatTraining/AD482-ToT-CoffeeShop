package com.redhat.training.demo.coffeeshop.dto;

public class OrderDTO {

    private String product;
    private String name;
    private String orderId;
    private Boolean hasMarshmallows;

    public String getProduct() {
        return product;
    }

    public OrderDTO setProduct(String product) {
        this.product = product;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderDTO setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Boolean getHasMarshmallows() {
        return hasMarshmallows;
    }

    public void setHasMarshmallows(Boolean hasMarshmallows) {
        this.hasMarshmallows = hasMarshmallows;
    }
}