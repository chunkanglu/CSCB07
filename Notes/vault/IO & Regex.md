---
id: ohop9gc7yunj2jq11mv4kyt
title: IO & Regex
desc: ''
updated: 1656174786802
created: 1653916159223
---

## Analyzing System.out.println()
* `System` the class
* `out` static attribute
* `println()` the method defined on class of `out` (PrintStream)

## System.in
* Object of type **InputStream**
* refers to keyboard-type input
* Use class `Scanner` to read keyboard input
  ```java
    import java.util.Scanner;
    Scanner scan = new Scanner(System.in);
    String str = scan.next(); // Reads everything until it reaches whitespace
    String str = scan.nextLine(); // Reads next line
    int i = scan.nextInt() // Reads next integer, errors on strings
  ```

## File class
```java
  import java.io.File;
  File f = new File("PATH");

  f.exists();
  f.isDirectory();
  f.getName();
  f.createNewFile();
  File[] files = f.listFiles(); // Works if directory

  // Read from file (with text)
  import java.io.BufferedReader;
  BufferedReader b = new Bufferedreader(new FileReader("PATH"));
  String str = b.readLine();
  while(str != null) {
    System.out.println(str);
    str = b.readLine();
  }
  // Readline returns null when reaches end

  // Writing files
  import java.io.FileWriter;
  FileWriter output  = new FileWriter(filename, append[true/false]); // if append false, it overwrites
  //eg
  FileWriter fw = new FileWriter("PATH", true);)
  fw.write("thing");
  fw.close();

  // Alt writing files
  import java.io.PrintStream;
  PrintStream ps = new PrintStream("PATH");
  ps.println("thing");
  ps.close();
```

## Regex
```java
import java.util.regex;
// Pattern class to define regex pattern
Pattern pattern = Pattern.compile("PATTERN");
// Matcher class to perform search
Matcher matcher = pattern.matcher("TEXT");

matcher.matches(); // Tries to match whole string
matcher.find(); // Can match substring

// if pattern is "H.*d", then matches would fail on "0Hello World0"
// but find would return true

// TO match phone numbers of format (xxx) xxx-xxxx
// Normal regex would be: \(\d{3}\)\s?\d{3}-\d{4}
// For Java, each \ must be replaced with \\ 
//                        \\(\\d{3}\\)\\s?\\d{3}-\\d{4}


```