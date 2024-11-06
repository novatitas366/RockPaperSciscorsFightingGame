package org.example;

import java.util.HashMap;

public class AI extends Player {
    private static String aiDifficulty;

    HashMap <String, Integer> player1Moves = new HashMap<>();


    public AI(int health, boolean AI){
        super("AI", health, AI);
        aiDifficulty = "easy";
    }
    public AI(AI other){
        super(other);
        aiDifficulty = "easy";
    }

    public String getAiDifficulty(){
        return aiDifficulty;
    }
    public void getplayer1choice(String choice){
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
