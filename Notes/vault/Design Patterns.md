---
id: p470k900evu4xt8gg136cg0
title: Design Patterns
desc: ''
updated: 1657551137873
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

![](2022-07-11-10-34-15.png)

### Facade (Structural)
* Hide complexities of code and provide unified interface for set of interfaces in subsystem
* Interface for clients should be kept simple

![](2022-07-11-10-50-00.png)

### Adapter (Structural)
* Let classes of incompatible interfaces work together that couldn't otherwise
* Used when we have existing implementations that don't fit together but is too costly to reimplement

![](2022-07-11-10-50-25.png)