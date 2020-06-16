// Create a function that takes a java source file path (e.g. "src.java") as an input, 
// reads the given file, and remove the singe line comments from it. It should write the comment-free
// code to the original file.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DeleteTheComments{

    public static void main(String[]args){
        deleteComments("level-test-basic-exam/delete-the-comments/source/TaskManager.java");
    }

    public static void deleteComments(String source){
        Path path = Paths.get(source);

        try{
            List<String> lines = Files.readAllLines(path);

            int index, length;
            for (int i = 0; i < lines.size(); i++) {

                if(lines.get(i).contains("//")) {
                    index = lines.get(i).indexOf("//");
                    if(index == 0) lines.remove(i);
                    else lines.set(i,lines.get(i).substring(0, index));
                }
            }

            Files.write(Paths.get("out/production/TrialExamKatarina/output.txt"), lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}