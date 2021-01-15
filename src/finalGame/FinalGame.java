package finalGame;

import audio.Audio;
import gameObject.*;
import player.Player;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class FinalGame implements java.io.Serializable {
    // MAIN
    public static void main(String[] args) {
        try {
            // VARIABLE
            final Scanner keyboard = new Scanner(System.in);
            Audio audio = new Audio();

            Player player1 = new Player();
            Map map1 = new Map();
            Inventory inventory1 = new Inventory();
            SkillTable skillTable1 = new SkillTable();
            Entities entities = new Entities();

            Clip clip = audio.getClip();
            String command;

            audio.playMusic("music/Harmony", 0.0, 0.75);
            do {
                System.out.print("> ");
                command = keyboard.nextLine().toUpperCase();
                switch (command) {
                    // GAME STATUS
                    case "SAVE" -> {
                        try {
                            System.out.println("Save only when all the entities on the map has respawn, else it will corrupt the save file.");
                            FileOutputStream fos = new FileOutputStream("MMO.sav");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(player1);
                            oos.writeObject(map1);
                            oos.writeObject(inventory1);
                            oos.writeObject(skillTable1);
                            oos.writeObject(entities);
                            oos.flush();
                            oos.close();
                            System.out.println("Game saved.");
                        } catch (Exception e) {
                            System.out.println("Error, game can't be save.");
                            e.printStackTrace();
                        }
                    }
                    case "LOAD" -> {
                        try {
                            FileInputStream fis = new FileInputStream("MMO.sav");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            player1 = (Player) ois.readObject();
                            map1 = (Map) ois.readObject();
                            inventory1 = (Inventory) ois.readObject();
                            skillTable1 = (SkillTable) ois.readObject();
                            entities = (Entities) ois.readObject();
                            ois.close();
                            System.out.println(player1.welcome());
                            System.out.println(player1.welcomeBack());
                        } catch (Exception e) {
                            System.out.println("Error, no account has been found.");
                            player1 = new Player();
                        }
                    }

                    case "CLEAR" -> Runtime.getRuntime().exec("clear");
                    case "WHOAMI" -> System.out.println(player1);

                    // MOVEMENT
                    case "W" -> map1.moveUp();
                    case "S" -> map1.moveDown();
                    case "D" -> map1.moveRight();
                    case "A" -> map1.moveLeft();
                    case "WA" -> {
                        map1.moveUp();
                        map1.moveLeft();
                    }
                    case "WD" -> {
                        map1.moveUp();
                        map1.moveRight();
                    }
                    case "SA" -> {
                        map1.moveDown();
                        map1.moveLeft();
                    }
                    case "SD" -> {
                        map1.moveDown();
                        map1.moveRight();
                    }

                    // INVENTORY
                    case "LS" -> System.out.println(inventory1.getInventory());
                    case "INFO" -> System.out.println(inventory1.getInfo());
                    case "DROP" -> inventory1.dropItem();

                    // MAP
                    case "MAP", "M" -> System.out.println(map1.getMap());
                    case "POSITION", "LOCATION", "LOC", "POS" -> {
                        System.out.println(map1.getMap());
                        System.out.println(map1.getPosition());
                    }
                    case "GETINFOPLACE", "GETINFOLOCATION", "GIP", "GIL", "INFOPLACE", " INFOLOCATION", "IP", "IL" -> System.out.println(map1.getInfoLocation());
                    case "MAP SIZE", "MAPSIZE", "MS" -> System.out.println(map1.getMapSize());

                    // SKILL
                    case "SKILL", "ST" -> System.out.println(skillTable1.getSkillTable());
                    // WOOD CUTTING
                    case "CUT TREE", "CUTTREE", "CT" -> entities.cutTree(map1, inventory1, skillTable1);
                    case "WC", "SWC", "WOOD CUTTING", "WOODCUTTING" -> System.out.println("You are level " + skillTable1.getWoodCuttingLevel() + " with " + skillTable1.getWoodCuttingXP() + " xp.");
                }
            } while (!command.equals("QUIT") && !command.equals("Q"));
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error, please restart the game.");
        }
    }
}