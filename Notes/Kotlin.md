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
- It is developed by JetBrains and first released in 2011.
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

## **Main Program**
- A main program refers to the entry point of an executable Kotlin application. It's where the program execution begins. 
- Any code written outside of the main function will not be executed unless it is called from within main or from functions called within main.

```kotlin
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val sum = operateOnNumbers(5, 3) { x, y -> x + y } // Using lambda expression for addition
    val product = operateOnNumbers(5, 3) { x, y -> x * y } // Using lambda expression for multiplication

    println("Sum: $sum")
    println("Product: $product")
}
```
## **Types of data**
#### Primitives
- Primitive data types represent basic values and are stored directly in memory. They are optimized for performance and memory usage.
- Primitive types are more memory-efficient
##### Numbers
```kotlin
val byteValue: Byte = 10
val shortValue: Short = 100
val intValue: Int = 1000
val longValue: Long = 100000L
val floatValue: Float = 3.14f
val doubleValue: Double = 2.71828
```
##### Characters
```kotlin
val charValue: Char = 'A'
```

##### Boolean
```kotlin
val isTrue: Boolean = true
val isFalse: Boolean = false
```
#### Reference Data Types
- Reference data types represent complex data structures and are stored as references to memory locations.
##### Strings
- Represents a sequence of characters.
```kotlin
val stringValue: String = "Hello, Kotlin!"
```
##### Arrays
- Represents a fixed-size collection of elements of the same type.
```kotlin
val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
val chars: CharArray = charArrayOf('a', 'b', 'c')
```
##### Collections
- Represent collections of elements.
```kotlin
val list: List<String> = listOf("apple", "banana", "cherry")
val set: Set<Int> = setOf(1, 2, 3)
val map: Map<String, Int> = mapOf("one" to 1, "two" to 2)
```
##### Custom Data Types
- Classes, objects, enums, and data classes defined by the programmer.
```kotlin
data class Person(val name: String, val age: Int)

val person1 = Person("Alice", 30)
val person2 = Person("Bob", 25)
```

## **`val`**
- `val` keyword is used to declare read-only variables, also known as immutable variables, meaning their values cannot be modified after initialization.
- Once a value is assigned to a `val` variable, it cannot be changed or reassigned. The value remains constant throughout the program execution.
- When declaring a `val` variable, you must assign an initial value.
- You can read the value of a val variable, but you cannot modify it(Read-Only Access).
```
val variableName: DataType = initialValue
```
```kotlin
val pi: Double = 3.14159
val message: String = "Hello, Kotlin!"
val age: Int = 25
```

## **`var`**
- `var` is a keyword used to declare mutable variables. Mutable variables are those whose values can be changed or reassigned after initialization. 
- The `var` keyword is used when you need a variable whose value can vary during the program's execution.
```
var variableName: DataType = initialValue
```
```kotlin
var count: Int = 10
count = 15
```

## **`val` v/s `var`**
| `val`      | `var`      |
| ------------- | ------------- |
| Declares read-only variables whose values cannot be changed after initialization. | Declares mutable variables whose values can be changed or reassigned after initialization. |
| Used for constants or fixed values that remain constant throughout the program. | Used when the value of a variable needs to be modified during the program's execution. |

## **Side Effects**
- Side effects refer to observable changes or interactions with the external world that occur when a function is executed.
- These changes can include modifying mutable state, performing I/O operations, altering global variables, or causing system-level effects.
- Side effects can make code harder to reason about, test, and maintain, as they introduce unpredictability and dependencies on external factors.

#### Avoiding Side Effects
- Use immutable data structures whenever possible to prevent accidental modifications and side effects.
- Write pure functions that do not modify external state or have observable side effects. Pure functions are deterministic and rely only on their input parameters.
- Minimize the use of global variables and mutable state. Instead, encapsulate state within objects and use local variables whenever possible.
- Embrace functional programming concepts like immutability, higher-order functions, and function composition to reduce side effects and improve code readability.

## **Null Safety in Kotlin**
- Null safety in Kotlin refers to the language's built-in features and practices designed to prevent null pointer exceptions (NPEs) and ensure more reliable and predictable code behavior when dealing with nullable types.

## **Safe Call Operator `?.`**
- The safe call operator `?.` allows accessing properties, methods, or elements of an object only when the object reference is not null. 
- If the object is null, the expression returns null instead of throwing a null pointer exception.
- They simplify null checks and avoid explicit null checks in code.
```
val result = object?.property
```
```kotlin
val name: String? = null
val length: Int? = name?.length
println("Length: $length") // Output: null
```

## **Elvis  Operator `?:`**
- The Elvis operator `?:` provides a default value to use when an expression on the left-hand side evaluates to null. 
- It allows specifying a fallback value or expression to handle null cases gracefully.
```
val result = nullableValue ?: defaultValue
```
```kotlin
val name: String? = null
val length = name?.length ?: -1
println("Length: $length") // Output: -1 (default value used when name is null)
```

## **Nullable Type Operator `?`**
- The nullable type operator `?` explicitly indicates that a variable or property can be assigned a null value, making nullability explicit in the code.
- Nullable types force developers to handle null cases explicitly, improving code robustness and preventing NPEs.
```
val nullableVariable: Type? = null
var nullableProperty: Type? = null
```
```kotlin
fun main() {
    val nullableString: String? = null
    val length: Int? = nullableString?.length ?: -1 // Default value if nullableString is null
    println("Length: $length") // Output: -1 (default value used when nullableString is null)
}
```
- In this example, nullableString is declared as a nullable String?, and the safe access operator (?.) is used to access its length property safely. The Elvis operator (?:) provides a default value of -1 if nullableString is null, ensuring that length is always a non-null integer value.

## **Not Null Assertion  Operator `!!`**
- The not-null assertion operator `!!` is used to assert that an expression is not null. 
- It converts a nullable type to a non-nullable type, but it can lead to a `NullPointerException` if the expression on the left-hand side evaluates to null.
```
val result = nullableValue!!
```
```kotlin
val name: String? = "Alice"
val length = name!!.length
println("Length: $length") // Output: 5 (non-null assertion used, assuming name is not null)
```

## **Data Class**
- Data class is a type of class primarily used to hold and manage data. 
- It is designed to reduce boilerplate code by automatically generating several standard functions such as `equals()`, `hashCode()`, `toString()`, `copy()`, and `componentN()` methods based on the properties defined in the class. 
- Data classes are commonly used to represent immutable data objects .
```
data class ClassName(val property1: Type, val property2: Type, ...)
```
```kotlin
data class Person(val name: String, val age: Int)

fun main() {
    val person1 = Person("Alice", 30)
    val person2 = Person("Bob", 25)

    println(person1) // Output: Person(name=Alice, age=30)
    println(person2) // Output: Person(name=Bob, age=25)

    val person3 = person1.copy(age = 35) // Creating a copy with modified age
    println(person3) // Output: Person(name=Alice, age=35)

    val (name, age) = person2 // Destructuring declaration
    println("Name: $name, Age: $age") // Output: Name: Bob, Age: 25
}
```

## **Functions**
- Functions are blocks of code that perform a specific task and can be called multiple times from different parts of the program.
- Functions allow you to encapsulate logic, improve code reusability, and make your code more organized and modular.
```
fun functionName(parameter1: Type1, parameter2: Type2, ...): ReturnType {
    // Function body
}
```

## **Higher Order Functions**
- Higher-order functions in Kotlin are functions that can take other functions as parameters or return functions as results.
- This is a fundamental concept in functional programming, allowing you to treat functions as first-class citizens and enabling powerful programming paradigms like function composition, function chaining, and passing behavior as arguments.
- They are often used with lambda expressions for conciseness and readability.
- Function Composition: Allows combining multiple functions to create new behaviors.
- Function Chaining: Enables chaining multiple functions together for sequential execution.
- Declarative Programming: Facilitates writing code in a more declarative and expressive style.

#### Higher-Order Function with Function Parameter
- A higher-order function with a function parameter is a function that takes another function as an argument.
- This is a fundamental concept in functional programming that enables passing behavior as a parameter to a function.
```kotlin
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun main() {
    val sum = operateOnNumbers(5, 3) { x, y -> x + y } // Using lambda expression for addition
    val product = operateOnNumbers(5, 3) { x, y -> x * y } // Using lambda expression for multiplication

    println("Sum: $sum")
    println("Product: $product")
}
```
#### Higher-Order Function with Function Return Type
- A higher-order function with a function return type is a function that returns another function as its result.
- This enables creating functions dynamically based on certain conditions or parameters.
```kotlin
fun createAddFunction(): (Int, Int) -> Int {
    return { x, y -> x + y }
}

fun main() {
    val addFunction = createAddFunction()
    val sum = addFunction(5, 3) // Using the returned function to perform addition

    println("Sum: $sum")
}
```
```kotlin
fun createMathOperation(operationType: String): (Int, Int) -> Int {
    return when (operationType) {
        "addition" -> { a, b -> a + b }
        "subtraction" -> { a, b -> a - b }
        "multiplication" -> { a, b -> a * b }
        "division" -> { a, b -> a / b }
        else -> throw IllegalArgumentException("Invalid operation type")
    }
}

fun main() {
    val addFunction = createMathOperation("addition")
    val subtractFunction = createMathOperation("subtraction")
    val multiplyFunction = createMathOperation("multiplication")
    val divideFunction = createMathOperation("division")

    val result1 = addFunction(10, 5) // Result: 15
    val result2 = subtractFunction(10, 5) // Result: 5
    val result3 = multiplyFunction(10, 5) // Result: 50
    val result4 = divideFunction(10, 5) // Result: 2

    println("Result of addition: $result1")
    println("Result of subtraction: $result2")
    println("Result of multiplication: $result3")
    println("Result of division: $result4")
}
```

## **Pure Functions**
- Pure function always produces the same output for the same input, regardless of the external state or environment. 
- Pure functions do not modify the state of the program or have any observable side effects. They only depend on their input parameters and return a value without modifying any external state.
- Pure functions are used in scenarios where you want to ensure predictability, maintainability, and testability of your code.
    - Calculations and computations.
    - Data transformation operations like mapping, filtering and sorting.
```kotlin
fun addNumbers(a: Int, b: Int): Int {
    return a + b
}
```
```kotlin
//Pure Function : Mapping
fun squareNumbers(numbers: List<Int>): List<Int> {
    return numbers.map { it * it }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val squaredNumbers = squareNumbers(numbers)

    println("Original Numbers: $numbers")
    println("Squared Numbers: $squaredNumbers")
}

//Pure Function : Filtering
fun filterEvenNumbers(numbers: List<Int>): List<Int> {
    return numbers.filter { it % 2 == 0 }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = filterEvenNumbers(numbers)

    println("Original Numbers: $numbers")
    println("Even Numbers: $evenNumbers")
}

//Pure Function : Sorting
fun sortNumbers(numbers: List<Int>): List<Int> {
    return numbers.sorted()
}

fun main() {
    val numbers = listOf(5, 3, 8, 1, 2)
    val sortedNumbers = sortNumbers(numbers)

    println("Original Numbers: $numbers")
    println("Sorted Numbers: $sortedNumbers")
}
```
## **Lambda Expression**
- A lambda expression is a compact piece of code that is used to represent an anonymous function (a function without a name) that can be passed as an argument to a method or stored as a variable. It consists of parameters, the arrow operator, and a body.
- Lambda expressions are particularly useful in scenarios where you need to pass behavior as an argument.
- They lead to more concise and expressive code, making your Kotlin programs more readable and maintainable.

```
val lambdaName: (parameters) -> returnType = { arguments ->
    // Lambda body
    // Code to be executed
}
```
```kotlin
val square: (Int) -> Int = { x ->
    x * x
}

println(square(5))
```
```kotlin
//Lambda expression with no parameters
{ println("Hello, Kotlin!") }
//Lambda expression with a single parameter
{ x: Int -> println("Number: $x") }
//Lambda expression with multiple parameters
{ x: Int, y: Int -> println("Sum: ${x + y}") }
//Lambda expression with no parameters and a return value
{ -> "Hello, Kotlin!" }
//Lambda expression with a single parameter and a return value
{ x: Int -> x * x }
//Lambda expression with multiple parameters and a return value
{ x: Int, y: Int -> x + y }
```

## **Coroutines**
- Coroutine in Kotlin is a concurrency design pattern and language feature that allows you to write asynchronous, non-blocking code in a sequential manner.
- Coroutines enable you to perform long-running tasks, such as network requests, disk operations, or CPU-intensive computations, without blocking the main thread or causing thread starvation. 
- Coroutines are lightweight, efficient, and designed to handle concurrency in a structured and intuitive way.
#### Features
##### Coroutine Builders
- Kotlin provides coroutine builders like launch, async, and runBlocking to create and manage coroutines.
##### Asynchronous Execution
- Coroutines allow you to execute code asynchronously, making it suitable for tasks that involve waiting for I/O operations, such as network requests or file I/O.
##### Non-Blocking Operations
- Unlike traditional threading models, coroutines are non-blocking, meaning they don't block the main thread while waiting for a task to complete. This helps prevent UI freezes and improves responsiveness in applications.
##### Structured Concurrency
- Kotlin's coroutine framework provides structured concurrency, allowing you to manage and coordinate multiple coroutines effectively.
##### Cancellation and Error Handling
- Error handling mechanisms, such as try-catch blocks, can be used within coroutines to handle exceptions gracefully and cancellation can be used to cancel or stop a coroutine's execution when it's no longer needed or when an error occurs.

#### Uses
- Coroutines can be used for parallelism by launching multiple coroutines that execute tasks concurrently, leveraging multi-core processors for improved performance.
- Coroutines are commonly used for asynchronous programming tasks, such as making network requests, fetching data from databases, or performing background computations without blocking the main thread.
- They are used to handle concurrent processing of data and resources without the complexities of traditional threading models.

#### Launching a Coroutine with `launch` Builder
```kotlin
fun main() {
    // Launching a new coroutine in the GlobalScope
    GlobalScope.launch {
        delay(1000) // Simulating a long-running task
        println("Coroutine completed")
    }

    println("Main thread continues") // Executed immediately
    Thread.sleep(2000) // Adding delay to keep the main thread alive
}
```
- `launch` is used to start a new coroutine in the GlobalScope or a specified coroutine scope.

#### Launching a Coroutine with `async` Builder
```kotlin
suspend fun fetchData(): String {
    delay(1000) // Simulating a network request delay
    return "Data fetched successfully"
}

fun main() = runBlocking {
    // Launching a coroutine with async builder
    val deferred = async {
        fetchData()
    }

    println("Main thread continues") // Executed immediately

    // Waiting for the async task to complete and printing the result
    println("Async result: ${deferred.await()}")
}
```
- `async` is used to perform a computation asynchronously and return a Deferred result.

#### Using Coroutines with Scope
```kotlin
suspend fun fetchUserData(): String {
    delay(1000) // Simulating a network request delay
    return "User data fetched successfully"
}

fun main() = runBlocking {
    // Creating a coroutine scope
    coroutineScope {
        launch {
            println("Launching coroutine 1")
            delay(2000) // Simulating a task delay
            println("Coroutine 1 completed")
        }

        launch {
            println("Launching coroutine 2")
            delay(1000) // Simulating another task delay
            println("Coroutine 2 completed")
        }

        // Waiting for child coroutines to complete before continuing
        delay(3000)
        println("All coroutines completed")
    }

    println("Main thread continues") // Executed after all coroutines complete
}
```
- `runBlocking` and `coroutineScope` are coroutine builders that provide a coroutine scope for structured concurrency.
- `delay` is a suspending function used to simulate delays in coroutines without blocking the thread.

---

$
action
Unit
constructors
iteration
companion
when


Jetpackcompose
Expose
Ktor