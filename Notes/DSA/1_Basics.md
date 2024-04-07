# **Basics**

# Recursion

## **Recursion**
Recursion is a programming technique where a function calls itself directly or indirectly until a base condition is met in order to solve a problem.
```java
public class FactorialExample {
    // Recursive method to calculate factorial
    public static int factorial(int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // Recursive call to factorial method
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is " + result);
    }
}
```
### Stack Space
- Stack space, also known as the call stack or runtime stack, is a specialized area of memory used by programs during runtime to manage function calls and local variables.
- Stack space plays a crucial role in keeping track of function calls and their respective variables.
- During recursion, more stack frames are added, and when a function call completes (reaches the base case or returns a value), its stack frame is removed from the stack (stack unwinding).
- It's important to be mindful of stack space when using recursion, especially for problems with deep recursion or large input sizes. 
- Excessive recursion can lead to stack overflow errors if the stack space is exhausted. In such cases, iterative approaches or tail recursion optimization can be considered to reduce the stack space usage.

### Stack Overflow Error
- Stack Overflow typically refers to a specific runtime error that occurs when the call stack of a program exceeds its allocated size.
- The call stack is a region of memory used to manage function/method calls and local variables in a program. Each time a method is called, a new frame is added to the call stack, and when the method completes, its frame is removed.
- When a method calls itself (recursion), and the recursion is not properly bounded or limited, it can lead to a situation where the call stack becomes full, resulting in a StackOverflowError.
- A stack overflow in Java is often associated with infinite or excessively deep recursion.
segmentation
Base condition
### Recursion Tree
- A recursion tree is a visual representation of the recursive calls made by a recursive function during its execution. It helps in understanding how the function breaks down a problem into smaller subproblems and combines their solutions to solve the original problem.

