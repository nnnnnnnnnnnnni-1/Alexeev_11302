package CW2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//task0
public class ReadData {
    private List<BirthData> data;
    public void read(String fileName) {
        data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] array = line.split("\\s+");
                data.add(makeObject(array));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BirthData makeObject(String[] array) {
        return new BirthData(array[0].charAt(0), Byte.parseByte(array[1]), Byte.parseByte(array[2]),
                array[3], Byte.parseByte(array[4]), array[5].equals("1"), Short.parseShort(array[6]),
                Byte.parseByte(array[7]), Byte.parseByte(array[8]), array[9].equals("1"),
                array[10].equals("1"), array[11].equals("Y"), array[12].equals("Y"),
                Short.parseShort(array[13]), Short.parseShort(array[14]), Byte.parseByte(array[15]), Byte.parseByte(array[16]));
    }

    public List<BirthData> getData(String fileName) {
        read(fileName);
        return data;
    }

}
