package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day3pt2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day3/day3.txt");
        String bags = Files.readString(filePath);
        int totalSum = 0;

        //get letter number
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int currentnumber = 1;
        List<String> lines = new ArrayList<String>();
        for (Character letter : letters.toCharArray()) {
            map.put(letter, currentnumber);
            currentnumber++;
        }

        for (String content : bags.split("\n")) {
            lines.add(content);
        }

        //Per 3 lines
        //Kijken welke letter overeenkomt tussen alle 3 de lines //ArrayList --> foreach --> line2.toCharArray().Contains(lettervan1) && line3.toCharArray().Contains(lettervan1)
        // 1 - 2 - 3
        // 4 - 5 - 6
        // 7 - 8 - 9
        // 10 - 11 - 12

        for(int i = 1; i <= lines.size(); i += 3){
            var line1 = lines.get(i-1).toString();
            var line2 = lines.get(i).toString();
            var line3 = lines.get(i+1).toString();
            Character duplicate = null;
            

            for (int j = 0; j < line1.length(); j++) {
                Character checkChar = line1.charAt(j);
                String insertChar = checkChar.toString();
                if(line2.contains(insertChar) && line3.contains(insertChar) ){
                    duplicate = checkChar;
                    break;
                }
            }
            totalSum += map.get(duplicate);
        }
        System.out.println(totalSum);
    }
}
