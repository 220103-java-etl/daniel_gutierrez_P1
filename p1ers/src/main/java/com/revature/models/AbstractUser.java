package com.revature.models;

import java.util.Objects;

public class AbstractUser {

    private Integer id;
    private String username;
    private String password;
    private Role role;


    public AbstractUser() {
        super();
    }

    public AbstractUser( String username, String password, Role role) {
        super();
//        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public AbstractUser(Integer id, String username, String password, Role role) {
        this( username, password, role);
        this.id = id;

    }


    public int getId() {

        return id;
    }
//
//    public void setId(int id) {
//
//        this.id = id;
//    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getRole() {

        return role.toString();
    }

    public void setRole(Role role) {

        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       User that = (User) o;
        return Objects.equals(id, that.getId()) && Objects.equals(username, that.getUsername()) && Objects.equals(password, that.getPassword()) && role .equals(that.getRole());
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AbstractUser that = (AbstractUser) o;
//        return Objects.equals(id, that.id) && Objects.equals(first_name, that.first_name) && Objects.equals(last_name, that.last_name) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && role == that.role;
//    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EmployeeUser that = (EmployeeUser) o;
//        return id == that.id && Objects.equals(username, that.username) && Objects.equals(password, that.password) && role == that.role;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}