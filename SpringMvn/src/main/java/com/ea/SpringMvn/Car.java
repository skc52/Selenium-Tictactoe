package com.ea.SpringMvn;

import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car(){
        System.out.println("CAr instantiated");
    }
    public  void getCar(){
        System.out.println("Toyota car");
    }
}
