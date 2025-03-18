FizzBuzz Program

Description
This is a simple Java program that implements the classic FizzBuzz game. It takes three command-line arguments:
- The first number represents the Fizz condition.
- The second number represents the Buzz condition.
- The third number specifies the upper limit up to which the FizzBuzz logic will be applied.

The program prints:
- "Fizz" if the number is divisible by the first argument.
- "Buzz" if the number is divisible by the second argument.
- "FizzBuzz" if the number is divisible by both.
- Otherwise, it prints the number itself.

Usage

1. Compilation
To compile the program, run the following command:
```
javac FizzBuzz.java
```

2. Execution
To run the program, provide three command-line arguments:
```
java FizzBuzz <Fizz_Number> <Buzz_Number> <Range>
```
For example:
```
java FizzBuzz 3 5 15
```

Output for the Above Example:
```
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
```

Example Scenarios
Command                        Output
---------------------------------------------
java FizzBuzz 2 4 10         1, Fizz, 3, FizzBuzz, 5, Fizz, 7, FizzBuzz, 9, Fizz
java FizzBuzz 7 11 50        (Numbers, "Fizz", "Buzz", and "FizzBuzz" where applicable)

Error Handling
- If the user does not provide exactly three arguments, the program prints:
```
Please provide exactly 3 command-line arguments.
```
- If the arguments cannot be parsed as integers, a NumberFormatException will be thrown.

Author
Utshab Niraula

