package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
public class day2v1 {
   public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day2/day2.txt");
        String match = Files.readString(filePath);

        int totalPoints = 0;
        int totalPoints2 = 0;

       

        for (String play : match.split("\n")) {
            var opp = play.charAt(0);
            var me = play.charAt(2) ;
        //X=1 Y=2 Z=3
        switch (me){
            case 'X': totalPoints += 1; break;
            case 'Y': totalPoints += 2; break;
            case 'Z': totalPoints += 3; break;
        }
            //Win = 6
           if((opp == 'A' && me == 'Y') || (opp == 'B' && me == 'Z') || (opp == 'C' && me == 'X')){totalPoints += 6; continue;}
           //draw = 3
           if((opp == 'A' && me == 'X') || (opp == 'B' && me == 'Y') || (opp == 'C' && me == 'Z')){totalPoints += 3;continue;}
        }

        for (String play : match.split("\n")) {
            var opp = play.charAt(0);
            var strat = play.charAt(2) ;
        //X=win Y=draw Z=loss
        //A=Rock1 B=Paper2 C=Scissor3
        switch (strat){
            case 'Z': switch(opp){
                case 'A': totalPoints2 += 8; break;
                case 'B': totalPoints2 += 9; break;
                case 'C': totalPoints2 += 7; break;
            } break;
            case 'Y': switch(opp){
                case 'A': totalPoints2 += 4; break;
                case 'B': totalPoints2 += 5; break;
                case 'C': totalPoints2 += 6; break;
            } break;
            case 'X': switch(opp){
                case 'A': totalPoints2 += 3; break;
                case 'B': totalPoints2 += 1; break;
                case 'C': totalPoints2 += 2; break;
            } break;
            
        }
    }
    System.out.println(totalPoints);
    System.out.println(totalPoints2);
   }
}
