package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class day2{
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day2/day2.txt");
        String match = Files.readString(filePath);
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0); map.put('B', 1); map.put('C', 2); map.put('X', 0); map.put('Y', 1); map.put('Z', 2);

        int totalPoints = 0;
        int totalPoints2 = 0;
        int[] extraPoints = {1,2,3};

        for (String play : match.split("\n")) {
                int opp = map.get(play.charAt(0));
                int me = map.get(play.charAt(2));
            
                if (Math.floorMod(me - opp, 3) == 1){totalPoints += 6;}
                else if (me == opp){totalPoints += 3;}
                totalPoints += extraPoints[me];
         }
        System.out.println(totalPoints);


        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        map2.put('A', 0); map2.put('B', 1); map2.put('C', 2); map2.put('X', -1); map2.put('Y', 0); map2.put('Z', 1);
        
        for (String play : match.split("\n")) {
            int opp = map2.get(play.charAt(0));
            int strat = map2.get(play.charAt(2));

            totalPoints2 += (strat + 1) * 3;
            totalPoints2 += extraPoints[Math.floorMod(opp + strat, 3)];
        }      
          System.out.println(totalPoints2);
    }
}

