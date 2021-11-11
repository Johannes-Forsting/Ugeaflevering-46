package presentation;

import domain.Rules;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Rules rules = new Rules();
        String[] haiku = getHaiku();
        for (int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }
        if (rules.checkHaiku(haiku)){
            System.out.println("What a beautiful poem. What is the name of such an inspiring writer?");
            String name = scanner.nextLine();
        }
        else {
            System.out.println("This is not a Haiku-poem.");
        }
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
