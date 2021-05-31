package com.systemcraftsman.demo.coffeeshop.dto;

import com.systemcraftsman.demo.coffeeshop.model.BeverageState;

public class BeverageDTO {

    private String beverage;
    private String customer;
    private String preparedBy;
    private String orderId;
    private BeverageState preparationState;
    private Boolean hasMarshmallows;

    public BeverageDTO() {
    }

    public BeverageDTO(java.lang.String beverage, java.lang.String customer, java.lang.String preparedBy, java.lang.String orderId, java.lang.Boolean hasMarshmallows, com.systemcraftsman.demo.coffeeshop.model.BeverageState preparationState) {
        this.beverage = beverage;
        this.customer = customer;
        this.preparedBy = preparedBy;
        this.orderId = orderId;
        this.preparationState = preparationState;
        this.hasMarshmallows = hasMarshmallows;
    }

    public String getBeverage() {
        return beverage;
    }

    public void setBeverage(String beverage) {
        this.beverage = beverage;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BeverageState getPreparationState() {
        return preparationState;
    }

    public void setPreparationState(BeverageState preparationState) {
        this.preparationState = preparationState;
    }

    public Boolean getHasMarshmallows() {
        return hasMarshmallows;
    }

    public void setHasMarshmallows(Boolean hasMarshmallows) {
        this.hasMarshmallows = hasMarshmallows;
    }
}
