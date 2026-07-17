# Core Java Solutions

This folder contains Java source files for the 41 Core Java exercises.

Most files can be compiled with:

```bash
javac src/01_HelloWorld.java
java -cp src HelloWorld
```

Notes:

- `30_PatternMatchingSwitch.java` and `40_VirtualThreads.java` require Java 21.
- JDBC examples require a MySQL JDBC driver at runtime and matching local databases/tables.
- Exercise 34 is in the `modules` folder because it needs Java module descriptors.
- Exercise 37 can be inspected with `javap -c BytecodeExample` after compilation.
- Exercise 38 is intended to be opened in a decompiler such as JD-GUI or CFR after compilation.
