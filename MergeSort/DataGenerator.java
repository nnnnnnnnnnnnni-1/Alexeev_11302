package MergeSort;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {
    public static void setUp() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src\\MergeSort\\data.txt"))){

            Random random = new Random();
            int min = 100, max = 10000;
            int totalRange = random.nextInt(max - min + 1) + 1;

            for (int j = 0; j < totalRange; j++) {
                int randomNumber = random.nextInt();
                writer.print(randomNumber);
                if (j != totalRange - 1) writer.print(",");
            }
            writer.println();

            //System.out.println("well done lad");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
