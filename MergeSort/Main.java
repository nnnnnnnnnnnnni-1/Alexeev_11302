package MergeSort;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            try (PrintWriter writer = new PrintWriter(new FileWriter("src\\MergeSort\\results.txt", true))) {
                DataGenerator.setUp();
                writer.println(parse());
            } catch (IOException e) {
                System.out.println("что-то не так (запись результатов)" + e.getMessage());
            }
        }
    }
    public static String parse (){

        List<Integer> list = new ArrayList<>();
        try (FileInputStream reader = new FileInputStream("src\\MergeSort\\data.txt")){
            int b = reader.read();
            int number = 0;
            StringBuilder numberStr = new StringBuilder();

            while (b != -1) {
                if (b >= '0' && b <= '9' || b == '-') {
                    numberStr.append((char) b);
                } else if (b == ',') {
                    number = Integer.parseInt(numberStr.toString());
                    list.add(number);
                    numberStr.setLength(0);
                }
                b = reader.read();
            }

        } catch (IOException e){
            System.out.println("что-то не так (генерация чисел)"  + e.getMessage());
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++){
            array[i] = list.get(i);
        }

        MergeSort m = new MergeSort();
        long start = System.nanoTime();
        m.sortArray(array);
        long end = System.nanoTime();

        System.out.println(end - start + "," + m.countIterations + "," + array.length);
        int k = m.countIterations;
        m.countIterations = 0;
        return end - start + "," + k + "," + array.length;
    }
}
