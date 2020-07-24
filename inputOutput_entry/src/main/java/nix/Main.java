package nix;

import nix.data.RecursionCoping;
import nix.data.StringsFromFile;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("____________Task 1______________");
        StringsFromFile.task();
        System.out.println();

        System.out.println("____________Task 2______________");
        File srcDir = new File("source");
        File destDir = new File("destination");
        try {
            RecursionCoping.task(srcDir, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
