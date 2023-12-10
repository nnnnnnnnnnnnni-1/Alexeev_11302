package ru.kpfu.ClassWork4.Services;

import ru.kpfu.ClassWork4.Models.Members;
import ru.kpfu.ClassWork4.Models.Subscription;
import ru.kpfu.ClassWork4.Models.User;

import java.util.Objects;

import ru.kpfu.ClassWork4.Models.Group;
import ru.kpfu.ClassWork4.Storage.*;
public class Service {
    
    private IStorage db;

    public Service(IStorage db){
        this.db = db;
    }
	
	
	public User [] getUsers() {
		return db.getUsers();
	}
	
	public Subscription [] getSubscription() {
		return db.getSubscription();
	}
	
    public Group [] getGroup(){
        return db.getGroup();
    }
	
	public Members [] getMembers() {
		return db.getMembers();
	}
	
    public String mostSubsFromSameCityCounter(){

        int count = 0;
        User main_user = null;
        for (int i = 0; i < getUsers().length; i++) {
            User user = getUsers()[i];
            String user_city = user.getCity();
            int temp_count = 0;
            for (int j = 0; j < getSubscription().length; j++) {
                if (getSubscription()[j].getSecond() == user) {
                    if (Objects.equals(getSubscription()[j].getSecond().getCity(), user_city)) {
                        temp_count++;
                    }
                }
            }
            if (temp_count > count) {
                count = temp_count;
                main_user = user;
            }
        }

        System.out.println(count + "->" + main_user.getName());
        return main_user.getName();
    }
    
    public void task2() {
		boolean check = true;
		Group [] groups = getGroup();
		Members [] members = getMembers();
		for (Group group : groups) {
			String group_city = group.getCity();
			check = true;
			for (int j = 0; j < members.length; j++) {
				if (Objects.equals(group_city, members[j].getUser().getCity())) {
					check = false;
				}
			}
			if (check) {
				System.out.println("Группа существует -> " + group.getName());
				break;
			}
		}
		if (!check) {
			System.out.println("Таких групп нет!");
		}
	}

	public void task3() {
		Group [] groups = getGroup();
		Members [] members = getMembers();
		Group [] result = new Group[groups.length];
		int count;
		int group_count;
		int temp = 0;
		for (int i = 0; i < groups.length; i++) {
			count = 0;
			group_count = 0;

			for (int j = 0; j < members.length; j++) {
				if (Objects.equals(members[j].getGroup(), groups[i])) {
					group_count++;
					if (!Objects.equals(members[j].getUser().getCity(), groups[i].getAdmin().getCity())) {
						count++;
					}
				}
			}

			if (count > (group_count / 2)) {
				result[temp] = groups[i];
				temp++;
			}
		}

		if (result.length > 0) {
			for (int i = 0; i < temp; i++) {
				System.out.println(result[i].getName());
			}
		} else {
			System.out.println("Таких групп нет!");
		}
	}
	public boolean checkFriendlyUsers(User user1, User user2){
		boolean t = false;
		for (Subscription sub : db.getSubscription()){
			//проверка подписан ли 1 на 2
			if (sub.getFirst().getId() == user2.getId()){
				if (sub.getSecond().getId() == user1.getId()){
					t = true;
					break;
				}
			}
		}
		if (!t){
			return false;
		}
		for (Subscription sub : db.getSubscription()){
			//подписан ли 2 на 1
			if (sub.getFirst().getId() == user1.getId()){
				if (sub.getSecond().getId() == user2.getId()){
					return true;
				}
			}
		}
		return false;
	}
	public boolean checkFriendlyGroup1(Group group){
		int size = 0;
		for (int i = 0; i < db.getMembers().length; i++){
			if (db.getMembers()[i].getGroup().equals(group)){
				size++;
			}
		}
		//System.out.println(size);
		User [] arrayMembers = new User[size];
		int k = 0;
		for (int i = 0; i < db.getMembers().length; i++){
			if (db.getMembers()[i].getGroup().equals(group)){
				arrayMembers[k] = db.getMembers()[i].getUser();
				k++;
			}
		}
		if (k==1){
			return false;
		}
		for (int i = 0; i < arrayMembers.length; i++){
			for (int j = i+1; j < arrayMembers.length; j++){
				if (!(checkFriendlyUsers(arrayMembers[i], arrayMembers[j]))){
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkFriendlyGroup2(Group group){
		int size = 0;
		for (int i = 0; i < db.getMembers().length; i++){
			if (db.getMembers()[i].getGroup().equals(group)){
				size++;
			}
		}
		//System.out.println(size);
		User [] arrayMembers = new User[size];
		int k = 0;
		for (int i = 0; i < db.getMembers().length; i++){
			if (db.getMembers()[i].getGroup().equals(group)){
				arrayMembers[k] = db.getMembers()[i].getUser();
				k++;
			}
		}
		if (k==1){
			return false;
		}
		for (int i = 0; i < k; i++){
			int t = 0;
			for (int j = i + 1; j < k; j++){
				if (checkFriendlyUsers(arrayMembers[i], arrayMembers[j])){
					t++;
					break;
				}
			}
			if (t==0){
				return false;
			}
		}
		return true;
	}
	public boolean checkFriendlyGroup3(Group group){
		int size = 0;
		for (int i = 0; i < db.getMembers().length; i++){
			if (db.getMembers()[i].getGroup().equals(group)){
				size++;
			}
		}
		User [] arrayMembers = new User[size];
		int k = 0;
		for (int i = 0; i < db.getMembers().length; i++){
			if (db.getMembers()[i].getGroup().equals(group)){
				arrayMembers[k] = db.getMembers()[i].getUser();
				k++;
			}
		}
		User [] q = new User[size];
		User [] colored = new User[size];
		int nextNeigh = 0;
		q[0] = arrayMembers[0];
		int nextRead = 0;
		while (nextRead == nextNeigh){
			colored[nextRead] = q[nextRead];
			nextRead++;
			for (User member : arrayMembers){
				if (checkFriendlyUsers(colored[nextRead-1], member)){
					nextNeigh++;
					q[nextNeigh] = member;
				}
			}
		}
		if (colored[size-1] == null){
			return false;
		}
		return true;
	}

	// public boolean checkFriendlyGroup3(Group g){
	// 	int nextNeigh = 0;
	// 	User [] q = new User[numOfMembers];
	// 	q[nextNeigh] = members[0];
	// 	nextNeigh++;
	// 	int nextRead = 0;
	// 	while (nextRead == nextNeigh){
	// 		colored[nextRead] = q[nextRead].getId();
	// 		nextRead++; 
	// 		//но до этого метода пока так:
	// 		for (User u : members){
	// 			if (isFriends(q[nextread], u)){

	// 			}
	// 		}
	// 	}
	// 	//метод выводит соседа из юзеров
	// }
}
