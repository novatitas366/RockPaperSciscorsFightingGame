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
        LinkedList<History> history= null; 
        LinkedList<combo> Combos = null;
        
        try (FileReader reader = new FileReader("src/main/java/org/example/Json/combos.json")) {

            Type comboListType = new TypeToken<List<combo>>() {
            }.getType();

            List<combo> tempCombos = gson.fromJson(reader, comboListType);
            Combos = new LinkedList<>(tempCombos);
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        }

        try(FileReader reader = new FileReader("src/main/java/org/example/Json/history.json")){
           Type historyListType = new TypeToken<List<History>>() {
            }.getType();
            List<History> temphistories = gson.fromJson(reader, historyListType);
            if(temphistories == null){
                history = new LinkedList<>();  
            }
            else{
                history = new LinkedList<>(temphistories);
            }  
        }catch(JsonSyntaxException | JsonIOException | IOException e){
            e.printStackTrace();
        }
        menu.ShowMenu(Combos, history);

    }
}