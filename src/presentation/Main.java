package presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    //Min main-metode består bar af en while-loop der kører så mange gange man vil indtil man trykker ud af applikationen
    public static void main(String[] args) {
        boolean whileCondition = true;
        while(whileCondition) {
            System.out.println("Press 1 for: See current haikus.");
            System.out.println("Press 2 for: Make new haiku.");
            System.out.println("Press 3 for: Quit application.");
            int choice = getInt(1, 3);
            switch (choice) {
                case 1:
                    Helper.showCurrentHaikus();
                    break;
                case 2:
                    Helper.makeHaiku();
                    break;
                case 3:
                    whileCondition = false;
                    System.out.println("Goodbye! :D");
                    break;
            }
        }
    }

    //Metode som sørger for et integer input mellem min og max og som ikke crasher i tilfælde af man skriver andet end integers.
    static int getInt(int min, int max){
        int choice;

        while (true){
            try{
                choice = scanner.nextInt();
                if (choice > max || choice < min){
                    throw new InputMismatchException();
                }
                else{ break;}
            }
            catch (InputMismatchException error){
                scanner.nextLine();
                System.out.println("Please only wrtie a number between " + min + " and " + max);
            }
        }
        return choice;
    }
}
