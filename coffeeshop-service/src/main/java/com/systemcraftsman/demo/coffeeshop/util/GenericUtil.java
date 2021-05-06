package com.systemcraftsman.demo.coffeeshop.util;

import com.systemcraftsman.demo.coffeeshop.dto.BeverageDTO;
import com.systemcraftsman.demo.coffeeshop.dto.OrderDTO;
import com.systemcraftsman.demo.coffeeshop.model.Beverage;
import com.systemcraftsman.demo.coffeeshop.model.Order;

public class GenericUtil {
    public static Order createOrderFromDTO(OrderDTO orderDTO) {
        return new Order(orderDTO.getProduct(), orderDTO.getName(), orderDTO.getOrderId());
    }

    public static BeverageDTO createDTOFromBeverage(Beverage beverage) {
        return new BeverageDTO(beverage.getBeverage(), beverage.getCustomer(), beverage.getPreparedBy(), beverage.getOrderId(), beverage.getPreparationState());
    }
}
