package com.interview.corejava;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class MyClass {
    private int privateField;
    public String publicField;

    public void publicMethod() {
        System.out.println("Inside publicMethod");
    }

    private void privateMethod() {
        System.out.println("Inside privateMethod");
    }
}

public class JavaReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Get the class object for MyClass
        Class<?> myClass = MyClass.class;

        // Print the class name
        System.out.println("Class name: " + myClass.getName());

        // Print the declared fields of MyClass
        System.out.println("Declared fields:");
        Field[] fields = myClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " (Type: " + field.getType() + ")");
        }

        // Print the declared methods of MyClass
        System.out.println("Declared methods:");
        Method[] methods = myClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + " (Return type: " + method.getReturnType() + ")");
        }

        // Accessing and invoking methods using Reflection
        MyClass obj = new MyClass();
        Method publicMethod = myClass.getDeclaredMethod("publicMethod");
        publicMethod.invoke(obj); // Invoking publicMethod dynamically

        // Accessing and modifying fields using Reflection
        Field privateField = myClass.getDeclaredField("privateField");
        privateField.setAccessible(true); // Set accessible to true to access private field
        privateField.setInt(obj, 10); // Setting the value of privateField
        System.out.println("Modified privateField value: " + privateField.getInt(obj));
    }
}