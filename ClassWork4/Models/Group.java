package ru.kpfu.ClassWork4.Models;
public class Group {
    private int id;
    private String name;
    private String city;
    private User admin;

    public Group(int id, String name, String city, User admin) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.admin = admin;
    }

    public int getId(){
        return id;
    }
    public String getName (){
        return name;
    }
    public String getCity(){
        return city;
    }
    public User getAdmin(){
        return admin;
    }
}
