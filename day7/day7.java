import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class day7 {
    public static void main(String[] args) throws IOException {
        Path filePath = Path.of("C:/Users/stefa/AOC-2022/day7/day7.txt");
        String lines = Files.readString(filePath);
        Map<String, Integer> sizes = new HashMap<String, Integer>();
        String currentDir = ""; 
        var directories = new ArrayList<String>();

        //Split all the lines into single commands
        directories.add("/");
        currentDir = "/";
        sizes.put(currentDir, 0);

        for (String command : lines.split("\n")) {
            var words = new ArrayList<String>();
            //Split the command word for word and put them in a list.
            for (String word : command.split(" ")) {
                words.add(word.trim());
            }

        //If command starts with $
        if(words.get(0).equals("$")){
            
        //If command follows the $ with cd
            if(words.get(1).equals("cd")){
                
        //If command end with ..
                if(words.get(2).equals("..")){
                    sizes.put(directories.get(directories.size() - 2), sizes.get(directories.get(directories.size() - 2)) + sizes.get(currentDir));
                    directories.remove(currentDir);
                    currentDir = directories.get(directories.size() - 1);
                }
                else{
                    currentDir = words.get(2);
                    directories.add(currentDir);
                    sizes.put(currentDir, 0);
                }
            }
        }

        if(Character.isDigit(words.get(0).charAt(0))){
            sizes.put(currentDir, (sizes.get(currentDir) + Integer.parseInt(words.get(0))));
        }
    }

        //Go back to root folder after completing all the lines.
        while(directories.size() > 1){
            sizes.put(directories.get(directories.size() - 2), sizes.get(directories.get(directories.size() - 2)) + sizes.get(currentDir));
                    currentDir = directories.get(directories.size() - 2);
                    directories.remove(directories.size()-1);
        }
        
        //Answer for Part1
        int totalSum = 0;
        for (Map.Entry<String, Integer> entry : sizes.entrySet()) {
            if(entry.getValue() <= 100000){
                totalSum += entry.getValue();
            }

        }
        System.out.println(totalSum);
    }

}