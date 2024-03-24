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