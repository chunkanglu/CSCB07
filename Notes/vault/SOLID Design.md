---
id: m65rej84ydj5xhozc4kpmmt
title: SOLID Design
desc: ''
updated: 1657549249268
created: 1656944364836
---
## Single Responsibility Principle
> A class should only *"do one thing"* or *"have the same theme"*

| ![](2022-07-04-10-36-18.png) | Graphical responsibility of drawing, but also Computational responsibility for calculating area |
|---|---|
| ![](2022-07-04-10-42-20.png) | **Splitting into 2 classes of Geometric Rectangle and Rectangle so each class has own single purpose** |

* Violation requires compiling GUI to compile for Computational Geometry Application

## Open/Closed Principle
> Software enitites (classes, modules, functions, ...) should be created so that new features can be done through extension (like a sub-class) rather than modification of the original code

* Avoid modifying existing code (eg. classes, interfaces, ...)
    * Can create dependency problems
* Write code with the expectation that it won't be changed
* Use interfaces (as parameters) to allow us to define specific variations of the interface to add additional features
    * `interface calculator` with implementations `calcAdd` and `calcMultiply`
    * Pass `calculator` as parameter

## Liskow Substitution Principle
> Properties that apply to objects of a superclass should also apply to objects of each subclass

* You can use a subclass in place of a superclass without breaking anything
* If you need to make a drastic change in behaviour of an overridden method (eg. just throwing exception or empty implementation), it may be violating LSP

## Interface Segregation Principle
> Interfaces should include common and cohesive methods that should be shared by all the classes (so that dummy or useless implementations unneeded)



## Dependency Inversion Principle
> Make sure that abstractions do not depend on concrete items, while concrete items depend on abstractions

* If abstractions depend on a concrete item, it makes it difficult to use in different contexts (like how an abstraction should be used)
    * Possible fix is to use an abstract (generic-ish) version of the concrete item
* High level modules (overarching controllers) should not require low level modules (things being controlled)

# Design Smells
* Consequences of poor design, usually caused by violation of design principles
1. Regidity
    * Code is hard to change
    * If you change, something else breaks
    * Fail SRP, OCP, or DIP
2. Fragility
    * Easy to break (due to valid but wrong assumptions)
    * Fail LSP, ISP, SRP
3. Immobility
    * Hard to reuse
    * Fail DIP
4. Viscosity
    * Easier to do the "wrong" thing (hacking the design) than the "right" thing (to conform to your design)
    * Fail ISP
5. Needless Complexity
    * Overdoing to try and fit in design principles
6. Needless repetition
    * Mouse abuse (lots of copy pasting/repetition)
7. Opacity
    * Readability/organization of code
    * Fixed by refactoring and code reviews