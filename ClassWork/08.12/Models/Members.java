package ru.kpfu.ClassWork4.Models;
//import ru.kpfu.ClassWork4.Storage.*;
public class Members {
    private User user;
    private Group group;

    public Members(User user, Group group){
        this.user = user;
        this.group = group;
    }
    public User getUser(){
        return user;
    }
    public Group getGroup(){
        return group;
    }
    public String toString(){
        return user.getName() + "is a member of group " + group.getName();
    }
}