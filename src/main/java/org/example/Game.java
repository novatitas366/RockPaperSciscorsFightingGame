package org.example;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;

public class Game {

    static class gameHistory{
        private Player player1;
        private Player player2;
        private AI ai;

        public Player getPlayer1() {
            return player1;
        }
        public Player getPlayer2() {
            return player2;
        }
        public AI getAi() {
            return ai;
        }
        public gameHistory(Player player1, Player player2){
            this.player1 = new Player(player1);
            this.player2 = new Player(player2);
        }
        public gameHistory(Player player1, AI ai){
            this.player1 = new Player(player1);
            this.ai = new AI(ai);
        }
        public gameHistory(){
            this.player1 = null;
            this.player2 = null;
        }
    }


    public static void gameWithAI(AI ai, String PlayerName) {
        Player player = new Player(PlayerName, 100, false);
        if (ai.getAiDifficulty() == "easy") {

        } else if (ai.getAiDifficulty() == "medium") {

        }
    }

    public static void gameWithPlayer(String PlayerName1, String PlayerName2, Scanner sc, LinkedList<Combo.combo> Combos) {
        
        int checkChoice;
        Player player1 = new Player(PlayerName1, 100, false);
        Player player2 = new Player(PlayerName2, 100, false);
        boolean exitGame = false;
        Stack<gameHistory> History= new Stack<>();
        
        

        while (player1.gethealth() > 0 && player2.gethealth() > 0 || !exitGame) {
            Menu.clearscrn();
            History.push(new gameHistory(player1, player2));
            System.out.println(player1.getName() + " health: " + player1.gethealth() + " ".repeat(10) + player2.getName()
                                                 + " health: " + player2.gethealth());

            System.out.println(player1.getName() + " Choice: " + player1.getChoice() + " ".repeat(10) + player2.getName()
                            + " choice: " + player2.getChoice());
                            System.out.print(player1.getName() + "choose Attack: \n1.Fire\n2.Water\n3.Earth\n4.Go back in Time\n5.Forfeit\nchoose(type the number):");

            checkChoice = sc.nextInt();

            while (checkChoice < 1 || checkChoice > 5) {
                System.out.print("bad choice choose again: ");
                sc.nextLine();
                checkChoice = sc.nextInt();
            }
            if(checkChoice == 4){
                int howFar = Menu.showHistoryMenu(History);
                if(howFar != -1){
                    for(int i = 0; i< howFar-1; i++){
                        History.pop();
                    }
                    player1 = History.peek().getPlayer1();
                    player2 = History.peek().getPlayer2();
                }
                continue;
            }
            player1.chooseAttack(checkChoice);
            System.out.println(player1.getCurrentCombo().size());    
            Menu.clearscrn();
            System.out.println(player1.getName() + " health: " + player1.gethealth() + " ".repeat(10) + player2.getName()
                            + " health: " + player2.gethealth());
            System.out.println(player1.getName() + " Choice: " + "***" + " ".repeat(10) + player2.getName() + " choice: " + "***");
            System.out.print(player2.getName() + "choose Attack: \n1.Fire\n2.Water\n3.Earth\n4.Go back in Time\n5.Forfeit\nchoose(type the number):");

            sc.nextLine();
            checkChoice = sc.nextInt();
            if (checkChoice < 1 || checkChoice > 5) {
                while (true) {
                    System.out.print("bad choice choose again: ");
                    sc.nextLine();
                    checkChoice = sc.nextInt();
                }
            }
            if(checkChoice == 4){
                int howFar = Menu.showHistoryMenu(History);
                for(int i = 0; i< howFar-1; i++){
                    History.pop();
                }
                player1 = History.peek().getPlayer1();
                player2 = History.peek().getPlayer2();
                continue;
            }
            player2.chooseAttack(checkChoice);

            player1.damageHealth(player2.dealDamage(player1.getChoice(), Combos));
            player2.damageHealth(player1.dealDamage(player2.getChoice(), Combos));
        }

    }
}
