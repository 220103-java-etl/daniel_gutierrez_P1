package com.revature.repositories;

//import com.revature.models.AbstractUser;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements GenericDAO<User> {
    List<User> user = new ArrayList<User>();
    ConnectionFactory cu = ConnectionFactory.getInstance();

    @Override
    public User create(User user) {
        String sql = "insert into usersone values (default,?,?,?) returning *";
        try (Connection conn = cu.getConnection()) {


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());


            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               User e = new User(

                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").replace(" ", "").toUpperCase())

                );
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from usersone where id = ?";

        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //Whatever statement we create we want it to return from the table
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();

        String sql = "select * from usersone";


        //try with resources -> used to automatically close resources after the try/catch/finally
        try (Connection conn = cu.getConnection()) {
            //Prepare statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //execute the statement and save the result the set into object
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {

               User e = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").replace(" ", "_").toUpperCase())
//                        rs.getString("role")
                );
                users.add(e);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User abstractUser) {
        String sql = "update usersone set username = ?, password = ?, role = ? where id = ?";
        try(Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, abstractUser.getUsername());
            ps.setString(2, abstractUser.getPassword());
//            ps.setString(3, user.getUsername());
//            ps.setString(4, user.getPassword());

            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void delete(Integer id) {
        String sql = "delete from usersone where id = ?";
        try(Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User getByUsername(String Username) {
        String sql = "select * from usersone where username = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").replace(" ", "_").toUpperCase())

                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // try-with-resources - automatically closes resources after execution
//        finally {
//            conn.close();
//        }

        return null;

    }

//        return  Username;
    }


