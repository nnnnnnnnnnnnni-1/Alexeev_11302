package CW2;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task3 {
    public static void generateDataset(List<BirthData> data, String filename){
        try(OutputStream out = Files.newOutputStream(Paths.get(filename))){
            for(BirthData x : data){
                for(char c : x.getRace().toCharArray()){
                    out.write(c);
                }
                out.write(x.getEducation());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadData r = new ReadData();
        List<BirthData> list = r.getData("C:\\Users\\admin\\Downloads\\BirthsKingCounty2001.txt");
        generateDataset(list, "C:\\Users\\admin\\IdeaProjects\\ProjectForEnglish\\src\\main\\java\\CW2\\data.txt");
    }
}
