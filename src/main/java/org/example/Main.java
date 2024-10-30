package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        LinkedList<Integer> list = new LinkedList<>();
        list.
        try (FileReader reader = new FileReader("src/main/java/org/example/data.json")) {
            Person person = gson.fromJson(reader, Person.class);
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Email: " + person.getEmail());
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }

        
    }
}