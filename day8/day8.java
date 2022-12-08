package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class day8 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/AOC-2022/day8/day8.txt");
        String lines = Files.readString(filePath);  
        int visibleTrees = 0;
        int lineSize = 99;
        int[][] Map2D = new int[lineSize][lineSize];
        boolean treeIsVisible;

        int row = 0;
        int column = 0;
        for (String line : lines.split("\n")) {
            column = 0;
            for (Character number : line.trim().toCharArray()) {
                Map2D[row][column] = Integer.parseInt(Character.toString(number));
                //System.out.println(Integer.toString(row) + Integer.toString(column) + " " + Map2D[row][column]);
                column++;
            }
            row++;
        }


        row = 0;
        for (int[] line : Map2D) {
            column = -1;
            for (int number : line) {
                column++;
                //System.out.println(Integer.toString(row) + Integer.toString(column) + " " + number);
                

                //Check Left
                treeIsVisible = true;
                for (int k = column - 1; k >= 0; k--) {
                  if (Map2D[row][k] >= number) {
                    treeIsVisible = false;
                    break;
                  }
                }

                if (treeIsVisible) {
                  visibleTrees++;
                  continue;
                }
                
                //Check Right
                treeIsVisible = true;
                for (int k = column + 1; k < line.length; k++) {
                  if (Map2D[row][k] >= number) {
                    treeIsVisible = false;
                    break;
                  }
                }
                if (treeIsVisible) {
                  visibleTrees++;
                  continue;
                }
                //Check Up
                treeIsVisible = true;
                for (int k = row - 1; k >= 0; k--) {
                  if (Map2D[k][column] >= number) {
                    treeIsVisible = false;
                    break;
                  }
                }
                if (treeIsVisible) {
                  visibleTrees++;
                  continue;
                }
                //Check Down
                treeIsVisible = true;
                for (int k = row + 1; k < Map2D.length; k++) {
                  if (Map2D[k][column] >= number) {
                    treeIsVisible = false;
                    break;
                  }
                }
                if (treeIsVisible) {
                  visibleTrees++;
                  continue;
                }




            }
            row++;
        }


        
        

        // for (String line : lines.split("\n")) {
        //     char[] chars = line.trim().toCharArray();
        //     if(lineSize == 0){
        //     lineSize = 2*line.length();
        //     }
        //     List<Integer> numbers = new ArrayList<Integer>();
        //     for (Character number : chars) {
        //         numbers.add(Integer.parseInt(Character.toString(number)));
        //     }
            
        //     int HighestLeft = 0;
        //     int HighestRight = 0;
        //     for (int treeSize : numbers) {
        //         if(treeSize > HighestLeft){
        //             HighestLeft = treeSize;
        //             visibleTrees++;
        //         }
        //     }
        //     int i = numbers.size() - 1;
        //    while(HighestRight < HighestLeft && i != 0){
        //         if(numbers.get(i) > HighestRight){
        //             HighestRight = numbers.get(i);
        //             visibleTrees++;
        //             i--;  
        //         }
        //         else{
        //         i--;
        //         }
        //    }
            
        //     //4 - 3 - 3
            
        // }
        // visibleTrees += lineSize;
        System.out.println(visibleTrees);
        
    }
}
