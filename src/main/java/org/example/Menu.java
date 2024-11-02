package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.example.Game;
public class Menu {
    static Scanner sc = new Scanner(System.in);
    public void ShowMenu(LinkedList<Combo.combo> Combos) {
        while (true) {

            String RESET = "\u001B[0m";
            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            

            System.out.println(RED +
                    " (                                (                     \r\n" +
                    " )\\ )             )        (      )\\ )          )       \r\n" +
                    "(()/(  (       ( /(        )\\ )  (()/(    )  ( /(   (   \r\n" +
                    " /(_)) )\\  (   )\\())   (  (()/(   /(_))( /(  )\\()) ))\\  \r\n" +
                    "(_))_|((_) )\\ (_))/    )\\  /(_)) (_))_|)(_))(_))/ /((_) \r\n" +
                    GREEN +
                    "| |_   (_)((_)| |_    ((_)(_) _| | |_ ((_)_ | |_ (_))   \r\n" +
                    "| __|  | |(_-<|  _|  / _ \\ |  _| | __|/ _` ||  _|/ -_)  \r\n" +
                    "|_|    |_|/__/ \\__|  \\___/ |_|   |_|  \\__,_| \\__|\\___|" + RESET);

            int choice = 100;
            String NewGame = "1.New Game";
            String Settings = "2.Settings";
            String QuitGame = "3.Quit Game";
            int consoleWidth = 20;
            System.out.println(" ".repeat(consoleWidth) + NewGame);
            System.out.println(" ".repeat(consoleWidth) + Settings);
            System.out.println(" ".repeat(consoleWidth) + QuitGame);
            System.out.println();
            System.out.println("Select an option:");
            System.out.println();
            System.out.println(Combos.get(0).getAll());
            choice = sc.nextInt();
           
            switch (choice) {
                case 1:
                    showPlayerMenu();
                    break;
                case 2:
                    ShowSettings();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Select a valid option!");
            }
        }
    }

    public static void clearscrn() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private static AI comp = new AI();

    public static void ShowSettings() {
        while (true) {
            clearscrn();
            System.out.println(" _______  _______  _______  _______  ___   __    _  _______  _______ \n" +
                    "|       ||       ||       ||       ||   | |  |  | ||       ||       |\n" +
                    "|  _____||    ___||_     _||_     _||   | |   |_| ||    ___||  _____|\n" +
                    "| |_____ |   |___   |   |    |   |  |   | |       ||   | __ | |_____ \n" +
                    "|_____  ||    ___|  |   |    |   |  |   | |  _    ||   ||  ||_____  |\n" +
                    " _____| ||   |___   |   |    |   |  |   | | | |   ||   |_| | _____| |\n" +
                    "|_______||_______|  |___|    |___|  |___| |_|  |__||_______||_______|");

            System.out.println("1. change AI strength. Current - " + comp.getAiDifficulty());
            System.out.println("4.go back");
            System.out.println("select a choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("choose difficulty:\n1-easy\n2-medium(AI chooses based on probability)\n3-hard");
                    comp.changeAiDifficulty(sc.nextInt());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                
                    return;

                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }
    }
    
    public static void showPlayerMenu() {
        clearscrn();
        System.out.println("how many players are going to play:");
        System.out.println("1. One player (play with AI)");
        System.out.println("2. two players (play against each other)");
        System.out.println("3. cancel");
        System.out.print("give choice: ");
        switch (sc.nextInt()) {
            case 1:
                Game.gameWithAI(comp);
                break;
            case 2:
                // PlayGamePlayer
            case 3:
                
                return;
            default:
                System.out.println("please give a valid choice");
        }
        
    }
}