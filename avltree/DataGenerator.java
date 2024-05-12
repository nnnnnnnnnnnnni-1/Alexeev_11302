package avltree;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataGenerator {
    int[] array;
    AVLTree tree;

    public DataGenerator() {
        array = new int[10000];
        tree = new AVLTree();
        Random generator = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            int setSize = set.size();
            int nextInt = generator.nextInt();
            set.add(nextInt);
            if (setSize == set.size()) {
                i--;
            } else {
                array[i] = nextInt;
            }
        }
    }

    public void zeroingOperations() {
        tree.operations = 0;
    }

    public void parse() {
        //добавить 10000
        //найти 100
        //удалить 1000
        try(PrintWriter writer = new PrintWriter(
                        new FileWriter(
                        Files.createFile(
                                Paths.get("C:\\Users\\admin\\IdeaProjects\\informatics3\\src\\avltree\\results.txt"))
                                .toFile()
                                .getPath()))){

            writer.print("Inserting:" + "\n");
            for (int i = 0; i < array.length; i++) {
                long start = System.nanoTime();
                tree.insert(array[i]);
                long end = System.nanoTime();
                writer.print(end - start + "," + tree.operations + "\n");
                zeroingOperations();
            }

            writer.print("Finding:" + "\n");
            for (int i = 0; i < 100; i++) {
                long start = System.nanoTime();
                tree.find(array[i]);
                long end = System.nanoTime();
                writer.print(end - start + "," + tree.operations + "\n");
                zeroingOperations();
            }

            writer.print("Deleting:" + "\n");
            for (int i = 0; i < 1000; i++) {
                long start = System.nanoTime();
                tree.delete(array[i]);
                long end = System.nanoTime();
                writer.print(end - start + "," + tree.operations + "\n");
                zeroingOperations();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DataGenerator dg = new DataGenerator();
        dg.parse();
    }
}
