# **Design Patterns & Principles**

## **SOLID principles**

- SOLID is an acronym representing a set of five design principles that are widely used in object-oriented programming to create maintainable, flexible, and understandable software
- They are are considered fundamental guidelines for writing clean and well-structured code.

#### Single Responsibility Principle (SRP)

- A class should have only one reason to change or only one responsibility

```java
// Problem - Violating SRP
class Employee {
    void calculateSalary() { /* ... */ }
    void generatePaySlip() { /* ... */ }
    void saveData() { /* ... */ }
}

// Solution - Following SRP
class Employee {
    void calculateSalary() { /* ... */ }
}

class PaySlipGenerator {
    void generatePaySlip() { /* ... */ }
}

class EmployeeDataStorage {
    void saveData() { /* ... */ }
}
```

#### Open/Closed Principle (OCP)

- Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification
- Modules should be extended without modifying it.
- Similar to abstraction.
- Eg., EmailNotification.java class and MobileNotificationService.java class both implements NotificationService.java interface, instead of having both email and mobile services in NotificationService.java class.

```java
// Problem - Violating OCP
class Rectangle {
    int width, height;
}

class Circle {
    int radius;
}

// Solution - Following OCP
interface Shape {
    double area();
}

class Rectangle implements Shape {
    int width, height;
    public double area() { return width * height; }
}

class Circle implements Shape {
    int radius;
    public double area() { return Math.PI * radius * radius; }
}


```

#### Liskov Substitution Principle (LSP)

- LSP states that derived class must be completely substitutable for their base classes. i.e., if class A is a subtype of class B, then we should be able to replace B with A without interrupting the behaviour of the program.
- Derived classes should adhere to the contract established by their base classes and should not change the expected behavior.
- Eg.,

```java
// Problem - Violating LSP
class Bird {
    void fly() { /* ... */ }
}

class Ostrich extends Bird {
    void fly() { throw new UnsupportedOperationException(); }
}

// Solution - Following LSP
interface Bird {
    void move();
}

class Sparrow implements Bird {
    void move() { /* ... */ }
}

class Ostrich implements Bird {
    void move() { /* ... */ }
}

```

#### Interface Segregation Principle (ISP)

- Do not force client to use methods that they do not want to use.
- Large interfaces should be broken into small ones.
- Eg., ShapeCalculatorInterface has abstract methods calculateArea() and calculateVolume(), if Circle class implements ShapeCalculatorInterface then LSP is broken as Circle does not have volume. Inorder to fix this create another interface 3DCalculatorInterface with calculateVolume() alone.

```java
// Problem - Violating ISP
interface Worker {
    void work();
    void eat();
}

// Solution - Following ISP
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

```

#### Dependency Inversion Principle (DIP)

- High-level modules should not depend on low-level modules. Both should depend on abstractions.

```java
// Problem - Violating DIP
class LightBulb {
    void turnOn() { /* ... */ }
    void turnOff() { /* ... */ }
}

class Switch {
    LightBulb bulb = new LightBulb();

    void operate() {
        if (/* condition */) {
            bulb.turnOn();
        } else {
            bulb.turnOff();
        }
    }
}

// Solution - Following DIP
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Fan implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

class Switch {
    Switchable device;

    void operate() {
        if (/* condition */) {
            device.turnOn();
        } else {
            device.turnOff();
        }
    }
}
```

## **Design Patterns**

- Design patterns are reusable and general solutions to common software design problems that occur during the development of software applications.
- They are best practices or templates that help developers solve problems efficiently, make software more maintainable, and improve software architecture.

#### **Categories of Design Patterns**

- Creational Patterns
- Structural Patterns
- Behavioral Patterns
- Architectural Patterns
- Concurrency Patterns

## **Creational Pattern**
- A creational design pattern deals with the process of object creation in software development.
- Creational patterns abstract the instantiation process, making the system independent of how its objects are created, composed, and represented.

## **Singleton Pattern**

- Singleton pattern is a creational design pattern
- It restricts the instantiation of a class to ensure that there is only one instance of that class in the entire application.
- It guarantees to provide a global point of access to that instance.
- Singleton pattern is often used to control access to a resource, manage a shared resource, or maintain a single point of control, such as a configuration manager or a connection pool (Database connections, Logger instances).
- Key characteristics

  - Private Constructor: The Singleton class has a private constructor, preventing external code from creating instances of the class directly.
  - Private Static Instance: It typically contains a private static instance of the class itself.
  - Public Static Method: It provides a public static method that allows access to the unique instance. This method creates the instance if it doesn't exist or returns the existing instance

  ```java
  public class Singleton {

    private final String data;
  // Private static volatile instance
    private static volatile Singleton instance;

    // Private constructor
    private Singleton(String data) {
        this.data = data;
    }

    // Public static method to get the instance
    public static Singleton getInstance() {
      Singleton result = instance;
        if (result == null) {
          //only one thread at a time can enter this critical section
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return result;
    }

    public String getData() {
        return data;
    }

  }
  ---

  public class MainApp {

    public static void main(String[] args) {

        System.out.println(Singleton.getInstance("Geekific"));
        Singleton singleton = Singleton.getInstance("Singleton");
        System.out.println(singleton);
        System.out.println(singleton.getData());

    }


  }

  ```

## **Builder Pattern**
- Builder Pattern is a creational design pattern.
- It separates the construction of a complex object from its representation and allows the same construction process to create different representations.
- The key idea is to separate the construction of a complex object from its representation.
- This pattern extract the object construction code out of its own class and move it to separate objects called `builders`.
- If we don't use Builder pattern we will have to create many parameterized constructors that leads to ugly code depending on the number of objects.
- They are primarily used for building complex objects step by step.
- Product class - `Car.java`
    - Represents a car with various attributes like brand, model, color, etc.
    - It's the final product that we want to build using the Builder pattern.
- Builder Interface - `Builder.java`
    - Declares a set of methods that concrete builders must implement to construct a complex object step by step.
    - It acts as a contract, ensuring that any class implementing it knows how to build different parts of the final object.
- ProductBuilder(Concrete Builder) Class - `CarBuilder.java`
    - Implements the Builder interface to build a Product object.
    - Keeps track of the details of the car being constructed. Each method (like brand, model, etc.) sets a specific attribute of the car, and the build method creates the final `Car` object.
- ProductSchema Class - `CarSchema.java`
    - Represents a different type of object with a similar structure to a product.
    - Illustrates that the Builder pattern is flexible and can be used to build various types of objects with a similar construction process.
- ProductSchemaBuilder(Concrete Builder) Class - `CarSchemaBuilder.java`
    - Implements the Builder interface to build a `ProductSchema` object.
    - Similar to `CarBuilder`, but it constructs a different type of object (CarSchema). It sets attributes specific to CarSchema.
- Director Class - `Director.java`
    - Guides the construction process by calling the builder methods in a specific order.
    - Acts as a supervisor, providing a set of predefined steps to construct different types of objects. It abstracts the building process from the client.
- MainApp Class
    - Demonstrates how to use the Builder pattern to construct objects.

## **Factory Method Pattern**

- Factory Method Pattern is a creational design pattern.
- It provides an interface for creating objects but allows subclasses to alter the type of objects that will be created.
- In essence, it abstracts the process of object creation and delegates it to its subclasses, which can implement the factory method to produce objects of different types.
- Key components

  - Product: This is the common interface or abstract class that represents the objects the factory will create.

  - Concrete Product: These are the actual implementations of the products created by the factory. Each concrete product corresponds to a specific type or variation.

  - Creator (Factory): The creator is an interface or an abstract class that declares the factory method. This method returns a Product object, and it is typically defined as an abstract method.

  - Concrete Creator: The concrete creator classes implement the factory method to produce specific instances of concrete products. Each concrete creator is responsible for creating a particular type of product.

```java

// Product
interface Animal {
  void makeSound();
}

// Concrete Products
class Dog implements Animal {
  public void makeSound() {
    System.out.println("Dog barks");
  }
}

class Cat implements Animal {
  public void makeSound() {
    System.out.println("Cat meows");
  }
}

// Creator (Factory)
interface AnimalFactory {
  Animal createAnimal();
}

// Concrete Creators
class DogFactory implements AnimalFactory {
    public Animal createAnimal() {
  return new Dog();
  }
}

class CatFactory implements AnimalFactory {
  public Animal createAnimal() {
    return new Cat();
  }
}

public class FactoryMethodExample {
  public static void main(String[] args) {
    AnimalFactory factory1 = new DogFactory();
    AnimalFactory factory2 = new CatFactory();

    Animal dog = factory1.createAnimal();
    Animal cat = factory2.createAnimal();

    dog.makeSound(); // Output: Dog barks
    cat.makeSound(); // Output: Cat meows
  }

}

```

## **Prototype Pattern**

- Prototype Pattern is a creational design pattern.
- It is used to create objects by copying an existing object, known as the "prototype."
- This pattern is particularly useful when the cost of creating an object is more expensive than copying an existing object i.e., useful when the cost of creating a new instance is more expensive.
- The Prototype pattern allows you to create new objects by cloning an existing instance, and it's based on the concept of creating new objects by copying an existing one.

```java
//Prototype interface
public interface Prototype {
    Prototype clone();
}

//Concrete Prototype Classes
public class ConcretePrototypeA implements Prototype {
    @Override
    public Prototype clone() {
        // Create a new instance by copying this object's state
        return new ConcretePrototypeA();
    }
}

public class ConcretePrototypeB implements Prototype {
    @Override
    public Prototype clone() {
        // Create a new instance by copying this object's state
        return new ConcretePrototypeB();
    }
}

//Prototype Manager
public class PrototypeManager {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void registerPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }

    public Prototype getPrototype(String key) {
        Prototype prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        return null;
    }
}

//Main class
public class Client {
    public static void main(String[] args) {
        PrototypeManager manager = new PrototypeManager();
        manager.registerPrototype("A", new ConcretePrototypeA());
        manager.registerPrototype("B", new ConcretePrototypeB());

        Prototype objectA = manager.getPrototype("A");
        Prototype objectB = manager.getPrototype("B");
    }
}
```

## **Observer Pattern**

- Observer Pattern is a behavioral design pattern.
- Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- It allows one object (the subject or observable) to notify a list of its dependents (observers) when its state changes.
- This pattern is commonly used to implement distributed event handling systems, in which one object (the subject) maintains a list of dependent objects (observers) that are notified of any state changes, typically by calling one of their methods.
- Components
  - Subject (Observable): The subject is the object that maintains a list of observers and notifies them when its state changes. It provides methods for adding, removing, and notifying observers.
  - Observer: The observer is an interface or abstract class that defines the update method. Concrete observer classes implement this method to respond to updates from the subject.

```java
import java.util.ArrayList;
import java.util.List;

// Subject (Observable)
class WeatherStation {
    private int temperature;
    private List<WeatherObserver> observers = new ArrayList<>();

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer
interface WeatherObserver {
    void update(int temperature);
}

// Concrete Observers
class TemperatureDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Temperature Display: " + temperature + "°C");
    }
}

class PhoneApp implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Phone App: Temperature is " + temperature + "°C");
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay display = new TemperatureDisplay();
        PhoneApp app = new PhoneApp();

        weatherStation.addObserver(display);
        weatherStation.addObserver(app);

        weatherStation.setTemperature(25);
        weatherStation.setTemperature(30);

        weatherStation.removeObserver(app);

        weatherStation.setTemperature(22);
    }
}

```

- In this example, the WeatherStation is the subject, and it notifies TemperatureDisplay and PhoneApp (observers) when the temperature changes. The observers implement the WeatherObserver interface, which defines the update method for responding to changes in the subject's state.
