package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day3p1 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day3/day3.txt");
        String bags = Files.readString(filePath);
        int totalSum = 0;

        //get letter number
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int currentnumber = 1;
        for (Character letter : letters.toCharArray()) {
            map.put(letter, currentnumber);
            currentnumber++;
        }

        //String split
        for (String content : bags.split("\n")) {
        int middle = content.length()/2;
        String[] parts = {content.substring(0, middle),content.substring(middle)};
        List lettersBag = new ArrayList<Character>();
        Character duplicate = null;
        for (int i = 0; i < parts[0].length(); i++) {
            lettersBag.add(parts[0].charAt(i));
        }
        for (int i = 0; i < parts[1].length(); i++) {
            if(lettersBag.contains(parts[1].charAt(i))){
                duplicate = parts[1].charAt(i);
            }
        }
        totalSum += map.get(duplicate);
    }
    System.out.println(totalSum);
    }
}
