package domain;

import java.util.Scanner;

public class Rules {
    static char[] vovels = {'a', 'e', 'u', 'i', 'o', 'y', 'æ', 'ø', 'å'};
    static Scanner scanner = new Scanner(System.in);

    public Rules (){
    }

    public boolean checkHaiku(String[] haiku){
        boolean check = true;
        for (int i = 0; i < haiku.length; i++) {
            String currentSentence = haiku[i].toLowerCase();
            check = checkForSyllables(currentSentence, i);
            if (check == false){
                break;
            }
        }
        return check;
    }

    static boolean checkForSyllables(String lineToCheck, int line){
        int syllablesNeeded = line == 1 ? 7 : 5;
        int totalSyllables = 0;
        boolean check;
        char lastChar = '.';

        for (int i = 0; i < lineToCheck.length(); i++) {
            char currentChar = lineToCheck.charAt(i);

            for (int j = 0; j < vovels.length; j++) {
                if (lastChar == currentChar) {
                    break;
                }
                if (currentChar == vovels[j]){
                    totalSyllables++;

                }
            }
            lastChar = currentChar;
        }
        check = totalSyllables == syllablesNeeded ? true : false;
        return check;
    }


    public static String[] getHaiku(){
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
