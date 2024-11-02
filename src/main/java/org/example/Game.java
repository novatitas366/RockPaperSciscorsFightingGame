package org.example;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
public class Game {


    static class TriSet<A, B, C> {
        private A first;
        private B second;
        private C third;
    
        public TriSet(A first, B second, C third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    
        public A getFirst() {
            return first;
        }
    
        public B getSecond() {
            return second;
        }
    
        public C getThird() {
            return third;
        }
    }










    public static void createComboHashMap(LinkedList<Combo.combo> Combos, TriSet<String, String, String> triset){
        Map<TriSet<String, String, String>, Boolean> hashOfCombos = new HashMap<>();
        for(Combo.combo tempcombo: Combos){
            triset = new TriSet<String, String, String>(tempcombo.getAttack1(), tempcombo.getAttack2(), tempcombo.getAttack3());
            hashOfCombos.put(triset, true);
        }
    }
    public static void gameWithAI(AI ai, String PlayerName) {
        Player player = new Player(PlayerName, 100, false);
        if (ai.getAiDifficulty() == "easy") {

        } else if (ai.getAiDifficulty() == "medium") {

        }
    }

    public static void gameWithPlayer(String PlayerName1, String PlayerName2, Scanner sc, LinkedList<Combo.combo> Combos) {
        boolean bothChoiceGiven = false;
        int checkChoice;
        Player player1 = new Player(PlayerName1, 100, false);
        Player player2 = new Player(PlayerName2, 100, false);
        boolean exitGame = false;

        createComboHashMap(Combos);
        

        while (player1.gethealth() > 0 && player2.gethealth() > 0 || !exitGame) {
            Menu.clearscrn();
            System.out.println(player1.getName() + " health: " + player1.gethealth() + " ".repeat(10) + player2.getName()
                                                 + " health: " + player2.gethealth());

            System.out.println(player1.getName() + " Choice: " + player1.getChoice() + " ".repeat(10) + player2.getName()
                            + " choice: " + player2.getChoice());
            System.out.print(player1.getName() + "choose Attack: \n1.Fire\n2.Water\n3.Earth\nchoose(type the number):");

            checkChoice = sc.nextInt();

            while (checkChoice < 1 || checkChoice > 3) {
                System.out.print("bad choice choose again: ");
                sc.nextLine();
                checkChoice = sc.nextInt();
            }

            player1.chooseAttack(checkChoice);
            Menu.clearscrn();
            System.out
                    .println(player1.getName() + " health: " + player1.gethealth() + " ".repeat(10) + player2.getName()
                            + " health: " + player2.gethealth());
            System.out.println(
                    player1.getName() + " Choice: " + "***" + " ".repeat(10) + player2.getName() + " choice: " + "***");
            System.out.print(player2.getName() + "choose Attack: \n1.Fire\n2.Water\n3.Earth\nchoose(type the number):");

            sc.nextLine();
            checkChoice = sc.nextInt();
            if (checkChoice < 1 || checkChoice > 3) {
                while (true) {
                    System.out.print("bad choice choose again: ");
                    sc.nextLine();
                    checkChoice = sc.nextInt();
                }
            }

            player2.chooseAttack(checkChoice);

            player1.damageHealth(player2.getChoice());
            player2.damageHealth(player1.getChoice());
        }

    }
}
