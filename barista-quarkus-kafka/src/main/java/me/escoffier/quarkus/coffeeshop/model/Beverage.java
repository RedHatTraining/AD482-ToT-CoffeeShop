package me.escoffier.quarkus.coffeeshop.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Beverage {

    private String beverage;
    private String customer;
    private String preparedBy;
    private String orderId;
    private BeverageState preparationState;

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
