# ESEP Data Processing

A simple key-value database for an assignment in my Enterprise Software Engineering Practices class.

## Setup

1. Ensure you have Java installed. I used Java 11.
2. `cd` into the `src` directory.
3. Run `javac *.java` to compile the Java files.
4. Run `java Program` to run the program.

## Information for Graders

I have implemented the `KeyValDatabase` interface in the `KeyValDatabase.java` file.
If you are interested in testing it out, you can run the program by following the instructions in the `Setup` section. The program provides a command-line interface for interacting with the database.

## Additional Feedback

The return type for the `get` method in the `InMemoryDB` interface needed to be changed from `int` to `Integer` due to the fact that the method can return `null`. I have made this change in the `InMemoryDB.java` file.

Consider putting limitations on the programming language used for the assignment.
Most students are familiar with Python and C++ from the programming fundamentals courses.
You can choose a different programming language if you would like to challenge the students.
Enforcing this limitation can make it easier to grade the assignment for functionality. This includes making test cases for the assignment.

Make test cases for the assignment if possible. Test cases make it easier to grade the assignment for functionality. It becomes even easier if the interface is provided to the students. If tests cases are made, make a select few of them public to the students. This will help them understand what is expected of them.
