package me.escoffier.quarkus.coffeeshop.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Order {

    private String product;
    private String name;
    private String orderId;
    private Boolean hasMarshmallows;

    public String getProduct() {
        return product;
    }

    public Order setProduct(String product) {
        this.product = product;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public Order setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Boolean getHasMarshmallows() {
        return this.hasMarshmallows;
    }

    public void setHasMarshmallows(Boolean hasMarshmallows) {
        this.hasMarshmallows = hasMarshmallows;
    }

}
