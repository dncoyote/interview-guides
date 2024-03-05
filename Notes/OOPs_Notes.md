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
- Abstraction refers to the concept of focusing on essential features and functionalities of an object while hiding its implementation details.
- In Java, abstraction is achieved by interfaces and abstract classes.

### **Interface**

- An interface is a collection of abstract methods (methods without implementation) that can be used to define a contract that a class must adhere to.
- Interfaces are used to define common behavior that can be shared among multiple classes.
- They provide a way to achieve abstraction, multiple inheritance.
- Constant variable, which is implicitly public, static, and final
- The `implements` keyword is used.

```java
interface Drawable {
    void draw();
}

class Shape implements Drawable {
    public void draw() {
        System.out.println("Drawing a shape...");
    }
}

class Text implements Drawable {
    public void draw() {
        System.out.println("Drawing text...");
    }
}

public class InterfaceExample {
    public static void drawShapes(Drawable[] shapes) {
        for (Drawable shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        Shape circle = new Shape();
        Text message = new Text();

        Drawable[] drawings = {circle, message};
        drawShapes(drawings);
    }
}

```

### **Abstract Class**

- An abstract class is a class that cannot be instantiated directly, but can be extended by other classes. It serves as a blueprint for other classes to derive from and provides common functionality that can be inherited by its subclasses.
- An abstract class cannot be instantiated, meaning we cannot create objects of it, but we can use it as a template for creating other classes that extend it.

```java
abstract class Shape {
    abstract double calculateArea();

    void draw() {
        System.out.println("Drawing a shape...");
    }
}

class Circle extends Shape {
    double radius;

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    @Override
    double calculateArea() {
        return length * width;
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 3);

        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}

```

## **Inheritance**
- Inheritance allows one class to inherit properties and methods from another class.
- The class that is being inherited from is called the superclass or parent class, and the class that inherits is called the subclass or child class.
- Inheritance is achieved using the keyword `extends` and then the subclass can access the non-private fields and methods of its superclass as if they were its own.
#### **Key features**
- Avoids rewriting code for common functionalities, saving time and effort.
- Changes made in the superclass automatically apply to its subclasses, simplifying code maintenance.
- Subclasses can add new features without modifying the superclass, promoting modularity and flexibility
```java
// Superclass: Vehicle
class Vehicle {
    String color;
    int numWheels;

    void move() {
        System.out.println("Vehicle is moving...");
    }
}

// Subclass: Car inherits from Vehicle
class Car extends Vehicle {
    String model;

    void startEngine() {
        System.out.println("Car engine started...");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.color = "Red";
        myCar.numWheels = 4;
        myCar.model = "Sedan";

        myCar.move(); // Inherited from Vehicle
        myCar.startEngine(); // Specific to Car
    }
}

```
### **Single Inheritance**
- A subclass inherits from only one superclass.
```java
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class SingleInheritanceExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat(); // Inherited from Animal
        myDog.bark(); // Specific to Dog
    }
}
```

### **Multilevel Inheritance**
- A subclass inherits from another subclass, which in turn inherits from another, and so on.
```java
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving...");
    }
}

class Car extends Vehicle {
    void startEngine() {
        System.out.println("Car engine started...");
    }
}

class SportsCar extends Car {
    void accelerate() {
        System.out.println("SportsCar is accelerating...");
    }
}

public class MultilevelInheritanceExample {
    public static void main(String[] args) {
        SportsCar mySportsCar = new SportsCar();
        mySportsCar.move(); // Inherited from Vehicle
        mySportsCar.startEngine(); // Inherited from Car
        mySportsCar.accelerate(); // Specific to SportsCar
    }
}
```

### **Hierarchical Inheritance**
- Multiple subclasses inherit from a single superclass.
```java
class Shape {
    void calculateArea() {
        System.out.println("Calculating shape area...");
    }
}

class Circle extends Shape {
    void drawCircle() {
        System.out.println("Drawing circle...");
    }
}

class Rectangle extends Shape {
    void drawRectangle() {
        System.out.println("Drawing rectangle...");
    }
}

public class HierarchicalInheritanceExample {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        Rectangle myRectangle = new Rectangle();

        myCircle.calculateArea(); // Inherited from Shape
        myCircle.drawCircle(); // Specific to Circle

        myRectangle.calculateArea(); // Inherited from Shape
        myRectangle.drawRectangle(); // Specific to Rectangle
    }
}
```
### **Multiple Inheritance**
- A subclass inherits from multiple superclasses directly.
- Java doesn't directly support this due to potential ambiguity issues.
```java
interface Drawable {
    void draw();
}

interface Movable {
    void move();
}

class Shape implements Drawable, Movable {
    public void draw() {
        System.out.println("Drawing the shape...");
    }

    public void move() {
        System.out.println("Moving the shape...");
    }
}

public class InterfaceInheritanceExample {
    public static void main(String[] args) {
        Shape myShape = new Shape();
        myShape.draw();
        myShape.move();
    }
}

```

## **Polymorphism**
- Polymorphism means the ability of objects to take on multiple forms. 
- Polymorphism allows us to perform a single action in different ways
### **Compile time Polymorphism (method overloading)**
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
### **Runtime Polymorphism (method overriding)**
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
#### Dynamic method dispatch
- Dynamic method dispatch is a mechanism in object-oriented programming languages, that allows the selection of the method to invoke at runtime rather than at compile time. It enables polymorphism
- Dynamic method dispatch is primarily associated with method overriding, where a subclass provides a specific implementation of a method that is already defined in its superclass.


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
