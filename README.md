## Introduction

This assignment is aboute writing an analytics tool for such Moodle quizzes/tests. All personal information like names and email addresses and replaced Student IDs with randomized IDs.

The data is already read from the csv file into an array of Strings (`records`) and integers (`weights`), such that,

- each String in array `records` holds the line representing a single test attempt (comma-separated). So,
- `records[0]` holds the first attempt (row 2 in the csv, since header is skipped).
- `records[1]` holds the second attempt, 
- and so on.
- each item in array `weights` holds the weight of the questions. So, 
- `weights[0]` holds the number of marks for question 1, 
- `weights[1]` holds the number of marks for question 2, 
- and so on.

## Your friends

You have the following friends for this assignment,

1. `split(delimiter)`: Operates on a String object. Splits the String on the delimiter passed. Some examples,

```java
String s = "this is cool";
String[] t = s.split(" "); //t = ["this", "is", "", "", "", "", "", "cool"]
String[] v = s.split(" +"); //t = ["this", "is", "cool"] since split on one or more spaces

String a = "ready, steady, go";
String[] b = a.split(","); //b = ["ready ", "steady ", "go "]
String[] c = a.split(", "); //split on comma AND space
//c = ["ready", "steady", "go"]
```

2. `Integer.parseInt(String)`: This is a class method operating on `Integer` class, and converts the passed String to an integer. If the passed value cannot be converted (for example, "hello!", it throws a `NumberFormatException`). Some examples,

```java
String s = "90210";
int t = Integer.parseInt(s); //t = 90210

String x = "POTUS in a bicycle accident";
String y = Integer.parseInt(x); //throws NumberFormatException

String a = "1.25";
int b = Integer.parseInt(a); //throws NumberFormatException
double c = Double.parseDouble(a); //c = 1.25
```

3. `String.equals(String)`: You can compare if two Strings are identical using the `equals` method (and NOT `==` operator). Some examples,

```
String s = new String("super");
String t = new String("super");
boolean a = (s==t); //a is false
boolean b = (s.equals(t)); //b is true
```

With the help of these, you can split an item of `records[i]` (`i` being the index) on comma AND space to get each individual token, and then, if required, convert it to integer using `Integer.parseInt`.

We have also provided an implementation of `countZeroes` as a sample (*"How good is that!" - ScoMo*).

## Starting point

Starting point is provided in the [template attached](https://ilearn.mq.edu.au/pluginfile.php/6098883/mod_assign/introattachment/0/assignment1template.zip?forcedownload=1).

## `records` and `weights` are available in each method

Since you are writing the instance methods in class `Analytics`, please note that the arrays `records` and `weights` are available in each of the methods, and are pre-populated through the `setup` method of `AnalyticsTest` that runs before running each test. You don't need to pass them as parameters.

**You should NOT modify the contents of these arrays.**

## File reading data

The file `DataReader.java` is responsible to read the data and populate arrays `records` and `weights`, through the constructor `Analytics(String)`. This file (`DataReader.java`) should not be modified. 


## Test file

The JUnit tests are in `AnalyticsTest.java` and this file should NOT be modified.
