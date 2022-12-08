# APCS Final

This is my APCS midterm final. My task is to create a PLTW-like activity to teach future students a topic. The one I have chosen is `ArrayList`s.

## ArrayLists

> Note: you need to understand java arrays before learning about ArrayLists

### Helpful Resources
Official documentation for ArrayLists: https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html

### Overview

The ArrayList is essentially your boring java array on steroids. This utility class allows you add and delete values to your heart's content.

### Importing
``` java
// At the top of your file...
import java.util.ArrayList;
```

#### Creation
You create an `ArrayList` pretty much like any other java reference type.

```java
// After the type name (in our case, ArrayList), a type is required between the angle brackets. 
// If none is given, the type given is assumed to be plain old Object
ArrayList<String> myArrayListOfStrings = new ArrayList<String>();
```

The type given to the ArrayList is the type of object that it can store. In the case above, `myArrayListOfStrings` can only store Strings. Java will throw an exception or give you a compiler error if you try to add an object of any other type.

```java
// Or shorter
ArrayList<String> myArrayListOfStrings = new ArrayList<>();
```

As you can see, the type between the angle brackets is optional if you specify it on the left of the `=` sign

#### Adding values
To add values to an `ArrayList`, just use the `add` method
```java
ArrayList<String> myArrayListOfStrings = new ArrayList<>();
myArrayListOfStrings.add("I really like array lists");
```

#### Retrieving values
To get values at specific indices in the ArrayList, use the `get` method.
```java
ArrayList<String> myArrayListOfStrings = new ArrayList<>();
myArrayListOfStrings.add("I really like array lists");
System.out.println(myArrayListOfStrings.get(0)); // output:I really like array lists
```

#### Getting the number of values stored
To get the length of an ArrayList, use the `size` method.

```java
ArrayList<String> myArrayListOfStrings = new ArrayList<>();
myArrayListOfStrings.add("I really like array lists");
myArrayListOfStrings.add("I really like array lists");
myArrayListOfStrings.add("I really like array lists");

System.out.println(myArrayListOfStrings.size()); // output: 3
```

#### Traversal
To go over all of the items in an array list, use a `for` loop

```java
ArrayList<String> myArrayListOfStrings = new ArrayList<>();

...

for(int i = 0; i < myArrayListOfStrings.size(); i++) {
    System.out.println(myArrayListOfStrings.get(i));
}

```

Or, if you don't need the current index of the for loop, use a range-for

```java
// Same as the example above. Iterates over every string in the ArrayList
for(String str : myArrayListOfStrings) {
    System.out.println(str);
}
```

#### Deletion
Use `boolean delete(Object o)` to delete an equivelent object in the list (eg. `objectInList.equals(o))`. This returns true if the object given is found removed from the list.

Use `delete(int index)` to delete an object at the given index. Returns the removed object.


#### Replacement
Use `set(int index, T value)` where `index` is the index of the object in the `ArrayList<T>` to replace with `value`

## Task
1. At the bottom of the `StudentRosterTemplate.java` file, create an ArrayList of type student called `students`

2. Implement the method `deleteStudent(int index)`. This method should delete the given student out of `students`. Be sure to print out a message to the user if the index is invalid.

3. Implement the method `deleteStudent(String name)`. This method should delete a student from `students` by their name. Be sure to print out a message to the user if the input is invalid (for example, if the name does not exist in `students`)

4. Implement the method `addStudent(String name)`. This method should add a student to `students` with the name `name`.

5. Implment the method `listStudents()`. This method should print out the students and their indices in `students` to the user. Be sure to tell the user if the roster is empty

6. **BONUS**. Implement a `RENAME` command which will change the name of the student given the current name or index in `students`