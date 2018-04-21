package com.epam.mentoring.module04;

public class Main {

    public static void main(String[] args) {

        // 1. Java virtual machine
        // Specification: https://docs.oracle.com/javase/specs/index.html
        // Implementation

        // Java compiler generates specific byte code (*.java file -> *.class file) ('javac' in command line)
        // JVM takes this byte code and executes ('java' in command line)

        // The main implementation of JVM is HotSpot by Oracle
        // More JVMs: OpenJ9, Doppio, SAPJVM etc.

        // JVM languages:
        // Java, Scala, Groovy, Fantom, Clojure, Kotlin etc.

        // Classloader subsystem

        // Runtime data areas:
        // 1. Method area (class data, static blocks, static variables, references, run-time constant pool)
        // 2. Heap (objects, arrays)
        // 3. Java threads (method calls, local variables)
        // 4. Program counter registers (each stack has each own program counter,
        //          contains the address of current instruction)
        // 5. Native internal threads

        // JVM options:
        // Heap size: -Xmx10m (10 MB for Heap)

        // Native method interface

        // Execution engine:
        // 1. JIT compiler
        // 2. Garbage collector

        // 2. Garbage Collector

        // 2.1 Object reachability (if an object can be reached from a root)
        // Garbage are unreachable objects

        // 2.2 Generations
        // 2.3 Roots (the root set)
        // 2.4 Surviving
        // 2.5 Full GC

        // Memory management:
        // - Reference counting
        // - Tracing collectors (reachable / unreachable)
        // - Generational collectors (infant mortality)

        // Heap problems: fragmenting and compacting

        // 3. Method area

        // It is all about HotSpot JVM
        // Before Java 8: Perm Gen was a part of Heap
        // From Java 8: Perm Gen does not exist. But Metaspace appeared in Native Memory.

        // Weak generational hypothesis
        // Most objects died young
        // Old objects rarely reference young objects
        // Separate young and old objects in Heap
        // Old objects are objects that survived after several garbage collector sessions

        // Heap is divided: Young Generation and Old (Tenured) Generation (YoungSize < OldSize usually)
        // Young Generation is divided: EdenSpace, Survivor1 (FromSpace) and Survivor2 (ToSpace)
        // Eden for new objects, can be divided by threads but edges are smooth.
        // Survivors contain objects after few garbage collector sessions

        // 4. Classloading
        ClassLoader classLoader = Main.class.getClassLoader();

        // Class search. Where?:
        // - JRE folder
        // - classpath
        // - auto-generated on the fly (proxy, reflection, invoke dynamic implementation)
        // - direct classes of application

        // Classloaders:
        // - bootstrap class loader (classes that return null after call of getClassLoader(), usually loaded by
        //      bootstrap class loader);
        // - extension class loader;
        // - system class loader (loads classes from classpath);
        // - user-defined class loaders;

    }
}
