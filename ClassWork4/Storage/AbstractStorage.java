package ru.kpfu.ClassWork4.Storage;
import java.io.FileNotFoundException;

import ru.kpfu.ClassWork4.Models.*;

public abstract class AbstractStorage implements IStorage {

    protected User[] users; 
    protected Group[] groups;
    protected Subscription[] subscriptions;
    protected Members[] members;

    public abstract void init();

    public User [] getUsers(){
        return users;
    }
    public Group [] getGroup() {
		return groups;
	}
	public Subscription [] getSubscription() {
		return subscriptions;
	}
	public Members [] getMembers(){
        return members;
	}
    public User getUserById(int id){
        for (User user: users){
            if (id == user.getId()){
                return user;
            }
        }
        return null;
    }
    public Group getGroupById(int id){
        for (Group group : groups){
            if (id == group.getId()){
                return group;
            }
        }
        return null;
    }

}
