package CW2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//task1
public class Statistic {
    public void countStatistic() {
        Map<String, List<Short>> map = new HashMap<>();
        ReadData r = new ReadData();
        List<BirthData> list = r.getData("C:\\Users\\admin\\Downloads\\BirthsKingCounty2001.txt");
        for(BirthData x : list){
            if(map.containsKey(x.getRace())){
                map.get(x.getRace()).add(x.getBirthWeight());
            } else {
                List<Short> tmp = new ArrayList<>();
                tmp.add(x.getBirthWeight());
                map.put(x.getRace(), tmp);
            }
        }

        Map<String, Double> collect = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, n -> n.getValue().stream().mapToInt(o->o).average().orElse(0)));

        collect.forEach((key, value) -> System.out.println("Раса: " + key + ", Средний вес: " + value));
    }

    public static void main(String[] args) {
        Statistic s = new Statistic();
        s.countStatistic();
    }
}
