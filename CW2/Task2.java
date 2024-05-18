package CW2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    // Выяснить, верно ли, что среднее время вынашивания ребенка у курящих женщин меньше, чем среди некурящих женщин.
    public static void main(String[] args) {
        System.out.println(task());
    }
    public static boolean task(){
        ReadData r = new ReadData();
        List<BirthData> list = r.getData("C:\\Users\\admin\\Downloads\\BirthsKingCounty2001.txt");
        Map<Boolean, List<Byte>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for(BirthData x : list){
            map.get(x.isSmoker()).add(x.getGestation());
        }
        return map.get(true).stream()
                .mapToInt(o->o).average()
                .orElse(0) <
                map.get(false).stream().mapToInt(o->o)
                        .average().orElse(0);
    }
}
