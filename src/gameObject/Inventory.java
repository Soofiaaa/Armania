package gameObject;

import gameObjectEnum.ItemDamage;
import gameObjectEnum.ItemDescription;
import gameObjectEnum.ItemName;

import java.util.Scanner;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class Inventory implements java.io.Serializable {
    // FINALS
    private final static byte INVENTORY_LENGTHS_MIN = 1;
    private final static byte INVENTORY_LENGTHS_MAX = 28;

    // VARIABLE
    transient private final Scanner keyboard = new Scanner(System.in);
    private Items[] inventory;
    private Items empty = new Items(ItemName.EMPTY, ItemDescription.EMPTY);

    // CONSTRUCTOR
    public Inventory() {
        inventory = new Items[28];

        for (byte i = 0; i < inventory.length; i++) {
            inventory[i] = empty;
        }
        addItem(woodenAxe);
        addItem(woodenSword);
    }

    // SWORDS
    private Items woodenSword = new Items(ItemName.WOODEN_SWORD, ItemDescription.WOODEN_SWORD, Integer.parseInt(String.valueOf(ItemDamage.WOODEN_SWORD)));
    private Items stoneSword = new Items(ItemName.STONE_SWORD, ItemDescription.STONE_SWORD, Integer.parseInt(String.valueOf(ItemDamage.STONE_SWORD)));

    // AXES
    private Items woodenAxe = new Items(ItemName.WOODEN_AXE, ItemDescription.WOODEN_AXE, Integer.parseInt(String.valueOf(ItemDamage.WOODEN_AXE)));
    private Items stoneAxe = new Items(ItemName.STONE_AXE, ItemDescription.STONE_AXE, Integer.parseInt(String.valueOf(ItemDamage.STONE_AXE)));

    // WOOD
    private Items treeLog = new Items(ItemName.TREE_LOG, ItemDescription.TREE_LOG);
    private Items oakLog = new Items(ItemName.OAK_LOG, ItemDescription.OAK_LOG);
    private Items hackberryLog = new Items(ItemName.HACKBERRY_LOG, ItemDescription.HACKBERRY_LOG);

    // GETS
    public Items getWoodenSword() {
        return woodenSword;
    }

    public Items getStoneSword() {
        return stoneSword;
    }

    public Items getWoodenAxe() {
        return woodenAxe;
    }

    public Items getStoneAxe() {
        return stoneAxe;
    }

    public Items getTreeLog() {
        return treeLog;
    }

    public Items getOakLog() {
        return oakLog;
    }

    public Items getHackberryLog() {
        return hackberryLog;
    }

    public String getInventory() {
        String strInventory = "";
        byte number = 0;

        for (byte i = 0; i < inventory.length; i++) {
            if (inventory[i] != empty) {
                strInventory += ++number + " -> " + inventory[i];
                if (inventory[i + 1] != empty) {
                    strInventory += "\n";
                }
            }
        }
        return strInventory;
    }

    public String getInfo() {
        String info = "";

        try {
            System.out.println("Which item do you wanna get info on?");
            byte pNumber = keyboard.nextByte();

            while (!validateInventorySize(pNumber)) {
                System.out.println("Please enter a number between 1 and 28!");
                pNumber = keyboard.nextByte();
            }
            if (inventory[pNumber - 1].getDamage() == 0) {
                info = inventory[pNumber - 1].getDescription() + ".";
            } else {
                info = inventory[pNumber - 1].getDescription() + " " + inventory[pNumber - 1].getDamage() + ".";
            }
        } catch (Exception e) {
            System.out.println("You did not enter a number.");
        }

        return info;
    }

    // VALIDATE
    public static boolean validateInventorySize(byte pNumber) {
        return pNumber >= INVENTORY_LENGTHS_MIN && pNumber <= INVENTORY_LENGTHS_MAX;
    }

    // METHODS
    public Items findAxe() {
        Items pItem = empty;

        for (Items items : inventory) {
            if (items == woodenAxe || items == stoneAxe) {
                pItem = items;
            }
        }

        return pItem;
    }

    public void addItem(Items pName) {
        for (byte i = 0; i < inventory.length; i++) {
            if (inventory[i] == empty) {
                inventory[i] = pName;
                break;
            }
        }
    }

    public void dropItem() {
        System.out.println("Which item do you wanna drop?");
        byte pNumber = keyboard.nextByte();

        while (!validateInventorySize(pNumber)) {
            System.out.println("Please enter a number between 1 and 28!");
            pNumber = keyboard.nextByte();
        }
        inventory[pNumber - 1] = empty;
    }
}