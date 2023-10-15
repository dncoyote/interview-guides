# **Object Oriented Programming**

Object Oriented Programming is the programming paradigm that uses classes and objects to structure their code.

---

### **Objects & Classes**

- Objects are always called instances of a class which are created from a class in java or any other language. They have states and behaviour.

  ```
  Public class Mybook {
    int x=10;
  Public static void main (String args []) {
    Mybook myobj= new Mybook ();
    System.out.println(myobj.x);
    }
  }
  ```

- The collection of objects is said to be a class.
- Class is also called a template of an object. Classes have members which can be fields, methods and constructors

---

### **Abstraction**

- Abstraction is a process which displays only the information needed and hides the unnecessary information. We can say that the main purpose of abstraction is data hiding.
- In Java, abstraction is achieved by interfaces and abstract classes.

  ```
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

---

### **Inheritance**

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

---

### **Polymorphism**

- Polymorphism as the ability of a message to be displayed in more than one form.
- Polymorphism allows us to perform a single action in different ways
- Types

  - Compile time Polymorphism
  - Runtime Polymorphism

  ```
  code
  ```

---

### **Encapsulation**

- It is the process that binds together the data and code into a single unit and keeps both from being safe from outside interference and misuse.
- The data is hidden from other classes and can be accessed only through the current class’s methods.
- Encapsulation acts as a protective wrapper that prevents the code and data from being accessed by outsiders.
- Encapsulation is achieved by declaring the variables as private and providing public setter and getter methods to modify and view the variable values.

  ```
  code
  ```

---

### **Advantages**

---

### Object Oriented Programming v/s Procedure Oriented Programming

| Object Oriented Programming                                        | Procedure Oriented Programming                                                                                           |
| ------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------ |
| It references an existing string object in the pool if one exists. | It explicitly creates a new string object on the heap, regardless of whether an identical string is already in the pool. |
| More memory efficient.                                             | Less memory efficient.                                                                                                   |

---
