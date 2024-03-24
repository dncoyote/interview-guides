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