package ru.kpfu.ClassWork4;
import ru.kpfu.ClassWork4.Services.*;
import ru.kpfu.ClassWork4.Models.*;
import ru.kpfu.ClassWork4.Storage.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main (String [] args){

        IStorage db1 = new MockStorage();
        db1.init();
        if (db1.getUsers() == null){
            System.out.println("sukaaaaaa");
        } else {
            System.out.println(db1.getUsers().length);
        }
        // IStorage db2 = new Storage();
        // db2.init();
        Service ser1 = new Service(db1);

        System.out.println(ser1.checkFriendlyUsers(db1.getUsers()[1], db1.getUsers()[2]));
        System.out.println(ser1.checkFriendlyGroup1(db1.getGroupById(3)));
    }
}
            
// {{1 2} {1 3} {1 6} {2 1} {2 4} {2 8} {3 4} {3 6} {3 7}} {1:name:city 2:name:city 3:name:city 4:name:city 5:name:city 6:name:city 7:name:city 8:name:city }

    //     }
    //     scanner.close();
    // }


/*
 * group.getAdmin.getName
 * можно прописать методы по поиску по id 
 * services (функции работы с данными) <- storage (database)(массивы с данными, метод получения юзера по айди и тд) <- models (классы 
 * объектов которые будут храниться в storage)
 * методы не статичны потому что может быть много баз данных
 */