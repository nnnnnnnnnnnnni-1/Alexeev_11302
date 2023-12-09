package ru.kpfu.ClassWork4.Storage;
//import ru.kpfu.ClassWork4.Services.*;
import ru.kpfu.ClassWork4.Models.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class Storage extends AbstractStorage {


    public void init() throws FileNotFoundException{
        initUser("C://Informatics//ru//kpfu//ClassWork4//Files//Users1.txt");
        initSubscription(new File("C://Informatics//ru//kpfu//ClassWork4//Files//Subscribtion.txt"));
        initGroup(new File("C://Informatics//ru//kpfu//ClassWork4//Files//groups.txt"));
        initMember(new File("C:\\Informatics\\ru\\kpfu\\ClassWork4\\Files\\members.txt"));
    }

    public void initUser(String filename) throws FileNotFoundException{
        String [][] usersArray = new String[10][3];
        File f = new File (filename);
        Scanner scanner = new Scanner(f);
        int size = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < size; i++){
            usersArray[i] = scanner.nextLine().split(" ");
            User user = new User((Integer.parseInt(usersArray[i][0])), usersArray[i][1], usersArray[i][2]);
            users[i] = user;
        }
        scanner.close();
    }

    public void initSubscription(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = scanner.nextInt();
        this.subscriptions = new Subscription[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String[] subs = scanner.nextLine().split(" ");
            User user1 = getUserByID(Integer.parseInt(subs[0]));
            User user2 = getUserById(Integer.parseInt(subs[1]));
            Subscription onesub = new Subscription(user1, user2);
            this.subscriptions[i] = onesub;
        }
        scanner.close();
    }

    public void initGroup(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = scanner.nextInt();
        this.groups = new Group [size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String[] str = scanner.nextLine().split(" ");
            int id = Integer.parseInt(str[0]);
            User admin = getUserByID(id);
            Group group = new Group(id, str[1], str[2], admin);
            this.groups[i] = group;
        }
        scanner.close();
    }

    public void initMember(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = scanner.nextInt();
        this.members = new Members[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String [] str = scanner.nextLine().split(" ");
            User user = getUserById(Integer.parseInt(str[0]));
            Group group = getGroupByID(Integer.parseInt(str[1]));
            Members member = new Members(user, group);
            this.members[i] = member;
        }
        scanner.close();
    }

}