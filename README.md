# java-adventure-game
Java text-based adventure game for Project 0

import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int turns = 0;
        boolean gameRunning = true;

        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You are trapped in a mysterious dungeon.");
        System.out.println("Find your way out. Good luck!");
        System.out.println("Type help if you need to see the commands.");

        while (gameRunning) {
            System.out.print("\nWhat would you like to do? ");
            String command = input.nextLine().trim().toLowerCase();

            if (command.equals("help")) {
                System.out.println("\nAvailable commands:");
                System.out.println("look - Look around");
                System.out.println("take - Pick up an item");
                System.out.println("inventory - Check your inventory");
                System.out.println("open - Open a door");
                System.out.println("go north - Move north");
                System.out.println("go south - Move south");
                System.out.println("go east - Move east");
                System.out.println("go west - Move west");
                System.out.println("sleep - Take a nap");
                continue;
            }

            turns++;

            switch (command) {
                case "look":
                    System.out.println("You see stone walls and a dark hallway.");
                    break;

                case "take":
                    System.out.println("You picked up a rusty key.");
                    break;

                case "inventory":
                    System.out.println("Your inventory contains a rusty key.");
                    break;

                case "open":
                    System.out.println("You try to open a heavy wooden door.");
                    break;

                case "go north":
                    System.out.println("You walk north into a cold hallway.");
                    break;

                case "go south":
                    System.out.println("You walk south past some old torches.");
                    break;

                case "go east":
                    System.out.println("You walk east and hear strange noises.");
                    break;

                case "go west":
                    System.out.println("You walk west toward a stone wall.");
                    break;

                case "sleep":
                    System.out.println("You take a short nap on the cold floor.");
                    break;

                case "xyzzy":
                    System.out.println("A secret door opens! You escape the dungeon!");
                    gameRunning = false;
                    break;

                default:
                    System.out.println("Command not recognized.");
                    System.out.println("Here are the available commands:");
                    System.out.println("look, take, inventory, open");
                    System.out.println("go north, go south, go east, go west");
                    System.out.println("sleep, help");
                    break;
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Total turns played: " + turns);

        input.close();
    }
}
