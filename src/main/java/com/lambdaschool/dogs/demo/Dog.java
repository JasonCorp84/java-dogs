package com.lambdaschool.dogs.demo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data // creates getters, setters, toString
@Entity // object ready JPA storage
public class Dog
{
    private @Id @GeneratedValue Long id; // primary key automatically populated
    private String breed;
    private int avgWeight;
    private boolean aptCompatible;

    // needed for JPA
    public Dog()
    {
        // default constructor
    }

    public Dog(String breed, int avgWeight, boolean aptCompatible)
    {
        this.breed = breed;
        this.avgWeight = avgWeight;
        this.aptCompatible = aptCompatible;
    }
}