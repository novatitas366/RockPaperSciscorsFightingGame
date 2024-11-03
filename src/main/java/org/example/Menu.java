package org.example;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Scanner;
import org.example.Game.gameHistory;
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
            choice = sc.nextInt();
           
            switch (choice) {
                case 1:
                    showPlayerMenu(Combos);
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

    private static AI comp = new AI(100, true);

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
                    System.out.println("animations: ");
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
    
    public static void showPlayerMenu(LinkedList<Combo.combo> Combos) {
        clearscrn();
        System.out.println("how many players are going to play:");
        System.out.println("1. One player (play with AI)");
        System.out.println("2. two players (play against each other)");
        System.out.println("3. cancel");
        System.out.print("give choice: ");
        switch (sc.nextInt()) {
            case 1:
                showPlayerCreationMenu(1, Combos);
                break;
            case 2:
                showPlayerCreationMenu(2, Combos);
            case 3:
                
                return;
            default:
                System.out.println("please give a valid choice");
        }
        
    }

    public static void showPlayerCreationMenu(int choice, LinkedList<Combo.combo> Combos){
        clearscrn();
        if(choice == 1){
            String PlayerName;
            System.out.println("what is the player name?");
            sc.nextLine();
            System.out.print("name: "); PlayerName = sc.nextLine();
            System.out.println(PlayerName);


            Game.gameWithAI(comp, PlayerName);
        }
        else if(choice == 2){
            String PlayerName1, PlayerName2;
            System.out.println("what is the name of player1?");
            sc.nextLine();
            System.out.print("name: "); PlayerName1 = sc.nextLine();
            clearscrn();
            System.out.println("what is the name of player2?");
            System.out.print("name: "); PlayerName2 = sc.nextLine();
            Game.gameWithPlayer(PlayerName1, PlayerName2, sc, Combos);
        }
        

    }

    public static int showHistoryMenu(Stack<gameHistory> History){
        while(true){
            System.out.println("How far do you want to jump back?");
            Stack<gameHistory> tempHist = new Stack<>();
            for(gameHistory thing: History){
                tempHist.push(thing);
            }
            int i = 1;
            while(!tempHist.isEmpty()&& i<=3){
                System.out.println(i+". "+tempHist.peek().getPlayer1().getName()+"  Health: "+tempHist.peek().getPlayer1().gethealth()+"  move: "+tempHist.peek().getPlayer1().getChoice()+" ".repeat(5)+ tempHist.peek().getPlayer2().getName()+"  Health: "+tempHist.peek().getPlayer2().gethealth()+"   move: "+tempHist.peek().getPlayer2().getChoice());
                tempHist.pop();
                i++;
            }

            System.out.println(i+". go back");

            sc.nextLine();
            int choice = sc.nextInt();
            while(choice < 1 && choice >i){
                System.out.print("bad choice choose again: ");
                sc.nextLine();
                choice = sc.nextInt();
            }
            if(choice == i){
                return -1;
            }
            else{
                return choice;
            }
            
        }
    }
}