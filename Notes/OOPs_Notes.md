# **Object Oriented Programming**

- Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects," which can contain data, in the form of fields (attributes or properties), and code, in the form of procedures (methods or functions). 
- OOP emphasizes the organization of software as a collection of objects that interact with each other to perform tasks.


## **Class**
- A class is a fundamental building block of object-oriented programming (OOP).
- It serves as a blueprint or template for creating objects. 
- A class defines the properties (fields or attributes) and behaviors (methods) that objects of that class will have.
- Key features
    - Fields
    - Methods
    - Constructors
    - Access modifiers
    - Encapsulation
    - Inheritance  
    - Polymorphism

## **Objects**
- Object is an instance of a class.
- Object is a key concept in object-oriented programming (OOP).
- A class serves as a blueprint or template for creating objects, and an object is a concrete instantiation of that class.
- Objects have a lifecycle that includes creation, usage, and eventually garbage collection when they are no longer referenced.

```java
  public class Mybook {
    int x=10;
  public static void main (String args []) {
    Mybook myobj= new Mybook ();
    System.out.println(myobj.x);
    }
  }
```

## **Abstraction**
- Abstraction is a process which displays only the information needed and hides the unnecessary information. We can say that the main purpose of abstraction is data hiding.
- In Java, abstraction is achieved by interfaces and abstract classes.

  ```java
  abstract class Bank{
    private String bankName;
    public abstract Integer calculateROI();
    public String getName(){
        return bankName;
    };
  }

  class HDFC extends Bank{
    public Integer calculateROI(){
        .
        .
        .
        .
        return val;
    }
  }

  public class Main(){
    psvm(){
        Bank bank = new HDFC("");
    }
  }
  ```

## **Inheritance**

- Inheritance is a method in which one object acquires/inherits another object’s properties
- The class that is being inherited from is called the superclass or parent class, and the class that inherits is called the subclass or child class.
- Inheritance is achieved using the keyword `extends` and then the subclass can access the non-private fields and methods of its superclass as if they were its own.
- Types

  - Single : In this one class i.e., the derived class inherits properties from its parental class.
  - Multilevel : This one class is derived from another class which is also derived from another class i.e., this class has more than one parental class, hence it is called multilevel inheritance.
  - Hierarchical : In this one parental class has two or more derived classes or we can say that two or more child classes have one parental class.
  - Hybrid

  ```
  code
  ```

## **Polymorphism**

- Polymorphism means the ability of objects to take on multiple forms. 
- Polymorphism allows us to perform a single action in different ways
- Types
  - Compile time Polymorphism (method overloading)
    - This occurs when multiple methods in the same class have the same name but different parameters.
    - The Java compiler determines which method to invoke based on the number, type, and order of the method's parameters

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
```
  - Runtime Polymorphism (method overriding)
    - This occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. 
    - The subclass method must have the same name, return type, and parameters as the superclass method. 
    - During runtime, the JVM determines which method to invoke based on the actual object type. Here's an example:

```java
  class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

## **Encapsulation**
- Encapsulation is the bundling of data and methods that operate on the data into a single unit or class. It hides the internal state of an object and only exposes the necessary operations.
- The data is hidden from other classes and can be accessed only through the current class’s methods.
- Encapsulation acts as a protective wrapper that prevents the code and data from being accessed by outsiders.
- Encapsulation is achieved by declaring the variables as `private` and providing `public` setter and getter methods to modify and view the variable values.

  ```java
  public class Student {
    // Private fields
    private String name;
    private int age;

    // Public methods to access and modify the private fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }
  }
  ```

## **Advantages**

## Object Oriented Programming v/s Procedure Oriented Programming

| Object Oriented Programming                                        | Procedure Oriented Programming                                                                                           |
| ------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
|  |  |
|                                    |                                                                  |

---
