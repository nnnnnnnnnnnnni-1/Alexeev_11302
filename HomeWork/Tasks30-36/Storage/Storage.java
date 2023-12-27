package Storage;
import ru.kpfu.ClassWork4.Models.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Storage extends AbstractStorage {


    public void init(){
        try{
        initUsers(new File ("C:\\Informatics\\ru\\kpfu\\ClassWork4\\Files\\Users1.txt"));
        initSubscriptions(new File("C:\\Informatics\\ru\\kpfu\\ClassWork4\\Files\\Subscribtion.txt"));
        initGroups(new File("C:\\Informatics\\ru\\kpfu\\ClassWork4\\Files\\groups.txt"));
        initMembers(new File("C:\\Informatics\\ru\\kpfu\\ClassWork4\\Files\\members.txt"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initUsers(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = Integer.parseInt(scanner.nextLine());
        this.users = new User[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String[] str = scanner.nextLine().split(" ");
            User user = new User(Integer.parseInt(str[0]), str[1], str[2]);
            this.users[i] = user;
        }
        scanner.close();
    }

    public void initSubscriptions(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = scanner.nextInt();
        this.subscriptions = new Subscription[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String[] subs = scanner.nextLine().split(" ");
            User user1 = getUserById(Integer.parseInt(subs[0]));
            User user2 = getUserById(Integer.parseInt(subs[1]));
            Subscription onesub = new Subscription(user1, user2);
            this.subscriptions[i] = onesub;
        }
        scanner.close();
    }

    public void initGroups(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = scanner.nextInt();
        this.groups = new Group [size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String[] str = scanner.nextLine().split(" ");
            int id = Integer.parseInt(str[0]);
            User admin = getUserById(id);
            Group group = new Group(id, str[1], str[2], admin);
            this.groups[i] = group;
        }
        scanner.close();
    }
    public void initMembers(File filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(filename);
        int size = scanner.nextInt();
        this.members = new Members[size];
        scanner.nextLine();
        for (int i = 0; i < size; i++){
            String [] str = scanner.nextLine().split(" ");
            User user = getUserById(Integer.parseInt(str[0]));
            Group group = getGroupById(Integer.parseInt(str[1]));
            Members member = new Members(user, group);
            this.members[i] = member;
        }
        scanner.close();
    }

}