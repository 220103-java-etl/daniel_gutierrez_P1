package com.revature;

import com.revature.models.AbstractUser;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

import java.util.List;
import java.util.Scanner;

public class Driver {

    private static Scanner scanner = new Scanner(System.in);
    private static UserDAO userDAO = new UserDAO();


    public static void main(String[] args) {

        //create a user

//        User u = new User (1, "@dannieeeg", "baddieee", Role.FINANCE_MANAGER);






        List<User> usersone = userDAO.getAll();
        System.out.println(usersone);


    }
}