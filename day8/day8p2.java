package day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class day8p2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/AOC-2022/day8/day8.txt");
        String lines = Files.readString(filePath);  
        int visibleTrees = 0;
        int lineSize = 99;
        int[][] Map2D = new int[lineSize][lineSize];

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
                int TreeView = 1;

                //Check Left
                int Steps = 0;
                for (int k = column - 1; k >= 0; k--) {
                    Steps++;
                  if (Map2D[row][k] >= number) {
                    TreeView *= Steps;
                    Steps = 0;
                    break;
                  }
                }

                //Check Right
                for (int k = column + 1; k < line.length; k++) {
                  Steps++;
                  if (Map2D[row][k] >= number) {
                    TreeView *= Steps;
                    Steps = 0;
                    break;
                  }
                }
                
                //Check Up
                for (int k = row - 1; k >= 0; k--) {
                  Steps++;
                  if (Map2D[k][column] >= number) {
                    TreeView *= Steps;
                    Steps = 0;
                    break;
                  }
                }

                //Check Down
                for (int k = row + 1; k < Map2D.length; k++) {
                  Steps++;
                  if (Map2D[k][column] >= number) {
                    TreeView *= Steps;
                    Steps = 0;
                    break;
                  }
                }


                if(TreeView >= visibleTrees){
                    visibleTrees = TreeView;
                }


            }
            row++;
        }

        System.out.println(visibleTrees);
        
    }
}
