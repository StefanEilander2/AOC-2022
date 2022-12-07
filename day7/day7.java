package day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class day7 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day7/testdata.txt");
        String lines = Files.readString(filePath);
        Map<String, Integer> sizes = new HashMap<String, Integer>();
        String currentDir = ""; 
        var directories = new ArrayList<String>();

        for (String command : lines.split("\n")) {
            var words = new ArrayList<String>();
            for (String word : command.split(" ")) {
                words.add(word.trim());
        }
        if(words.get(0).equals("$")){
            if(words.get(1).equals("cd")){
                if(words.get(2).equals("..")){
                    sizes.put(directories.get(directories.size() - 2), sizes.get(directories.get(directories.size() - 2)) + sizes.get(currentDir));
                    currentDir = directories.get(directories.size() - 2);
                    directories.remove(directories.size()-1);
                    continue;
                }
                if(words.get(2).equals("/")){
                    if(!directories.isEmpty()){
                    sizes.put("/", (sizes.get("/") + sizes.get(currentDir)));
                    currentDir = directories.get(0);
                    }
                    else{
                        directories.add("/");
                        currentDir = "/";
                        sizes.put(currentDir, 0);
                        
                    }
                }
                currentDir = words.get(2);
                if(!directories.contains(currentDir)){
                    directories.add(currentDir);
                    sizes.put(currentDir, 0);
                }
            }
        }
        if(Character.isDigit(words.get(0).charAt(0))){
            sizes.put(currentDir, (sizes.get(currentDir) + Integer.parseInt(words.get(0))));
        }
        }
        while(directories.size() > 1){
            sizes.put(directories.get(directories.size() - 2), sizes.get(directories.get(directories.size() - 2)) + sizes.get(currentDir));
                    currentDir = directories.get(directories.size() - 2);
                    directories.remove(directories.size()-1);
        }
        int totalSum = 0;
        for (Map.Entry<String, Integer> entry : sizes.entrySet()) {
            if(entry.getValue() < 100000){
                totalSum += entry.getValue();
            }
            System.out.println(entry.getValue());
        }
        System.out.println(totalSum);
        System.out.println(sizes);
    }

}