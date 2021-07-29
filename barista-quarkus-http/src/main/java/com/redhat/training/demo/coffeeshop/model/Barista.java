package com.redhat.training.demo.coffeeshop.model;

import com.redhat.training.demo.coffeeshop.util.NameUtil;

import javax.inject.Singleton;

@Singleton
public class Barista {
    private String name;

    public String getName() {
        if (null == name){
            name = NameUtil.getRandomName();
        }
        return name;
    }
}
