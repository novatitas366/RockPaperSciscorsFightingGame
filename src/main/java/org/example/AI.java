package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AI extends Player {
    private static String aiDifficulty;
    private int round;
    HashMap <String, Integer> player1Moves = new HashMap<>();


    public AI(int health, boolean AI, Settings settings){
        super("AI", health, AI, settings);
        aiDifficulty = settings.getAiDifficulty();
        round = 0;
    }
    public AI(AI other){
        super(other);
    }

    public String chooseAttack(){
        Random random = new Random();

        if(aiDifficulty.equals("easy")){
            int randomnumber = random.nextInt(3);
            if(currentCombo.size() == 3 && randomnumber == 0){
                currentCombo.poll();
                currentCombo.add("Fire");
                this.choice = "Fire";
                return "Fire";
            }
            else if(currentCombo.size() == 3 && randomnumber == 1){
                currentCombo.poll();
                currentCombo.add("Water");
                this.choice = "Water";
                return "Water";
            }
            else if(currentCombo.size() == 3 && randomnumber == 2){
                currentCombo.poll();
                currentCombo.add("Earth");
                this.choice = "Earth";
                return "Earth";
            }
            else if (randomnumber == 0) {
                currentCombo.add("Fire");
                this.choice = "Fire";
                return "Fire";
            } 
            else if (randomnumber == 1) {
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
        else if(aiDifficulty.equals("medium")){
            if(round == 0){
                int randomnumber = random.nextInt(3);
                if (randomnumber == 0) {
                    currentCombo.add("Fire");
                    this.choice = "Fire";
                    round++;
                    return "Fire";
                } 
                else if (randomnumber == 1) {
                    currentCombo.add("Water");
                    this.choice = "Water";
                    round++;
                    return "Water";
                } 
                else {
                    currentCombo.add("Earth");
                    this.choice = "Earth";
                    round++;
                    return "Earth";
                }
            }
            String mostUsedAttack = Collections.max(player1Moves.entrySet(), Map.Entry.comparingByValue()).getKey();
            if(mostUsedAttack.equals("Fire") && currentCombo.size() == 3){
                currentCombo.poll();
                currentCombo.add("Water");
                choice = "Water";
                return choice;
            }
            else if(mostUsedAttack.equals("Water")&& currentCombo.size() == 3){
                currentCombo.poll();
                currentCombo.add("Earth");
                choice = "Earth";
                return choice;
            }
            else if(mostUsedAttack.equals("Earth")&&currentCombo.size() == 3){
                currentCombo.poll();
                currentCombo.add("Fire");
                choice = "Fire";
                return choice;
            }
            else if(mostUsedAttack.equals("Fire")){
                currentCombo.add("Water");
                choice = "Water";
                return choice;
            }
            else if(mostUsedAttack.equals("Water")){
                currentCombo.add("Earth");
                choice = "Earth";
                return choice;
            }
            else {
                currentCombo.add("Fire");
                choice = "Fire";
                return choice;
            }
        }
        else{
            return "ERROR AI DIFFICULTY NOT FOUND";
        }
    }
    
    
    public String getAiDifficulty(){
        return aiDifficulty;
    }
    public void getplayerchoice(String choice){
        player1Moves.merge(choice, 1, Integer::sum);
    }
    public void changeAiDifficulty(int diff){
        switch(diff){
            case 1:
                aiDifficulty = "easy";
                break;
            case 2:
                aiDifficulty = "medium";
                break;
            case 3:
                aiDifficulty = "hard";
                break;
            default:
                System.out.println("this dificulty does not exist");
        }
    }

    


}
