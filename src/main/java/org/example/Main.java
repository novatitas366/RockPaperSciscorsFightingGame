package org.example;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.Menu.SettingsMenu;


public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Game game = new Game();
        SettingsMenu setmenu = new SettingsMenu();
        Gson gson = new Gson();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        try{
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e){
            System.err.println("error registering native hook: " + e.getMessage());
            System.exit(1);
        }
        // try (FileReader reader = new FileReader("src/main/java/org/example/Json/combos.json")) {
        //     person = gson.fromJson(reader, Test.Person.class);
        // } catch (JsonSyntaxException | JsonIOException | IOException e) {
        //     e.printStackTrace();
        // }
        GlobalScreen.addNativeKeyListener(menu);
        GlobalScreen.addNativeKeyListener(game);
        menu.ShowMenu();

        
        
        
    }
}