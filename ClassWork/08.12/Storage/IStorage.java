package ru.kpfu.ClassWork4.Storage;
import ru.kpfu.ClassWork4.Models.*;
import java.io.FileNotFoundException;
public interface IStorage {

    void init() throws FileNotFoundException;
    User [] getUsers();
    Group [] getGroup();
    Subscription [] getSubscription();
    Members [] getMembers();
    User getUserByID(int id);
    Group getGroupByID(int id);

}
