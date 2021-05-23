package me.escoffier.quarkus.coffeeshop.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Beverage {

    public String beverage;
    public String customer;
    public String preparedBy;
    public String orderId;
    public BeverageState preparationState;

    public Beverage() {

    }

    public Beverage(Order order, String baristaName, BeverageState beverageState) {
        this.beverage = order.getProduct();
        this.customer = order.getName();
        this.orderId = order.getOrderId();
        this.preparedBy = baristaName;
        this.preparationState = beverageState;
    }

    public void setPreparationState(BeverageState preparationState) {
        this.preparationState = preparationState;
    }
}
