package org.example;

import java.util.Scanner;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Menu implements NativeKeyListener {
    private static int choice = 0;

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_W) {
            choice = (choice - 1 + 3) % 3;
            clearscrn();
        } else if (e.getKeyCode() == NativeKeyEvent.VC_S) {
            choice = (choice + 1) % 3;
            clearscrn();
        } else if (e.getKeyCode() == NativeKeyEvent.VC_ENTER) {
            switch (choice) {

                case 1:
                    // game();
                    StartGameMenu();
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

    public static void cursorToStart() {
        System.out.println("\033[H");
    }

    private static void hideCursor() {
        System.out.print("\033[?25l"); // Hide the cursor
        System.out.flush();
    }

    public static void ShowMenu() {
        clearscrn();
        while (true) {
            hideCursor();
            String RESET = "\u001B[0m";
            String RED = "\u001B[31m";
            String GREEN = "\u001B[32m";
            Scanner sc = new Scanner(System.in);
            cursorToStart();
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

            
            String NewGame = "New Game";
            String Settings = "Settings";
            String QuitGame = "Quit Game";
            String Arrow = ">>";
            int consoleWidth = 20;
            if(choice == 0){
                System.out.println(" ".repeat(consoleWidth-2)+ Arrow + NewGame);
                System.out.println(" ".repeat(consoleWidth)+  Settings);
                System.out.println(" ".repeat(consoleWidth)+  QuitGame);
            }
            else if(choice == 1){
                System.out.println(" ".repeat(consoleWidth)+NewGame);
                System.out.println(" ".repeat(consoleWidth-2)+ Arrow +   Settings);
                System.out.println(" ".repeat(consoleWidth)+  QuitGame);
            }
            else if(choice == 2){
                System.out.println(" ".repeat(consoleWidth)+NewGame);
                System.out.println(" ".repeat(consoleWidth)+Settings);
                System.out.println(" ".repeat(consoleWidth-2)+ Arrow +  QuitGame);
            }

            
            // System.out.println(" ".repeat(consoleWidth)+ Arrow + NewGame);
            // System.out.println(" ".repeat(consoleWidth) + Settings);
            // System.out.println(" ".repeat(consoleWidth) + QuitGame);
            // System.out.println();
            // System.out.println("Select an option:");
            // choice = sc.nextInt();

            // switch (choice) {
            //     case 1:
            //         //game();
            //         StartGameMenu();
            //         break;
            //     case 2:
            //         ShowSettings();
            //         break;

            //     case 3:
            //         return;

            //     default:
            //         System.out.println("Select a valid option!");
            // }

        }
    }

    public static void StartGameMenu() {
        clearscrn();
        Scanner sc = new Scanner(System.in);
        System.out.println(" ".repeat(20) + "choose whether to play: ");
        System.out.println(" ".repeat(20) + "1.Player vs. AI");
        System.out.println(" ".repeat(20) + "2.Player vs. Player");
        switch (sc.nextInt()) {
            case 1:

                break;

            default:
                break;
        }
        sc.close();
    }

    public static void clearscrn() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void ShowSettings() {
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