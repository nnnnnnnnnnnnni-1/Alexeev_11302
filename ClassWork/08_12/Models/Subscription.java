package ru.kpfu.ClassWork4.Models;

public class Subscription {
    private User first;
    private User second;
    public Subscription(User first, User second){
        this.first = first;
        this.second = second;
    }
    public User getFirst(){
        return first;
    }
    public User getSecond(){
        return second;
    }
    public String toString(){
        return second + "is subscriber of " + first;
    }
}
