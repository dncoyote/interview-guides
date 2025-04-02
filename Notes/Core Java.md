# **Core Java**
## Table of Contents

 1. [Internal Concepts](#Internal-Concepts)
    1. [JRE, JVM, JDK](#JRE,-JVM,-JDK)
    2. [JAR Files](#JRE,-JVM,-JDK)
    3. Compilation and Bytecode
    4. Memory Management
    5. Class Loading
    6. Garbage Collection
    7. Heap and Stack
    8. Just-In-Time Compilation (JIT)
    9. Java Process and Runtime
 2. [Language Basics](#language-basics)
    - Variables and Data Types
    - Arrays
    - Operators
    - Control Flow
    - Methods and Functions
    - Strings
    - Packages
    - Native Methods
 3. [Classes](#classes)
    - Class Basics
    - Attributes and Fields
    - Methods
    - Constructors
    - Access Modifiers
    - Nested classes
    - Static
    - Class modifiers
    - Wrapper Classes
    - Autoboxing
    - Object Class
    - Instanceof keyword
 4. [Inheritance](#Inheritance)
    - Subclasses
    - Accessing Superclass Members
    - Method Overriding
    - Super Keyword
 5. [Interfaces](#Interfaces)
    - Basics
    - Creating Interfaces
    - Implementing and Extending Interfaces 
    - Multiple Inheritance with Interfaces
    - Static Methods in Interfaces
    - Choosing between Interfaces and Abstract Classes
    - Nested Interfaces
    - Variables in Interfaces
    - Sealed interfaces
6. [Enumerations](#Enumerations)
    - Declaring Enums
    - Enum Constants
    - Enum Constructors
    - Enum Methods and Fields
    - Enum Methods and Values
        - name()
        - ordinal()
        - valueOf()
7. [Exception Handling](#Enumerations)        
    - Understanding Exceptions
    - Types of Exceptions 
    - Exception Hierarchy
    - try-catch Blocks
    - Multiple catch Blocks
    - Finally Block 
    - Throwing Exceptions
    - Checked vs. Unchecked Exceptions
    - Custom Exceptions
    - Using try-with-resources
    - Exception Propagation 
    - Exception Chaining 
    - Handling Uncaught Exceptions
8. [Collections](#Enumerations)  
    - Collection Interfaces
    - Collection Classes
    - Selecting the right collection class  
9. [Generics](#Enumerations)  
    - Basics 
    - Type Parameters and Type Arguments
    - Generic Classes
    - Generic Methods
    - Wildcards
    - Generic Interfaces
10. [Annotations](#Enumerations)
    - Fundamentals
        - @Override
        - @SuppressWarnings
        - @Deprecated
        - @@SafeVarargs
        - @FunctionalInterface
        - @Native
        - @Target
        - @Retention
        - @Inherited
        - @Documented
        - @Repeatable 
    - Creating custom Annotations
11. [Lambda Expressions](#Enumerations)
    - Fundamentals
12. [Java I/O](#Enumerations)
    - Understanding I/O Streams
    - Byte Streams vs. Character Streams
    - File I/O 
    - Buffered Streams
    - Standard Streams
    - Reading and Writing Files
    - Map and reduce
    - Interfaces
    - Serialization
    - Java NIO
13. [Multithreaded Programming](#Enumerations)
    - Basics
    - Thread Creation
    - Synchronization
    - Executor Framework
    - Callable and Future
    - Thread Communication
    - Thread States
    - Deadlocks and Livelocks
    - Concurrency Utilities
    - Atomic Classes
    - Thread Pools
    - Parallel Streams
14. [Database](#Enumerations)
    - JDBC
    - CRUD
15. [JVM Options](#Enumerations)
    - Standard Options
    - Memory Management
    - Thread Management
    - Performance Tuning
    - GC Tuning
    - Profiling and Debugging
16. [Misc](#Enumerations)
    - Date and Time APIs 
    - JPA
    - Hibernate
    - Encoding and Decoding
    - Encryption and Decryption
    - Regex
    - Reflection

# **Language Basics**
## Variables
 - A variable is a container for storing data values.
 - Each variable has a name, type and value.
```java
int age = 31; 
```
### Types of Variables
#### Local Variables 
- Declared inside methods, constructors, or blocks. They are accessible only within the scope where they are defined.
```java
public void display() {
    int localVar = 10; // Local variable
    System.out.println(localVar);
}
```
#### Instance Variables 
- Declared outside methods but inside a class. They belong to an instance of the class.
```java
public class MyClass {
    int instanceVar = 20; // Instance variable
}
```

#### Static Variables
- Declared with the `static` keyword and shared among all instances of the class.
```java
public class MyClass {
    static int staticVar = 30; // Static variable
}
```
### Literals
- Literals are constant values directly assigned to variables. They represent fixed values in the source code.

### Type Conversion
- Type Conversion is the process of converting a value from one data type to another.
#### Implicit Type Conversion
- Automatically performed by Java when converting a smaller data type to a larger one
```java
int num = 10;
double result = num; // int to double
System.out.println("Result: " + result);
```
> Conversion Order - byte -> short -> int -> long -> float -> double
#### Explicit Type Conversion
- Manually performed to convert a larger data type to a smaller one.
- Can lead to data loss or truncation.
```java
 double num = 10.99;
 int result = (int) num; // double to int
 System.out.println("Result: " + result);
```

### Type Casting
- Casting refers to explicitly converting a value from one data type to another. It is performed using parentheses ().
- Casting is used when working with generics
- Used for object hierarchy conversions or narrowing primitives.
```java
Object obj = "Hello";
String str = (String) obj; // Explicit casting
```

## Data Types
- Data types define the type of data a variable can hold.
- In Java, Data Types are broadly categorized into Primitive Data Types and Non-Primitive Data Types.
### Primitive Data Types
- Java provides 8 built-in data types

| Data Type      |Description      | Size      |Range      |Example      |
| :---  | :---   |:---         |:---           |:---          |
| `byte` | Integer (small range) | 1 byte |-128 to 127 |`byte b = 100;` |
| `short` | Integer (medium range) | 2 bytes |-32,768 to 32,767 |`short s = 32000;` |
| `int` | Integer (default) | 4 bytes |-2^31 to 2^31 - 1 |`int i = 123456789;` |
| `long` | Integer (large range) | 8 bytes |-2^63 to 2^63 - 1 |`long l = 9223372036854775807L;` |
| `float` | Decimal (single precision) | 4 bytes |3.4028235E38 to ~1.4E-45 |`float f = 3.14F;` |
| `double` | Decimal (double precision) | 8 bytes |1.7976931348623157E308 to ~4.9E-324 |`double d = 3.141592653589793;` |
| `char` | Single character | 2 bytes |0 to 65,535 (Unicode character set) |`char c = 'A';` |
| `boolean` | True or False | 1 bit |true, false |`boolean isJavaFun = true;` |

### Non-Primitive Data Types | Reference Types
- Non-primitive data types include Objects, Strings, Arrays, Enums and Classes. 
- They are also called as  Reference Types.
- These types refer to objects and hold the memory address (or reference) of the object rather than the actual data. In contrast to primitive types, which store the actual value, reference types store the memory address where the object data is stored.
- Default value is `null`.
- The reference variable itself is on the stack, but the object it refers to is stored in the heap.

## `var` keyword | Local Variable Type Inference
- Local Variable Type Inference is a feature introduced in Java 10, 
- This allows the compiler to infer the type of a local variable from the context without explicitly specifying the type. 
- This is done using the `var` keyword.
- `var` keyword can only be used for local variables inside methods, loops, and other local scopes. It cannot be used for instance variables, method parameters, or return types.
```java
var greeting = "Hello, World!"; // Java will infer the type as String
var num = 10;  // Java infers the type as int
var price = 99.99;  // Java infers the type as double

//Collection
var list = new ArrayList<String>();  // Java infers the type as ArrayList<String>
list.add("Hello");
list.add("World");

//loop
var arr = new int[]{1, 2, 3, 4, 5};
for (var num : arr) {  // Java infers the type of num as int
    System.out.println(num);
}
```

## Arrays
- An array is a container object that holds a fixed number of values of a single type
- Java arrays are objects, and they store multiple values, either primitive or reference types, in a contiguous block of memory.
- Once an array is created, its size cannot be changed.
- The elements in an array are stored in consecutive memory locations.
- Array elements are accessed by their index, starting from 0.

### Single-Dimensional Arrays
```java
int[] numbers = {1, 2, 3, 4, 5}; // Array of integers
String[] names = {"Alice", "Bob", "Charlie"}; // Array of strings
```

### Multi-Dimensional Arrays
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
int[][] matrix = new int[3][3]; // 2D array with 3 rows and 3 columns

```

### Arrays of Objects
- Java arrays can store objects as well as primitive data types. 
- When you create an array of objects, each element in the array holds a reference to an object.
```java
// Array of String Objects
String[] fruits = new String[3];  // Declare an array of 3 String objects
fruits[0] = "Apple";  // Assign values to the array
fruits[1] = "Banana";
fruits[2] = "Orange";

// Array of custom Objects
Person[] people = new Person[2];
people[0] = new Person("Alice", 25);
people[1] = new Person("Bob", 30);
```
## Operators
- Operators are used to manipulate data and variables in Java.
    - Arithmetic Operators
    - Relational Operators
    - Logical Operators
    - Bitwise Operators
    - Assignment Operators
    - Unary Operators
    - Ternary (Conditional) Operator
    - Instanceof Operator
### Bitwise Operators
- Bitwise operators are used to perform bit-level operations on integer types (byte, short, int, long).
```java
int a = 5;  // Binary: 0101
int b = 3;  // Binary: 0011

System.out.println("a & b: " + (a & b)); // 1 (Binary: 0001)
System.out.println("a | b: " + (a | b)); // 7 (Binary: 0111)
System.out.println("a ^ b: " + (a ^ b)); // 6 (Binary: 0110)
System.out.println("~a: " + (~a));       // -6 (Binary: 1010, Two's complement)
System.out.println("a << 1: " + (a << 1)); // 10 (Binary: 1010)
System.out.println("a >> 1: " + (a >> 1)); // 2 (Binary: 0010)
```

### Ternary Operators
- The ternary operator is a shorthand for the if-else statement. 
- It takes three operands: a condition, a value for true, and a value for false.
```java
int a = 10;
int b = 5;
int result = (a > b) ? a : b;
System.out.println("Max value: " + result); // 10
```

## Control Flow
- Control flow refers to the order in which individual statements, instructions, or function calls are executed or evaluated in a program

### Decision Making Statements
#### `if - else` Statement
- Executes a block of code if the condition is true.
```java
if (marks >= 90) {
    System.out.println("Grade: A");
} else if (marks >= 75) {
    System.out.println("Grade: B");
} else if (marks >= 50) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: Fail");
}
```

#### `switch` Statement
- Executes one block of code among many based on a matching case.
```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Other day");
}
```
### Looping Statements

#### `for` loop
- Executes a block of code for a specific number of iterations.
```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Count: " + i);
}
```
#### `while` loop
- Executes a block of code while the condition is true.
```java
 int i = 1;
 while (i <= 5) {
    System.out.println("Count: " + i);
    i++;
}
```
#### `do-while` loop
- Executes a block of code at least once, then repeats while the condition is true.
```java
int i = 1;
do {
    System.out.println("Count: " + i);
    i++;
} while (i <= 5);
```
#### `enhanced for` loop
```java
for (int num : numbers) {
    System.out.println("Number: " + num);
}
```
### Branching Statements
- Branching statements are used to transfer control to another part of the program.

#### `break` Statement
- Terminates the loop or switch statement.
```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) break; // Exit the loop when i is 5
    System.out.println(i);
}
```
#### `continue` Statement
- Skips the current iteration of the loop and moves to the next.
```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) continue; // Skip even numbers
    System.out.println(i);
}
```
#### `return` Statement
- Exits from the current method and optionally returns a value.
```java
return a + b;
```

## Methods and Functions
In Java, methods (also called functions in other languages) are blocks of code that perform a specific task.
### Defining and Calling Methods
#### Syntax
```
access_modifier return_type method_name(parameters) {
    // Method body (code logic)
    return value; // Only if return type is not void
}
```
### Method Parameters
- Methods can take parameters (inputs) to work with dynamic values.
```java
 public static int addNumbers(int a, int b) {
        return a + b;
    }
```
### Method Overloading
- Method Overloading allows multiple methods with the same name but different parameters.
```java
public class OverloadExample {
    // Method with two integers
    public static int multiply(int a, int b) {
        return a * b;
    }

    // Overloaded method with three integers
    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // Overloaded method with doubles
    public static double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println(multiply(2, 3));      // Calls first method
        System.out.println(multiply(2, 3, 4));   // Calls second method
        System.out.println(multiply(2.5, 3.5));  // Calls third method
    }
}
```
## Strings
- In Java, strings are objects that represent a sequence of characters. 
- Unlike primitive types, strings are immutable, meaning their values cannot be changed once created.
### Declaring and Initializing Strings
#### String Literal
```java
String name = "Java";  // Stored in the String Pool
```
- Efficient, as JVM reuses existing strings in the String Pool.

#### `new` keyword
```java
String name = new String("Java"); // Creates a new object in heap
```
- Avoid this approach unless needed, as it creates a new object every time.

### String Immutability
- Prevents modification of sensitive data.
- Helps JVM optimize memory with the String Pool.
- Since strings don’t change, they can be safely shared across threads.

```java
public class StringExample {
    public static void main(String[] args) {
        String s1 = "Hello";
        s1 = s1 + " World"; // Creates a new String object
        
        System.out.println(s1); // Output: Hello World
    }
}
```
## Packages
## Native Methods