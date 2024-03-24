# **Kotlin**

## **Functional Programming**
- Functional programming is a programming paradigm that treats computation as the evaluation of mathematical functions. In functional programming, functions can be assigned to variables, passed as arguments to other functions, and returned as results from functions.
#### Key Features
##### Immutability
-  Data is typically immutable, meaning once it's created, it cannot be changed. Instead of modifying existing data, functional programs create new data structures.
- This ensures data integrity and avoids unintended side effects by working with immutable data structures.
```kotlin
val immutableList = listOf(1, 2, 3)
// immutableList.add(4) // Error: Cannot add to immutable list
```
##### Pure Functions
- Pure functions are functions that always produce the same output for the same input and have no side effects. They don't modify global state or variables outside their scope.
```kotlin
// Pure function to calculate the area of a rectangle
fun calculateArea(width: Double, height: Double): Double {
    return width * height
}

fun main() {
    val width = 5.0
    val height = 10.0

    val area = calculateArea(width, height)
    println("Area of the rectangle: $area square units")
}
// This function is pure because it doesn't modify any external state (no side effects) and always returns the same output for the same input. For example, calling calculateArea(5.0, 10.0) will always return 50.0.
// The function doesn't rely on any external variables, global variables, or mutable state. It only depends on its input parameters, making it predictable and easy to reason about.
```

##### Higher-order Functions
- Functions that can accept other functions as arguments or return functions as results are called higher-order functions. This feature enables functional programming's composability and abstraction capabilities.
- This helps in writing generic and reusable code by passing behavior as arguments, like different mathematical operations.
```kotlin
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

val result = operateOnNumbers(5, 3) { x, y -> x + y } // 8
```
##### Lambda Expression
- Lambda Expression is a concise way to represent a block of code that can be passed around as an argument to other functions, stored in variables, or returned from functions.
```kotlin
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val sum = operateOnNumbers(5, 3) { x, y -> x + y } // Lambda expression for addition
    val product = operateOnNumbers(5, 3) { x, y -> x * y } // Lambda expression for multiplication

    println("Sum: $sum")
    println("Product: $product")
}
```

##### Recursion
- Functional programming often relies on recursion instead of iterative loops for repetitive tasks.
- This helps in solving problems where a function's result depends on previous computations, like calculating factorials or traversing hierarchical data structures.
```kotlin
fun factorial(n: Int): Int {
    return if (n == 0) 1 else n * factorial(n - 1)
}

val result = factorial(5) // 120
```

##### Referential Transparency
- Expressions can be replaced with their corresponding values without changing the program's behavior, promoting clarity and reasoning about code.

#### Advantages
##### Conciseness
- Functional code tends to be more concise and expressive, reducing boilerplate and improving readability.

##### Predictability
- Pure functions and immutability lead to more predictable code behavior, making it easier to reason about and debug.

##### Parallelism
- Functional programs are inherently suitable for parallel and concurrent execution, as they avoid shared mutable state.

##### Modularity
- Higher-order functions and composability enable code reuse and modular design, promoting scalability and maintainability.

##### Reduced Bugs
- Immutability and pure functions reduce the chances of introducing bugs related to unintended side effects or state changes.

## **OOP v/s FP**
#### Concept
##### OOP
- Focuses on modeling the software as a collection of objects that have state (attributes) and behavior (methods). Objects interact with each other by sending messages and invoking methods.
##### FP
- Treats computation as the evaluation of mathematical functions. Functions are first-class citizens, meaning they can be passed around as arguments, returned from other functions, and assigned to variables.

#### Data and State
##### OOP
- Relies heavily on mutable state within objects. Objects encapsulate data and behavior, and state changes through method invocations. Inheritance and polymorphism are key concepts in managing and structuring data.
```java
public class Counter {
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        System.out.println("Count: " + counter.getCount());
    }
}
```
##### FP
- Emphasizes immutability and avoids mutable state. Data is immutable by default, and functions operate on immutable data structures. Pure functions have no side effects and always produce the same output for the same input.
```kotlin
fun incrementCount(count: Int): Int {
    return count + 1
}

fun main() {
    var count = 0
    count = incrementCount(count)
    println("Count: $count")
}
```

#### Functions and Procedures
##### OOP
- Uses methods (procedures) associated with objects to perform actions or modify state. Methods can have side effects and may interact with mutable state.
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.add(5, 3);
        System.out.println("Sum: " + sum);
    }
}
```

##### FP
- Functions are pure and focus on data transformations. Functions take input, perform computations, and return output without modifying external state. Higher-order functions and lambda expressions are common in FP.
```kotlin
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    val sum = addNumbers(5, 3)
    println("Sum: $sum")
}
```

#### Control Flow
##### OOP
- Uses control structures like loops and conditionals (if-else statements) to control the flow of execution within methods and objects.
```java
public class LoopExample {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }
}
```

##### FP
- Emphasizes recursion and higher-order functions for control flow. Recursion replaces traditional loops in many scenarios, and functions can be passed as arguments to other functions for dynamic behavior.
```kotlin
fun iterateNumbers() {
    (0 until 5).forEach { println("Iteration: $it") }
}

fun main() {
    iterateNumbers()
}
```

#### Modularity and Reusability
##### OOP
-  Promotes modularity through classes and objects. Code can be organized into reusable components using inheritance, encapsulation, and polymorphism.
```java
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        double area = circle.getArea();
        System.out.println("Area of the circle: " + area);
    }
}
```

##### FP
- Encourages modularity through functions. Functions are small, reusable units of code that can be composed and combined to build complex behavior. Higher-order functions facilitate code reuse and abstraction.
```kotlin
fun calculateArea(radius: Double): Double {
    return Math.PI * radius * radius
}

fun main() {
    val circleRadius = 5.0
    val area = calculateArea(circleRadius)
    println("Area of the circle: $area")
}
```

#### State Management and Side Effects
##### OOP
- Manages state within objects, which can lead to complex state management and potential side effects. Encapsulation helps control access to object state.
```java
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Current Balance: " + account.getBalance());
    }
}
```

##### FP
- Avoids mutable state and side effects as much as possible. Pure functions guarantee deterministic behavior and easier reasoning about code.
```kotlin
data class BankAccount(val balance: Double)

fun deposit(account: BankAccount, amount: Double): BankAccount {
    return account.copy(balance = account.balance + amount)
}

fun withdraw(account: BankAccount, amount: Double): BankAccount {
    return if (account.balance >= amount) {
        account.copy(balance = account.balance - amount)
    } else {
        println("Insufficient balance.")
        account
    }
}

fun main() {
    val initialAccount = BankAccount(1000.0)
    val updatedAccount = deposit(initialAccount, 500.0)
    val finalAccount = withdraw(updatedAccount, 200.0)
    println("Current Balance: ${finalAccount.balance}")
}
```

## **Kotlin**
- Kotlin is a modern, statically typed programming language.
- It is developed by JetBrains.
- It runs on the Java Virtual Machine (JVM) and is designed to be concise, expressive, safe, and interoperable with existing Java code. 
- Kotlin is used for developing a wide range of applications, including Android apps, server-side applications, web development, and more.
#### Features
##### Conciseness
- Kotlin reduces boilerplate code and promotes concise syntax.
```kotlin
// Kotlin code for defining a data class
data class User(val name: String, val age: Int)
```
##### Null Safety
- Kotlin emphasizes null safety to prevent null pointer exceptions.
- Use ? for nullable types and !! for asserting non-nullability.
```kotlin
// Nullable type in Kotlin
var nullableValue: String? = "Hello"
nullableValue = null // Allowed with nullable type
```
##### Smart Casts
- Kotlin automatically casts types based on checks.
```kotlin
// Smart cast example in Kotlin
fun printLength(obj: Any) {
    if (obj is String) {
        println(obj.length) // Automatically cast to String
    }
}
```
##### Extension Functions
- Extend existing classes with new functions.
```kotlin
// Extension function in Kotlin
fun String.addExclamation(): String {
    return "$this!"
}

val greeting = "Hello".addExclamation() // "Hello!"
```
##### Data Classes
- Simplifies the creation of classes to hold data.
```kotlin
// Data class in Kotlin
data class User(val name: String, val age: Int)

val user1 = User("Alice", 30)
val user2 = User("Bob", 25)
```
##### Higher-Order Functions
- Functions that take other functions as parameters or return functions.
##### Lambda Expressions:
- Concise syntax for defining anonymous functions.
##### Coroutines
- Simplifies asynchronous programming with lightweight threads.
```kotlin
// Coroutine example in Kotlin
suspend fun fetchData(): String {
    delay(1000) // Simulate delay
    return "Data fetched"
}

// Coroutine usage
GlobalScope.launch {
    val data = fetchData()
    println(data)
}
```
##### Type Inference
- Kotlin can often infer types, reducing the need for explicit type declarations.
```kotlin
// Type inference in Kotlin
val message = "Hello, Kotlin!" // Type inferred as String
```
##### Interoperability with Java
- Kotlin can seamlessly work with existing Java code and libraries.

## **Higher Order Functions**
- Can accept Functions as parameters.
- Can return Function.

## **Lambdas**

oop vs fp
Main function
var x: Int =3
$
val
variables and data types
Null Values and Null safe language
action
Unit



Jetpackcompose
Expose
Ktor