package org.example;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class Player {
    private String name;
    private int health;
    private String choice;
    private Queue <String> currentCombo = new LinkedList<>();
    private Map <String, Integer> damageValues = new HashMap<>();
    

    public Queue<String> getCurrentCombo() {
        return currentCombo;
    }
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

    public Player(Player other){
        this.health = other.health;
        this.name = other.name;
        this.choice = other.choice;
        this.damageValues = other.damageValues;
        this.currentCombo = other.currentCombo;
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
            if(currentCombo.size() == 3 && choice == 1){
                currentCombo.poll();
                currentCombo.add("Fire");
                this.choice = "Fire";
                return "Fire";
            }
            else if(currentCombo.size() == 3 && choice == 2){
                currentCombo.poll();
                currentCombo.add("Water");
                this.choice = "Water";
                return "Water";
            }
            else if(currentCombo.size() == 3 && choice == 3){
                currentCombo.poll();
                currentCombo.add("Earth");
                this.choice = "Earth";
                return "Earth";
            }
            else if (choice == 1) {
                currentCombo.add("Fire");
                this.choice = "Fire";
                return "Fire";
            } 
            else if (choice == 2) {
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

    public int checkIfCombo(LinkedList<Combo.combo> Combos){
        boolean check = true;
        int index = 0;
        System.out.println(getCurrentCombo().size());
        if(getCurrentCombo().size() != 3){
            return -2;
        }
        for(Combo.combo combo: Combos){
            Queue <String> tempCombo = new LinkedList<>(getCurrentCombo());
            check = true;
            String attack1 = combo.getAttack1();
            String attack2 = combo.getAttack2();
            String attack3 = combo.getAttack3();

            for(int i = 1; i<=3; i++ ){
                if(i == 1 && !tempCombo.peek().equals(attack1)){
                    check = false;
                }
                else if(i == 2 && !tempCombo.peek().equals(attack2)){
                    check = false;
                }
                else if(i == 3 && !tempCombo.peek().equals(attack3)){
                    check = false;
                }
                tempCombo.poll();
            }
           if(check == true){
                break;
           }
            index++;

        }
        if(check == false){
            return -1;
        }
        else{
            return index;
        }
    }
    
    //make them deal damage

    public int dealDamage(String choice, LinkedList<Combo.combo> Combos){
        int index = checkIfCombo(Combos);
        if(index != -1 && index != -2 && this.choice == "Fire" && choice == "Earth"){
            int damage = Combos.get(index).getComboDamage();
            return damage;
        }
        else if(index != -1 && index != -2 && this.choice == "Water" && choice == "Fire"){
            int damage = Combos.get(index).getComboDamage();
            return damage;
        }
        else if(index != -1 && index != -2 && this.choice == "Earth" && choice == "Water"){
            int damage = Combos.get(index).getComboDamage();
            return damage;
        }
        else if(this.choice == "Fire" && choice == "Earth"){
            int damage = damageValues.get(choice);
            return damage;
        }
        else if(this.choice == "Water" && choice == "Fire"){
            int damage = damageValues.get(choice);
            return damage;
        }
        else if(this.choice == "Earth" && choice == "Water"){
            int damage = damageValues.get(choice);
            return damage;
        }
        else{
            return 0;
        }
    };


    public String damageHealth(int damage){
        if(damage == damageValues.get("Fire")){
            this.health -= damage;
            return "Basic";
        }
        else if(damage == 0){
            this.health -= damage;
            return "Zero";
        }
        else if(damage != damageValues.get("Fire")){
            this.health -= damage;
            return "Combo";
        }
        else {
            return "praso";
        }
        
    }   
}
