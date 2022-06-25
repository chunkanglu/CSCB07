---
id: dpjjs6ymp97t9dglrgni4xy
title: OOP
desc: ''
updated: 1656109741214
created: 1654523702570
---


## Inheritance:
* Avoids redundancy for releted classes
```java
// Suppose Person class is defined
class Student extends Person {
  private int employeeID;
  public Employee(String name, String address, int employeeID) {
    super(name, address); // Call superclass constructor
    this.employeeID = employeeID;
  }
}
```
* Casting objects
    * Upcasting subclass to superclass
      * Person is declared type  
      * Employee is Runtime type
      * Cannot invoke methods only in subclass (eg. `p` cannot invoke purely `Employee` methods)
      * Overridden superclass methods in subclass function normally (eg. `p` can invoke methods present in both `Person` and `Employee` using the `Employee` version)

    ```java
    Person p = new Employee();
    ```
    * Downcast superclass to subclass
      * Only works if the **RUNTIME** type is the subclass

    ```java
    Employee e = (Employee)p;
    ```
    * `instanceof` Operator
      * Checks if object's runtime type is instance of some class or its superclasses
    ```java
    e instanceof Employee; // True
    e instanceof Person; // True
    ```

* Overloading 
  * Methods of same name but different signatures (eg. parameters)
  ```java
    int add(int x, int y) {
        return x+y;
    }
    double add(double x, double y) {
        return x+y;
    }
  ```

* Overriding
  * Defining method in subclass with same signature and return type of superclass
  * `@Override` annotation to specify and let compiler know we are tyring to override to catch mistakes
  ```java
  public void foo() { // Class A
    System.out.println("foo in A");
  }

  @Override
  public void foo() { // Class B extends A
    System.out.println("foo in B");

  }
  ```

* `super`
  * To invoke the superclass or its associated methods
  ```java
  public class thing extends superThing {
    ...
    public thing() {
      super(); // Calls superThing constructor
      ...
    }

    @Override
    public int doThing() {
      ...
    }

    // To explicitly call the superclass's method instead of overwritten one
    public int doSuperThing() {
      super.doThing();
    }
  }
  ```

## Object Class
  * Every class has `Object` as superclass
  * Common Methods to be overriden
    ### `equals`
      ```java
      public boolean equals(Object obj) {
        if(obj == null) return false;
        if(! (obj instanceof SomeObject)) return false;
        // We know obj is now class SomeObject or subclass of it
        // Can downcast now and compare variable or whatever suits application
        SubSomeObject s = (SubSomeObject) obj;
      }
      ```
      * Check whether calling object and argument are "the same object"
      * `equals` must be defined with respect to the application
      * General Contract (requirements)
        * Reflexive: For any non-null reference value x, x.equals(x) must return true
        * Symmetric: For any non-null reference values x and y, x.equals(y) must return true if and only if y.equals(x) returns true
        * Transitive: For any non-null reference values x, y, z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) must return true
        * Consistent: For any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false
        * For any non-null reference value x, x.equals(null) must return false
    ### `hashCode`
    ```java
    public int hashCode() {

    }
    ```
    * Overriden at the same time as `equals`
    * Equal objects **must** have equal hash codes
    * Good `hashCode` method has unequal hash codes for unequal objects
    * `hashCode` defined in `Object` just returns memory location
    ### `toString`
    ```java
    public String toString() {

    }
    ```
    * Invoked when object is printed or used in string concatenation operator
    * Usually overriden to return descriptive string representation fo object
    * `toString` in `Object` returns `classname@hashcode`

## Polymorphism
  * An object of a subclass can be used wherever its superclass is used

## Encapsulation
  * Implementation details are hidden from the user
  * Modules and methods can be used without knowing implementation
  * Advantages
    * Decoupling the modules that comprise a system allows them to be developed, tested, optimized, used, understood, and modified in isolation
    * Information hiding increases software reuse because modules that aren’t tightly coupled often prove useful in other contexts 
  * 4 levels of access
    1. **private** - The member is accessible only from the (top-level) class where it is declared
    2. **package-private** - The member is accessible from any class in the package where it is declared (default access)
    3. **protected** - The member is accessible from subclasses of the class where it is declared and from any class in the package where it is declared
    4. **public** - The member is accessible from anywhere

## Abstract Class
  ```java
  public abstract class Something
  ```
  * Cannot create instances/invoke constructor (using `new` operator)
  * Define generic class for subclasses
  * Abstract methods only in abstract classes
    ```java
    public abstract type func();
    ```
    * Defines methods that **must** be implemented in concrete subclasses
      * No specific implementation for superclass
      * Eg. computeArea() in GenericShape, you need to know which subtype for how to calculate the area

## Interfaces
* Define common behavious for classes
* Cannot instantiate objects (like abstract classes)
* Consists of constants abstract methods (no concrete methods)
* Interface methods are by default `abstract` and `public`
* Interface attributes are by default `public`, `static` and `final`
* Once a class `implements` an interface, it must override and implement all of the associated methods
```java
public interface Thing {
  public abstract String thingy();
}
```

## Generics
* Allow interface to work with a generic type
* Eg. ArrayList is a generic list that can be specificallly defined when instantiated
```java
public interface Thing<T> { // T is the placeholder for any non-primitive type (that extends Object class)
  T var;
  ...
}
public interface Thing<T> extends Superclass { // To restrict the types that can be used (only types Superclass and its subclasses are valid)
  ...
}
```
### Comparable interface
* Defines `compareTo` method for comparing objects
  * To define what and how it means to compare two objects
  * Implicitly called by other methods (Eg. the `sort` method in ArrayLists)
* Defines as:
```java
public interface Comparable<T> {
  public int compareTo(T t);
}
```
* Implementing:
```java
import java.lang.Comparable;
public class Point implements Comparable<Point> {
  ...
  @Override
  public int compareTo(Point p) {
    ...
  }
}
```

### ArrayList
* Variable length list 
```java
import java.util.ArrayList;
ArrayList<T> li = new ArrayList<T>();
```
* Common Methods:
  * `add`

### Hashset
* Doesn't allow duplicates unlike ArrayLists
```java
import java.util.HashSet;
HashSet<T> hs = new HashSet<T>();
```
* Hashed objects should override `equals` and `hashCode` for proper functionality
* Elements of set may not be in order that they are added to list 

### LinkedHashSet
* Subclass of HashSet which supports ordering of elements
```java
import java.util.LinkedHashSet;
```

## Exceptions
* Handling unexpected/error situations
* `Exception` class can be extended to provide custom Exceptions
* Unchecked exceptions
  * Compiler does not check for these and will not give warning/error if you do not specify a resolving method
  * Consists of `RuntimeException` and subclasses such as `ArrayIndexOutOfBoundsException` and `NullPointerException`
* Checked exceptions
  * Compiler forces programmer to deal with them in `try-catch` for declaration in method header
  ```java
  public type method() throws Exception {
    ...
  }
  ```
  * Can also manually throw Exceptions in code
  ```java
  if(someCondition) {
    throw new ExceptionType("Some Exception");
  }
  ```
* Try-catch
  * If Exception arises in `try` portion, it is compared with each of the `catch` portions.
  * If it does not find a suitable `catch` in this method, it recursively tries to find a `catch` portion in the method that invoked this method (aka 1 layer up the chain)
  * If no handler found, programm terminates with error message
  ```java
  try {
    thing;
  }
  catch (ExceptionType ex) {
    handle exception;
  }
  finally { // Optional
    things that will run regardless or error or not;
  }
  ```

* `throws` vs try-catch
  * If correct handler found for try-catch, then it proceeds with the `catch` portion's code and does not error terminate unless manually done
  * Different uses depending on where you want to catch Exceptions (either immediately in the current method or in a previous method)