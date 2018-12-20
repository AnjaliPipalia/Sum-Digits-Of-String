# Sum-Digits-Of-String

Write a program that will iterate over the input, adding the digits, and returning the result.

Input:
 - SHALL accept STDIN as the default
 - SHALL accept a file when flag [-f] is specified
 - SHALL handle hex values when flag [-x] is specified

Output:
 - SHALL output result as single Long to STDOUT
 - SHALL always output result in base 10

Examples:
```
$ java -cp "lib/junit-4.12.jar;" src/SumDigitsOfString abc123
6

$ java -cp "lib/junit-4.12.jar;" src/SumDigitsOfString -x abc123
39

$ java -cp "lib/junit-4.12.jar;" src/SumDigitsOfString abc
0

$ java -cp "lib/junit-4.12.jar;" src/SumDigitsOfString -f file.tmp
6
```

## Pre-requisites
The project requires external libraries that should be put in the 'lib' folder. More details present there.

## Compile
The Java program needs to be compiled before running. There are two classes: SumDigitsOfString.java and SumDigitsOfStringTest.java which are present in src and tests folder respectively.
To compile them, run the following commands from the root folder of the project.
```
javac -cp "lib/junit-4.12.jar;" src/SumDigitsOfString.java
```
```
javac -cp "lib/junit-4.12.jar;" tests/SumDigitsOfStringTest.java
```

## How to Run
### To run the program
```
java -cp "lib/junit-4.12.jar;" src/SumDigitsOfString abc123
```
Accepted input format:

    (1) Usage Example: './SumDigitsOfString abc123'         - To get Default Sum.
    
    (2) Usage Example: './SumDigitsOfString -x abc123'      - To get Hexadecimal Sum.
    
    (3) Usage Example: './SumDigitsOfString -f file.tmp'    - To get Sum From File.
    
    (4) Usage Example: './SumDigitsOfString -help'          - To print the help message.

### To run Unit Tests
```
java -cp lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore tests.SumDigitsOfStringTest
```