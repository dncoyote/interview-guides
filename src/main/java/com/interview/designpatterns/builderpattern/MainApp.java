package com.interview.designpatterns.builderpattern;

import com.interview.designpatterns.builderpattern.model.CarBuilder;
import com.interview.designpatterns.builderpattern.model.CarSchemaBuilder;

public class MainApp {
    public static void main(String[] args) {

        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.buildBugatti(builder);
        builder.model("Chiron");
        System.out.println(builder.build());

        CarSchemaBuilder schemaBuilder = new CarSchemaBuilder();
        director.buildLambo(schemaBuilder);
        schemaBuilder.engine("90").nbrOfDoors(3);
        System.out.println(schemaBuilder.build());

    }

}