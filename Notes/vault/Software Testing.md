---
id: jch4sbrt3cqff7unuzdwycl
title: Software Testing
desc: ''
updated: 1657722431546
created: 1656290974219
---

## What is Software Testing
* Running a program to find faults

## Testing Levels (From highest to lowest)
1. Acceptance testing: whether software is acceptable to user
2. System testing: overall functionality of system
3. Integration testing: how modules interact with each other
4. Module testing: how modules perform in isolation and how module components interact with each other
5. Unit testing: individual units

**Module and Unit testing are programmer's responsibility**

## Black/White Box Testing
* Black-Box: testing software without knowing its code/structure
    * Allows for people who didn't write the code to test it
* White-box: testing while knowing the source code
    * Must be done by one of the programmers

## Why is it Hard
* Exhaustive testing is not practical/possible (in most cases)
* Random/statistical testing is not effective
* Formal verification is possible but only on some types of code which can be modeled mathematically and proved (but not practical and scalable to any piece of code)

## Why Test
* Software is everywhere and failures can have severe consequences

## Fault/Error/Failure
* Fault - problem in code
* Error - incorrect state of program due to a fault
* Failure - incorrect result of the program (with respect to the expected behaviour)

## RIPR Model
* 4 contitions for a test to observe program failure
1. **Reachability:** test must reach location in the program that contains the fault
2. **Infection:** After faulty location is executed, state of program must be incorrect
3. **Propagation:** Infected (wrong) state propagate through rest of program, causing incorrect output/final state
4. **Revealability:** Tester must observe the incorrect portion of the final program state


## Criteria-based Test Design
### Coverage Criterion
* Rules/Criteria that describe the extent of the testing
* Allow us to judge/evaluate the quality of our testing
* statement/branch coverage

### Graph Coverage
* Software models as graph where nodes and edges represent statements and branches
* Coverage criteria defined based on graph (eg. cover every node/edge/path)
* Branch coverage check all edges
* 100% branch coverage implies 100% node coverage (**opposite not always true**)

### Logic Coverage
* Involes boolean expressions
* Predicate coverage
    * test set includes evaluation to `true` and `false`
    * `((a>b) || c) && (x<y)` where whole thing evals to `true`/`false`
* Clause coverage
    * evals each clause to `true`/`false`
    * Each part of `(a>b)`, `c`, `(x<y)` evals to T/F
    * But problem, suppose predicate (x || y)
        * test 1: T F
        * test 2: T T
        * achieved clause coverage for y, but no matter what the predicate is still true
* 100% predicate coverage **DOES NOT** mean 100% clause coverage and vice versa
* Active clause coverage
    * 2 cases, clause is T and determines predicate, clause is F and determines predicate 
    * Select one clause to check (major clause) and fix the other clauses for each test case (minor clauses), see if flipping the major clause changes predicate
* 100% active clause coverage means 100% clause coverage
* Inactive clause coverage
    * Certain major clause does not affect predicate
    * Whether major clause is T or F, it doesn't change the predicate

## Test Oracles
* Set of conditions that denote if result of test is correct 
    * eg. `assertTrue`/`assertFalse` in JUnit, comparing expected and actual results
Must balance between too many and too little checks (as comprehensive as possible without going overboard)
* How to determine what are correct results?
    * Specification based direct verification of outputs
        * Written critera that results must follow (can be hard to write)
    * Redundant computations
        * Use another trustworthy program as a baseline  