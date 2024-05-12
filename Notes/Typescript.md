# **Typescript**
## **What is Typescript?**
- TypeScript is a superset of JavaScript that adds static typing, making code more robust and easier to maintain. It introduces concepts like type annotations, interfaces, and generics to help catch errors early in the development process.
####  Static Typing
One of the main features of TypeScript is static typing, this allows you to define types for variables, function parameters, and return values. This helps catch type-related errors during development, leading to more robust and reliable code.
####  Type Inference
- TypeScript's type inference feature automatically determines the type of a variable based on its value and usage context. This reduces the need for explicit type annotations while still providing type safety.

## **Basic Types**
- Basic types refer to the fundamental data types that are used to represent different kinds of values.

#### number
- Represents numeric values, including integers and floating-point numbers.
```ts
let age: number = 25;
```
#### string
- Represents textual data enclosed within single ('') or double ("") quotes.
```ts
let name: string = 'John Doe';
```
#### boolean
- Represents a logical value of true or false.
Example: let isStudent: boolean = true;
```ts
let isStudent: boolean = true;

```
#### null and undefined
- null represents an intentional absence of any value.
- undefined represents a variable that has been declared but not assigned a value.
```ts
let data1: null = null;
let data2: undefined = undefined;
```
#### object
- Represents any JavaScript object, including arrays, functions, and custom objects.
```ts
let person: object = { name: 'John', age: 30 };
```
#### array
- Represents a collection of elements of the same type or mixed types.
```ts
let numbers: number[] = [1, 2, 3, 4, 5];
```
#### tuple
- Represents an array with a fixed number of elements where each element may have a different data type.
```ts
let tuple: [string, number] = ['John Doe', 30];
```
#### enum
- Represents a set of named constants.
```ts
enum Color {
    Red,
    Green,
    Blue,
}

let color: Color = Color.Red;
```
#### any
- Represents any type and allows for dynamic typing, bypassing TypeScript's type checking.
```ts
let dynamicData: any = 'Hello';
dynamicData = 10; // No type checking for any type
```
#### void
- Represents the absence of a type, commonly used as the return type for functions that don't return a value.
```ts
function sayHello(): void {
    console.log('Hello!');
}
```
## **object**

## **Type Annotation**
- Type annotations in TypeScript involve explicitly specifying the data type of a variable, function parameter, or function return value. 
- This is done using a colon `:` followed by the desired type. 
- Type annotations provide clarity and help TypeScript catch type-related errors during development.

#### Variable with Type Annotation:
```ts
let age: number = 25;
//Here, age is explicitly annotated as a number.
```

#### Function Parameter with Type Annotation:
```ts
function greet(name: string): string {
    return 'Hello, ' + name + '!';
}
//The name parameter is annotated as a string, and the function is expected to return a string.
```

#### Function Return Type Annotation:
```ts
function add(a: number, b: number): number {
    return a + b;
}
//The function add is annotated to return a number.
```
## **Type Inference**
- Type inference in TypeScript is the ability of the compiler to automatically deduce the data type of a variable, function parameter, or function return value based on its initialization value or usage context. 
- TypeScript uses type inference to determine types when explicit type annotations are not provided.
#### Variable with Type Inference:
```ts
let age = 25; // TypeScript infers `age` as type `number`
```

#### Function Parameter with Type Inference:
```ts
function greet(name) { // TypeScript infers `name` as type `any`
    return 'Hello, ' + name + '!';
}
```

#### Function Return Type with Type Inference:
```ts
function add(a, b) { // TypeScript infers return type as `number`
    return a + b;
}
```
## **Functions**
- Functions in TypeScript are blocks of code that perform specific tasks when called. 
- They can accept input values (parameters), perform operations, and return output values. 
- Functions are defined using the function keyword followed by a name, parameters in parentheses, and a body enclosed in curly braces `{}`.
#### Named Functions
- A named function is defined using the function keyword followed by the function name, parameters in parentheses, and a function body enclosed in curly braces {}.
```ts
function add(a: number, b: number): number {
    return a + b;
}
```
#### Anonymous Function
- An anonymous function is a function without a name. 
- It is typically assigned to a variable or passed as a callback function to other functions.
```typescript
let multiply = function (a: number, b: number): number {
    return a * b;
};

let result = multiply(5, 3);
console.log(result); 
```
#### Arrow Functions
- Arrow functions are a concise way to write functions in TypeScript. 
- They use the `=>` arrow syntax and can have either an expression body or a block body.
- Arrow functions with block bodies use curly braces `{}` to enclose multiple statements and have an explicit return statement.
```typescript
let subtract = (a: number, b: number): number => a - b;

let difference = subtract(10, 5);
console.log(difference); // Output: 5

```
```ts
let divide = (a: number, b: number): number => {
    if (b !== 0) {
        return a / b;
    } else {
        throw new Error('Division by zero!');
    }
};

let quotient = divide(10, 2);
console.log(quotient); // Output: 5
```


## **Parameters**
- Parameters in TypeScript are placeholders used to pass values to functions when they are called. 
- They define the input that a function expects and allow functions to be reusable with different data.
```ts
function greet(name: string): string {
    return 'Hello, ' + name + '!';
}
```
#### Optional Parameters
- Optional parameters in TypeScript allow you to define parameters that may or may not be provided when calling a function. 
- They are denoted by adding a question mark ? after the parameter name in the function declaration.
```ts
function greet(name?: string): string {
    if (name) {
        return 'Hello, ' + name + '!';
    } else {
        return 'Hello, Guest!';
    }
}
//name is an optional parameter. If a value is provided when calling greet, it will use that value; otherwise, it defaults to 'Guest'.
```

#### Default Parameters
- Default parameters in TypeScript allow you to specify default values for parameters in case no value is provided when calling a function. 
- They are specified by assigning a default value to a parameter in the function declaration.
```ts
function greetUser(name: string = 'Guest'): string {
    return 'Hello, ' + name + '!';
}

// Calling the function without providing a name
let greeting1 = greetUser(); // Default name = 'Guest'
console.log(greeting1); // Output: Hello, Guest!

// Calling the function with a custom name
let greeting2 = greetUser('John'); // Custom name = 'John'
console.log(greeting2); // Output: Hello, John!Hello, ' + name + '!';

```