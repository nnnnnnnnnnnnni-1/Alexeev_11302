package Storage;
import Models.*;
import java.io.FileNotFoundException;
public interface IStorage {

    void init();
    User [] getUsers();
    Group [] getGroup();
    Subscription [] getSubscription();
    Members [] getMembers();
    User getUserById(int id);
    Group getGroupById(int id);

}
