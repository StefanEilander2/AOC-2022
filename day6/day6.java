package day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class day6 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/GitHub/AOC 2022/day6/day6.txt");
        String signal = Files.readString(filePath);

        int length = 14;
        var characters = signal.toCharArray();

        for(int i = 0; i <= characters.length - length; i++){
            var data = Arrays.copyOfRange(characters, i, i+length);
            boolean hasDups = false;
            for (int j = 0; j < data.length; j++) {
                for (int k = 0; k < data.length; k++) {
                    if (data[j] == (data[k]) && k != j) {
                        hasDups = true;
                    }
                }
            }
            if(!hasDups){
                System.out.println(i+length);
                break;
            }
        }
        

    }
}
