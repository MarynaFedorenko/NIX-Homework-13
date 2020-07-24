package nix.data;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringsFromFile {

    public static void task(){
        String text = "";
        System.out.println("Text from file:\n");
        try {
            List<String> lines = Files.readAllLines(Path.of("inputOutput_data/src/main/resources/text.txt"));
            for(int i=0; i<lines.size(); i++){
                System.out.println(lines.get(i));
                if(lines.get(i).contains(" to "))
                    text+=lines.get(i)+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Filtered text(all strings contain substring ' to '):\n");
        System.out.println(text);



    }
}
