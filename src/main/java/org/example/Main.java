package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import org.example.Combo.combo;

public class Main {
    public static void main(String[] args) {
        
        Gson gson = new Gson();
        Menu menu = new Menu();
        LinkedList<combo> Combos = null;
        try (FileReader reader = new FileReader("src/main/java/org/example/Json/combos.json")) {

            Type personListType = new TypeToken<List<combo>>() {
            }.getType();

            List<combo> tempPeople = gson.fromJson(reader, personListType);
            Combos = new LinkedList<>(tempPeople);
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }
        
        menu.ShowMenu(Combos);

    }
}