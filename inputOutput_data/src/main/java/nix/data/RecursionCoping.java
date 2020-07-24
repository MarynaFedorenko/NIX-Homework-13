package nix.data;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class RecursionCoping {

    public static void task(File source, File destination) throws IOException{
        if(!source.exists()){
            System.out.println("Directory does not exist!");

        }
        else{
            RecursionCoping.copyDir(source, destination);
            System.out.println();
            System.out.println("Copied successfully!");
        }
    }

    public static void copyDir (File src, File dest) throws IOException{
        if(src.isDirectory()){
            //if directory does not exist, I create it
            if(!dest.exists()){
                dest.mkdir();
                System.out.println("Directory copied from "+src + "   to  " + dest);
            }

            String files [] = src.list();
            for(String fileName : files){
                File srcFile = new File(src, fileName);
                File destFile = new File (dest, fileName);
                //recursive copy
                task(srcFile, destFile);
            }
        }
        else{
            //If not directory, but file - copy it
            System.out.println("src = "+src.getPath()+" \n dest = "+dest.getPath());
            fileCopy(src, dest);
        }
    }

    private static void fileCopy(File src, File dest) throws FileNotFoundException, IOException{
        String text = "";
        System.out.println();
        System.out.println("Text from file: ");
        try {
            List<String> lines = Files.readAllLines(Paths.get(src.toURI()));
            for(int i=0; i<lines.size(); i++){
                System.out.println(lines.get(i));
                    text+=lines.get(i)+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter writer = new PrintWriter(dest);
        writer.write(text);
        writer.close();
        }





}
