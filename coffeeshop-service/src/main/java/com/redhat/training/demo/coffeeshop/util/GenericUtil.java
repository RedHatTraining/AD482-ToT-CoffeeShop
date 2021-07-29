package com.redhat.training.demo.coffeeshop.util;

import com.redhat.training.demo.coffeeshop.dto.BeverageDTO;
import com.redhat.training.demo.coffeeshop.dto.OrderDTO;
import com.redhat.training.demo.coffeeshop.model.Beverage;
import com.redhat.training.demo.coffeeshop.model.Order;

public class GenericUtil {
    public static Order createOrderFromDTO(OrderDTO orderDTO) {
        return new Order(orderDTO.getProduct(), orderDTO.getName(), orderDTO.getOrderId(), orderDTO.getHasMarshmallows());
    }

    public static BeverageDTO createDTOFromBeverage(Beverage beverage) {
        return new BeverageDTO(beverage.getBeverage(), beverage.getCustomer(), beverage.getPreparedBy(), beverage.getOrderId(), beverage.getHasMarshmallows(), beverage.getPreparationState());
    }
}
