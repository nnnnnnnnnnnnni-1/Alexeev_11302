package Storage;
import java.io.FileNotFoundException;
import Models.*;
public class MockStorage extends AbstractStorage {
	public void init(){
		initUsers();
		initGroups();
		initSubscription();
		initMembers();
	}
	public void initUsers() {
		this.users = new User[4];
		this.users[0] = new User(1, "Niyaz", "Liverpool");
		this.users[1] = new User(2, "Arsen", "ufa");
		this.users[2] = new User(3, "Krysti", "Liverpool");
		this.users[3] = new User(4, "Kostya", "Kazan");
	}
	public void initSubscription() {
		subscriptions = new Subscription[6];
		subscriptions[0] = new Subscription(users[0], users[2]);
		subscriptions[1] = new Subscription(users[1], users[2]);
		subscriptions[2] = new Subscription(users[2], users[1]);
		subscriptions[3] = new Subscription(users[3], users[0]);
		subscriptions[4] = new Subscription(users[2], users[1]);
		subscriptions[5] = new Subscription(users[1], users[0]);
	}
	public void initGroups() {
		groups = new Group[5];
		groups[0] = new Group(1, "FC RUBIN KAZAN", "Kazan", users[0]);
		groups[1] = new Group(2, "zenit", "spb", users[3]);
		groups[2] = new Group(3, "spartak", "moscow", users[1]);
		groups[3] = new Group(4, "ITIS", "Kazan", users[1]);
        groups[4] = new Group(5, "FC Liverpool", "Liverpool", users[0]);
	}
	public void initMembers() {
		members = new Members[8];
		members[0] = new Members(users[0], groups[1]); 
		members[1] = new Members(users[0], groups[3]);
		members[2] = new Members(users[1], groups[2]);
		members[3] = new Members(users[2], groups[0]);
		members[4] = new Members(users[1], groups[1]);
		members[5] = new Members(users[3], groups[0]);
        members[6] = new Members(users[1], groups[4]);
        members[7] = new Members(users[2], groups[4]);
	}
	
}
