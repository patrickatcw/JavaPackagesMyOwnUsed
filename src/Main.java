import com.programpackage.ISaveable;
import com.programpackage.Monster;
import com.programpackage.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    //code from javainterfacesplayercharacteristics
    public static void main(String[] args) {

        //step 15 creating instance
        Player patrick = new Player("Patrick", 10, 15);
        System.out.println(patrick.toString());
        savedObject(patrick);

        //step 16 changes
        patrick.setHitpoints(8);
        System.out.println(patrick);
        patrick.setWeapon("Stormbringer");
        savedObject(patrick);
        loadObject(patrick);
        System.out.println(patrick);

        //step 24 instance
        ISaveable werewolf = new Monster("Werewolf", 20, 40);
        System.out.println("Strength = " + ((Monster)werewolf).getStrength());
        savedObject(werewolf);
        //step 25 run, comment out loadObject above

        //step 17 run

        //step 18 create monster class

    }

    //input from lesson the read values method outside of the main
    public static ArrayList<String> readValues () {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }

        }
        return values;

    }

    //step 13 method
    public static void savedObject (ISaveable objectToSave){

        for (int i = 0; i < objectToSave.write().size(); i++) {

            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");

        }

    }

    //step 14 method for load object
    public static void loadObject (ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);


    }
}



