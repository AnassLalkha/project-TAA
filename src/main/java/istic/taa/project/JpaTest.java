package istic.taa.project;

import istic.taa.project.dao.impl.ActivityDaoImpl;
import istic.taa.project.dao.impl.UserDaoImpl;
import istic.taa.project.model.Activity;
import istic.taa.project.model.User;

public class JpaTest {
    public static void main(String[] args) {
        Activity activity = new Activity();
        new ActivityDaoImpl().create(activity);
        UserDaoImpl dao = new UserDaoImpl();
        User u = dao.getUserByCredential("inoH", "password");
        System.out.println("qsdqsdqs");
    }
}

