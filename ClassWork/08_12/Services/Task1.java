package ru.kpfu.ClassWork4.Services;
import ru.kpfu.ClassWork4.Main;
import ru.kpfu.ClassWork4.Models.*;
import java.util.Objects;

public class Task1 {

    public static String mostSubsFromSameCityCounter(){

        int count = 0;
        User main_user = null;
        for (int i = 0; i < Main.users.length; i++) {
            User user = Main.users[i];
            String user_city = user.city;
            int temp_count = 0;
            for (int j = 0; j < Main.subscription.length; j++) {
                if (Main.subscription[j].second == user) {
                    if (Objects.equals(Main.subscription[j].second.city, user_city)) {
                        temp_count++;
                    }
                }
            }
            if (temp_count > count) {
                count = temp_count;
                main_user = user;
            }
        }

        System.out.println(count + "->" + main_user.name);
        return main_user.name;
    } 
}
