package org.example;

public class AI {
    private static String aiDifficulty = "easy";

    public String getAiDifficulty(){
        return aiDifficulty;
    }
    public static void changeAiDifficulty(int diff){
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
