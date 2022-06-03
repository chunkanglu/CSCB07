---
id: ozns89lobae39y8k35w5uhz
title: Intro to Java
desc: ''
updated: 1653919851836
created: 1652708698550
---
Create java file and write into it  
`javac [FILENAME].java` outputs a `[FILENAME].class`  
`java [FILENAME]`

## Static
* Shared variable/method shared with all objects of the class
  * Static methods cannot access instance fields (only works when passed in as parameter)
* Non-static varaibles are called instance fields

## Arrays
* `type[] arr = new type[size]` or with set items `type[] arr = {item1, item2, ...}`
* eg. `int[] A = new int[1000]` creates array of size 1000
* `arr.length` for length of array
* **NOTE:** this works: `return new int[]{1, 2, 3}` , this doesn't: `return {1, 2, 3}` 
* 2-d arrays: ` int [][] arr;`
  * With init: `int [][] arr = {{thing1, ...}, {item1,...}, ...}`
  * `arr.length` would show length of first dimension (rows in this case)

## For loop/For each loop
```java 
for (int i=0; i < 100; i++){
    thing
}

for(int i: Array){
    thing
}
```
