package presentation;

import data.FileIO;
import domain.Rules;

import java.util.ArrayList;

public class Helper {
    static ArrayList<String> haikus = new ArrayList<String>();

    //Haiku bliver lavet i et String-array og bliver tjekket igennem med en metod i Rules klassen.
    static void makeHaiku(){
        Main.scanner.nextLine();
        //Laver Haiku og printer det
        String[] haiku = Rules.getHaiku();
        for (int i = 0; i < haiku.length; i++) {
            System.out.println(haiku[i]);
        }

        //Hvis Stringen opfylder kravene for et Haiku får den et ID og brugeren skal indtaste sit navn.
        //Herefter bliver digtet skrevet om til én String som kan indlæses af filereaderen i FileIO klassen.
        if (Rules.checkHaiku(haiku)){
            System.out.println("What a beautiful poem. What is the name of such an inspiring writer?");
            String name = Main.scanner.nextLine();
            String oneString = convertToOneString(haiku, name);
            addHaikuToOtherHaikus(oneString);
            System.out.println("This poem has now been added to the list.");
            FileIO.addToFile(haikus);
        }
        else {
            System.out.println("This is not a Haiku-poem.");
        }
    }

    //Laver en arraylist af de tidligere Haikus og printer dem
    static void showCurrentHaikus(){
        ArrayList<String> haikusToShow = FileIO.getCurrentHaikus();
        for (int i = 0; i < haikusToShow.size(); i++) {
            String[] currentHaiku = haikusToShow.get(i).split(";");
            System.out.println("ID: " + currentHaiku[0] + "\nAuthor: " + currentHaiku[1]);
            System.out.println(currentHaiku[2] + "\n" + currentHaiku[3] + "\n" + currentHaiku[4] + "\n");
        }
    }

    //Konvertere en String-array om til én String som kan oploades til FileReader.
    static String convertToOneString(String[] haiku, String name){
        int x = FileIO.getNextID();
        String wholeString = x + ";" + name;
        for (int i = 0; i < haiku.length; i++) {
            wholeString = wholeString + ";" +  haiku[i];
        }
        return wholeString;
    }

    //Tilføjer haiku til listen af allerede eksisterende haikus så de kan oploades til csv-filen.
    static void addHaikuToOtherHaikus(String haiku){
        haikus = FileIO.getCurrentHaikus();
        haikus.add(haiku);
    }
}
