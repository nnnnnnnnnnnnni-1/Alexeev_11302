package ru.kpfu.ClassWork4;
import ru.kpfu.ClassWork4.Services.*;
import ru.kpfu.ClassWork4.Models.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main (String [] args) throws FileNotFoundException{
        Task1.mostSubsFromSameCityCounter();

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