package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;

public class Player {
    private String name;
    private int health;
    private String choice;
    private static Queue <String> currentCombo = new LinkedList<>();
    Map <String, Integer> damageValues = new HashMap<>();
    


    public Player(String name, int health, boolean AI){
        if(AI){
            this.name = "AI";
            this.health = health;
        }
        else if(!AI){
            this.name = name;
            this.health = health;
        }
        this.choice = "***";

        damageValues.put("Fire", 10);
        damageValues.put("Water", 10);
        damageValues.put("Earth", 10);
    }
    public int gethealth(){
        return health;
    }

    public void getCombo(){
        currentCombo.add("Fire");
        System.out.println(currentCombo.peek());
    };
    public String getChoice() {
        return choice;
    }
    public String getName() {
        return name;
    }
    public String chooseAttack(int choice) {
        
            if (choice == 1) {
                currentCombo.add("Fire");
                this.choice = "Fire";
                return "Fire";
            } else if (choice == 2) {
                currentCombo.add("Water");
                this.choice = "Water";
                return "Water";
            } 
            else {
                currentCombo.add("Earth");
                this.choice = "Earth";
                return "Earth";
            }
            
        
    }

    public int damageHealth(String choice){
        if(this.choice == "Fire" && choice == "Water"){
            int damage = damageValues.get(choice);
            this.health = this.health - damage;
            return damage;
        }
        else if(this.choice == "Water" && choice == "Earth"){
            int damage = damageValues.get(choice);
            this.health = this.health - damage;
            return damage;
        }
        else if(this.choice == "Earth" && choice == "Fire"){
            int damage = damageValues.get(choice);
            this.health = this.health - damage;
            return damage;
        }
        else{
            return 0;
        }

    }
}
