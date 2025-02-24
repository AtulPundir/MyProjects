package com.ap.pre.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
try-with-resources is a specialized try block in Java that automatically closes resources (e.g., files, sockets, database connections) when the block exits.
It was introduced in Java 7 and works with any class that implements AutoCloseable or Closeable.
*/

class Resource implements AutoCloseable {
    public void use() { 
        System.out.println("Using resource..."); 
    }

    @Override
    public void close() { 
        System.out.println("Resource closed!"); 
    }
}

public class TryWithResourceExample {
    public static void main(String[] args) {
        try (Resource res = new Resource()) {
            res.use();
            System.out.println("Returned");
        }
        // res.close() is called automatically here!

        try (
            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr)
            )  {
                 System.out.println(br.readLine());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        // fr.close() and br.close() are automatically called!
    }

}


/*
 * 
 O/P
Using resource...
Resource closed!
 * 
 * 
 */
