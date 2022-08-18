---
id: p470k900evu4xt8gg136cg0
title: Design Patterns
desc: ''
updated: 1660432527283
created: 1657549300026
---
## What
* General solutions (heuristics) that can be used to solve similar problems
* 3 Categories
    * Creational
        * For object creation
    * Structural
        * Structure of code
    * Behavioural
        * How code behaves

## Examples
### Singleton (Creational)
* Ensure only one global instance for a class
* final class (prevent extension), Private instance, private constructor (prevent use of new` and new instances), public method  

* hard to change to not singleton

![](2022-07-11-10-27-50.png)
```java
final class Manager {
    private static Manager manager;
    private Manager() {
        ...
    }
    public static Manager getInstance() {
        if(manager == null) {
            manager = new Manager();
        }
        return manager;
    }
}
```

### Factory Method (Creational)
* Interface for creating an object, but subclasses can decide which class to instantiate
* Conforms to DIP

* Encapsulate instantiation of a new object so that it is uniform across the whole program
    * useful if instantiating new object requires more than just `new` keyword (eg. random creation)
    * special business to determine what type of object to create
    * for polymorphism to maybe even swap around factories in a method

* Instead of a lot of different classes, factory allows for a few key classes that can be modified through logic and input parameters which allow for more dynamic creation of classes and subclasses

* Separate creation from utilization
* For when a method returns some class out of many subclasses that share the same superclass
* Allows for creation of classes using information you don't know beforehand (such as at run time as user enters which type to create)
* when you don't want the user to know the individual subclasses (but are able to interact with it's API for selection)

```java
public abstract class Item {
    public abstract void doThing();
}

public class ItemA extends Item {
    public ItemA() {}

    @Override
    public void doThing() {
        System.out.println("ItemA doThing");
    }
}

public class ItemB extends Item {
    public ItemB() {}

    @Override
    public void doThing() {
        System.out.println("ItemB doThing");
    }
}

public class ItemC extends Item {
    public ItemC() {}

    @Override
    public void doThing() {
        System.out.println("ItemC doThing");
    }
}

public abstract class ItemFactory {
    public abstract Item getItem1(); 
    public abstract Item getItem2();
}

public class Combo1 extends ItemFactory {
    @Override
    public Item getItem1() {
        return new ItemA();
    }
    @Override
    public Item getItem2() {
        return new ItemB();
    }
}

public class Combo2 extends ItemFactory {
    @Override
    public Item getItem1() {
        return new ItemB();
    }
    @Override
    public Item getItem2() {
        return new ItemC();
    }
}

class Main {
    public static ItemFactory chooseFactory(String facName) {
        if(facName.equals("Combo1")) return Combo1;
        else if(facName.equals("Combo2")) return Combo2;
    }
    
    public static void main(String[] args) {
        String facName = // Scanner input stuff
        ItemFactory f = chooseFactory(facName);
        Item i1 = f.getItem1();
        Item i2 = f.getItem2();
        
        i1.doThing();
        i2.doThing();
    }
}
```
* What makes factory special is that you can add logic inside the `Combo` classes' functions to specify **how or what** (with eg. special parameters) `Item`s are created 
* [Another Example in C\#](https://www.dofactory.com/net/factory-method-design-pattern)


![](2022-07-11-10-34-15.png)

### Facade (Structural)
* Hide complexities of code and provide unified interface for set of interfaces in subsystem
* Interface for client (developers) should be kept simpler

* When following Single Responsibility Principle, you may end up with a lot of different classes where each do their own thing
* this facade serves as a way to group things together so that the client developer doesn't need to worry about the intricacies of how things are interacting if they don't need to

* Example of using a UI instead of eg. entering commands directly

![](2022-07-11-10-50-00.png)

### Adapter (Structural)
* Let classes of incompatible interfaces work together that couldn't otherwise
* Used when we have existing implementations that don't fit together but is too costly to reimplement

* Client wants to use incompatible method
    * Client has an interface field and calls interface's adapter method
* Interface has abstract method for adapter
* Concrete adapter implements interface and makes the client's actions compatible to the adaptee method
    * concrete adapter calls and uses adaptee in some way and adds other logic to change it to what client wants
```java
class Client {
    private IAdapter adapter;
    public Client(IAdapter adapter) {
        this.adapter = adapter;
    }
    public void doThing() {
        this.adapter.doSomething(some parameters);
    }
}
class Adaptee {
    public Adaptee() {}
    public void doSomethingElse(some stuff) {
        ...
    }
}
interface IAdapter {
    void doSomething(some parameters);
}
class Adapter implements IAdapter {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void doSomething(some parameters) {
        // bridge and call adaptee.doSomethinElse(...) somehow
    }
}
```

![](2022-07-11-10-50-25.png)

### Observer (Behavioral)
* split into observer and observee interfaces
* observee should have some list of observers with functions `add()`, `remove()`, and `notify()`
    * notify sends signal that observer can retrieve info now
    * observee should have some function to allow observer to get updated info when `update()` called
* observer should have some `update()` which is called whenever the observee uses `notify()`
    * observer should store the instance of their observee to obtain updated info
```java
class Student {
    String name;
    Course course;
    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
        this.course.addStudent(this);
    }
    public void displayExamDate() {
        System.out.println(course.examDate);
    }
}

class Course {
    List<Student> students;
    Date examDate; // Suppose Date is already defined
    public Course() {
        students = new ArrayList<Student>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void scheduleExam(Date examDate) {
        this.examDate = examDate;
        for(Student s: students) {
            s.displayExamDate();
        }
    }
}
```

### Strategy (Behavioral)
* Defining a family of algorithms that can be swapped and used
* Context uses Strategy as field/parameter, where concrete implementations of the Strategy can be swapped and interchangably used
* Uses open-closed principle
* Eg. a class uses a sorting algorithm (strategy) which should be some interface, where concrete implementations (different sorting algorithms) can be swapped and used 

* You have a class with some function but different instances of this class may do different things within this function
* In order to have different behaviours, you should be able to swap the existing functionality with another
* create an abstract interface to serve as the "general form" of this function
    * implementations of this interface serve as the different types of functionality that can be swapped around
```java
public interface DoThingStrategy {
    void doThing();
}

public class DoThing1 implements DoThingStrategy {
    public DoThing1() {}
    
    @Override
    public void doThing() {
        System.out.println("I did a thing");
    }
}

public class DoThing2 implements DoThingStrategy {
    public DoThing2() {}

    @Override
    public void doThing() {
        System.out.println("I did another thing");
    }
}

public class thing {
    private DoThingStrategy doesThing;
    public void thing(DoesThingStrategy doesThing) {
        this.doesThing = doesThing;
    }
}
```
* Now in `main` one could instantiate a `thing` object with with either `DoThing#` to provide different functionality