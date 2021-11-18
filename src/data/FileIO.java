package data;

import java.io.*;
import java.util.ArrayList;

public class FileIO {

    //Metode som downloader alle de nuværende haikus og returnere dem som en arraylist
    public static ArrayList<String> getCurrentHaikus(){
        ArrayList<String> currentHaikus = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Haikus.csv"));
            String line;
            while((line = reader.readLine()) != null){
                currentHaikus.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentHaikus;
    }


    //Metode som tjekker de nuværende ID på de oploadede Haiku-digte, og returner den næste værdi i rækken.
    public static int getNextID(){
        BufferedReader reader;
        String line = "";
        int lastID = 0;
        try {
            reader = new BufferedReader(new FileReader("Haikus.csv"));
            while((line = reader.readLine()) != null){
                String[] dividedString = line.split(";");
                lastID = Integer.parseInt(dividedString[0]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lastID + 1;
    }



    //Metode som uploader alle de haikus-digte som blev hentet ned tidligere.
    //Jeg kunne ikke få den til at tilføje til dokumentet men kun overskrive det.
    //Så før jeg uploader til dokumentet, downloader jeg hele dokumentet og uploader igen med det nye haiku digt.
    public static void addToFile(ArrayList<String> haikus) {
        BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter("Haikus.csv"));
                writer.write(haikus.get(0));
                for (int i = 1; i < haikus.size(); i++) {
                    writer.write("\n" + haikus.get(i));
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
