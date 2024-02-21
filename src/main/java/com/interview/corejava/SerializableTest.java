package com.interview.corejava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest implements Serializable {

    public static void main(String[] args) {
        SerializableTest obj = new SerializableTest();
        try (FileOutputStream fileOut = new FileOutputStream("object.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
