package presentation;

import data.FileIO;
import domain.Rules;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> haikus = new ArrayList<String>();
    public static void main(String[] args) {
        Rules rules = new Rules();
        FileIO files = new FileIO();

        //Laver Haiku og printer det
        String[] haiku = getHaiku();
        for (int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }
        if (rules.checkHaiku(haiku)){
            System.out.println("What a beautiful poem. What is the name of such an inspiring writer?");
            String name = scanner.nextLine();
            String oneString = convertToOneString(haiku, name);
            addHaikuToOtherHaikus(oneString);
            FileIO.addToFile(haikus);
        }
        else {
            System.out.println("This is not a Haiku-poem.");
        }
    }

    static String convertToOneString(String[] haiku, String name){
        int x = FileIO.getNextID();
        String wholeString = x + ";" + name;
        for (int i = 0; i < haiku.length; i++) {
            wholeString = wholeString + ";" +  haiku[i];
        }
        return wholeString;
    }


    static void addHaikuToOtherHaikus(String haiku){
        haikus = FileIO.getCurrentHaikus();
        haikus.add(haiku);
    }

    static String[] getHaiku(){
        String[] haiku = new String[3];
        for (int i = 0; i < haiku.length; i++) {
            haiku[i] = getLine(i);
        }
        return haiku;
    }

    static String getLine(int line){
        String text = line == 0 ? "Write the first sentence of your poem." : line == 1 ? "Write your second sentence of your poem." : "Write your last sentence of your poem.";
        System.out.println(text);
        String word = scanner.nextLine();
        return word;
    }
}
