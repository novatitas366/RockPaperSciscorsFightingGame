package org.example;

import java.util.Scanner;

public class Menu {
    public static void ShowMenu() {
        while (true) {

            String RESET = "\u001B[0m";
            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            Scanner sc = new Scanner(System.in);

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
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //game();
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
    public static void clearscrn(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    public  static  void ShowSettings(){
        clearscrn();
        Scanner sc = new Scanner(System.in);
        System.out.println(" _______  _______  _______  _______  ___   __    _  _______  _______ \n" +
                "|       ||       ||       ||       ||   | |  |  | ||       ||       |\n" +
                "|  _____||    ___||_     _||_     _||   | |   |_| ||    ___||  _____|\n" +
                "| |_____ |   |___   |   |    |   |  |   | |       ||   | __ | |_____ \n" +
                "|_____  ||    ___|  |   |    |   |  |   | |  _    ||   ||  ||_____  |\n" +
                " _____| ||   |___   |   |    |   |  |   | | | |   ||   |_| | _____| |\n" +
                "|_______||_______|  |___|    |___|  |___| |_|  |__||_______||_______|");


        System.out.println("4.go back");
        System.out.println("select a choice:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
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