package player;

import audio.Audio;

import javax.sound.sampled.Clip;
import java.io.IOException;
import java.util.Scanner;

/**
 * Version 1.2
 * Author : Sofia
 **/

public class Player implements java.io.Serializable {
    // FINALS
    transient private final Scanner keyboard = new Scanner(System.in);
    private final static byte NAME_LENGTHS_MIN = 3;
    private final static byte NAME_LENGTHS_MAX = 20;

    // VARIABLES
    private String name;
    private Gender gender;

    // CONSTRUCTOR
    public Player() throws IOException, ClassNotFoundException {
        Audio audio = new Audio();
        audio.playMusic("music/Armania", 0.0, 0.75);
        Clip clip = audio.getClip();

        System.out.println("Do you already have an account?");
        String haveAccount = keyboard.nextLine().toUpperCase();
        while (!haveAccount.equals("YES") && !haveAccount.equals("NO")) {
            System.out.println("Please enter yes or no!");
            haveAccount = keyboard.nextLine().toUpperCase();
        }
        if (haveAccount.equals("YES")) {
            System.out.println("Enter load.");
            audio.endVolume(clip);
        } else {
            setName();
            setGender();
            System.out.println("Your name is " + name + " and you are a " + String.valueOf(gender).toLowerCase() + ".");
            System.out.println("Is that right?");
            haveAccount = keyboard.nextLine().toUpperCase();
            while (!haveAccount.equals("YES") && !haveAccount.equals("NO")) {
                System.out.println("Please enter yes or no!");
                haveAccount = keyboard.nextLine().toUpperCase();
            }
            if (haveAccount.equals("NO")) {
                new Player();
            } else {
                System.out.println(welcome());
                audio.endVolume(clip);
            }
        }
    }

    // GETS
    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    // SETS
    public void setName() {
        System.out.print("What is your name : ");
        name = keyboard.nextLine();

        while (!validateName(name)) {
            System.out.println("Enter a valid name, 3 to 20 characters.");
            name = keyboard.nextLine();
        }
    }

    public void setGender() {
        try {
            System.out.print("What is your gender : ");
            gender = Gender.valueOf(keyboard.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Enter a valid gender, female or male.");
            gender = Gender.valueOf(keyboard.nextLine().toUpperCase());
        }
    }

    // VALIDATES
    public static boolean validateName(String pName) {
        return pName != null && pName.length() >= NAME_LENGTHS_MIN && pName.length() <= NAME_LENGTHS_MAX;
    }

    public static boolean validateGender(Gender pGender) {
        return pGender != null;
    }

    // METHODS
    public String welcome() {
        return " .----------------.  .----------------.  .----------------.  .----------------.  .-----------------. .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |      __      | || |  _______     | || | ____    ____ | || |  _________   | || | ____  _____  | || |     _____    | || |      __      | |\n" +
                "| |     /  \\     | || | |_   __ \\    | || ||_   \\  /   _|| || | |_   ___  |  | || ||_   \\|_   _| | || |    |_   _|   | || |     /  \\     | |\n" +
                "| |    / /\\ \\    | || |   | |__) |   | || |  |   \\/   |  | || |   | |_  \\_|  | || |  |   \\ | |   | || |      | |     | || |    / /\\ \\    | |\n" +
                "| |   / ____ \\   | || |   |  __ /    | || |  | |\\  /| |  | || |   |  _|  _   | || |  | |\\ \\| |   | || |      | |     | || |   / ____ \\   | |\n" +
                "| | _/ /    \\ \\_ | || |  _| |  \\ \\_  | || | _| |_\\/_| |_ | || |  _| |___/ |  | || | _| |_\\   |_  | || |     _| |_    | || | _/ /    \\ \\_ | |\n" +
                "| ||____|  |____|| || | |____| |___| | || ||_____||_____|| || | |_________|  | || ||_____|\\____| | || |    |_____|   | || ||____|  |____|| |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'";
    }

    public String welcomeBack() {
        return "Welcome back " + name + "!";
    }

    // TO STRING
    @Override
    public String toString() {
        return "Your name is " + name + " and you are a " + String.valueOf(gender).toLowerCase() + ".";
    }
}