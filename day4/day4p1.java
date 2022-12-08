package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class day4p1 {
    
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day4/testdata.txt");
        String assignments = Files.readString(filePath);
        int doublePairs = 0;

        for (String pair : assignments.split("\n")) {
            List<Integer> startEnd = new ArrayList<Integer>();
            for (String elf : pair.split(",")) {
                
                for(String number : elf.split( "-")){
                    startEnd.add(Integer.parseInt(number.trim()));
                }
                
            }
            if(((int)startEnd.get(0) <= (int)startEnd.get(2) && (int)startEnd.get(1) >= (int)startEnd.get(3)) || (int)startEnd.get(2) <= (int)startEnd.get(0) && (int)startEnd.get(3) >= (int)startEnd.get(1)){
                doublePairs++;
            }
        }
        System.out.println(doublePairs);
    }
}
