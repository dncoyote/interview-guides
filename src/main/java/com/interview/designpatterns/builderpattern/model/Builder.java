package com.interview.designpatterns.builderpattern.model;

public interface Builder {
    
    Builder id(int id);

    Builder brand(String brand);

    Builder model(String model);

    Builder color(String color);

    Builder height(int height);

    Builder engine(String engine);

    Builder nbrOfDoors(int nbrOfDoors) ;

}
