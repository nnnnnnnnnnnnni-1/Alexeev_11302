package ru.kpfu.ClassWork4.Services;

import ru.kpfu.ClassWork4.Models.Members;
import ru.kpfu.ClassWork4.Models.Subscription;
import ru.kpfu.ClassWork4.Models.User;
import ru.kpfu.ClassWork4.Storage.*;
public class Service {
    
    private IStorage db;

    public Service(IStorage db){
        this.db = db;
    }
	
	
	public User [] getUsers() {
		return db.getUsers();
	}
	
	public Subscription [] getSubs() {
		return db.getSubscription();
	}
	
	public Group [] getGroups() {
		return db.getGroup();
	}
	
	public Members [] getMembers() {
		return db.getMembers();
	}
	
}
