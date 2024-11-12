package org.example;

public class History {
    private Player player1;
    private Player player2;
    private boolean player1Won;
    private AI ai;
    private boolean isThereAI;

    public History(Player player1, Player player2){
        this.isThereAI = false;
        if(player1.IsDead()){
            player1Won = false;
        }
        else if(player2.IsDead()){
            player1Won = true;
        }
        this.player1 = player1;
        this.player2 = player2;
    }
    public History(Player player1, AI ai){
        this.isThereAI = true; 
        this.player1 = player1;
        this.ai = ai;
        if(player1.IsDead()){
            player1Won = false;
        }
        else if(ai.IsDead()){
            player1Won = true;
        }
    }

    public boolean getIsThereAI(){
        return isThereAI;
    }
    public String showHistoryMenuOfGames(){

        if(!isThereAI &&player1.getForfeit()){
            return player1.getName()+" vs "+player2.getName()+", "+player1.getName()+" forfeited";
        }
        else if(!isThereAI &&player2.getForfeit()){
            return player1.getName()+" vs "+player2.getName()+", "+player2.getName()+" forfeited";
        }
        else if(isThereAI && player1.getForfeit()){
            return player1.getName()+" vs "+ai.getName()+", "+player1.getName()+" forfeited";
        }
        else if(isThereAI && player1Won){
            return player1.getName()+" vs "+ai.getName()+", "+player1.getName()+" won";
        }
        else if(isThereAI && !player1Won){
            return player1.getName()+" vs "+ai.getName()+", "+ai.getName()+" won";
        }
        else if(!isThereAI && player1Won){
            return player1.getName()+" vs "+player2.getName()+", "+player1.getName()+" won";
        }
        else{
            return player1.getName()+" vs "+player2.getName()+", "+player2.getName()+" won";
        }

    }

}
