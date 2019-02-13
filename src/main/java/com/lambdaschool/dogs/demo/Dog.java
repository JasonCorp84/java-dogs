package com.lambdaschool.dogs.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Dog {
    private @Id @GeneratedValue Long id;
    private String breedName;
    private double averageWeight;
    private boolean okInApartment;

    public Dog(String breedName, double averageWeight, boolean okInApartment) {
        this.breedName = breedName;
        this.averageWeight = averageWeight;
        this.okInApartment = okInApartment;
    }

    public Dog(){

    }
    
}
