package ru.kpfu.ClassWork4.Storage;
//import javafx.scene.Group;
import ru.kpfu.ClassWork4.Models.*;
public class MockStorage extends AbstractStorage {
    protected void init(){
        initUser();
        initGroup();
    }

    Group [] groupes = new Group[3];
        groupes[0] = new Group(1, "1", "123");
        groupes[1] = new Group(2, "1", "123");
        groupes[2] = new Group(3, "1", "123");
}
