package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

    static ConnectionFactory cu = ConnectionFactory.getInstance();
    //instance fields

    private Integer id;
    private String author;
    private String resolver;
    private Double amount;
    private Status status;
//    status should return pending, approved, or denied
//      Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
//public Reimbursement(int id, Status status, User author, User resolver, double amount) {
//    super(id, status, author, resolver, amount);

//    public Optional<Reimbursement> getById(int id) {
//
//        String sql = "select * from reimbursementsone where id = ?";
//
//        try (Connection conn = cu.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                Reimbursement reimbursement = new Reimbursement(
//                        rs.getInt("id"),
//                        Status.valueOf(rs.getString("status")),
//                        rs.getString("user"),
//                        rs.getString("user"),
//                        rs.getDouble("amount"));
//
//                return Optional.of(reimbursement);
//            }
//            System.out.print("Success!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
//    public List<Reimbursement> getByStatus(Status status) {
//        List<Reimbursement> reimbursements = new ArrayList<>();
//
//        String sql = "select * from reimbursementsone where status=?";
//
////        DatabaseMetaData cu = null; this is just in case something goes wrong w the connection factory
//        try (Connection conn = cu.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Reimbursement r = new Reimbursement(
//                        rs.getInt("id"),
//                        Status.valueOf(rs.getString("role")),
//                        rs.getString("author"),
//                        rs.getString("resolver"),
//                        rs.getDouble("amount")
//                );
//                reimbursements.add(r);
//            }
//            return reimbursements;
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getLocalizedMessage());
//            e.printStackTrace();
//        }
//
//        return Collections.emptyList();
//    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {

        String sql = "update reimbursementsone set author = ?, resolver = ?, amount = ?, where id = ?";
        DatabaseMetaData cu = null;  //daniel ask about this databasemetadata for cu and whats going on with your connection factory
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, String.valueOf(unprocessedReimbursement.getStatus()));
            ps.setObject(1, unprocessedReimbursement.getStatus());
            ps.setObject(2, unprocessedReimbursement.getResolver());
            ps.setDouble(3, unprocessedReimbursement.getAmount());


            ps.executeUpdate();
            return unprocessedReimbursement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Reimbursement create(Reimbursement unprocessedReimbursement) {

        String sql = "insert into reimbursementsone (r_id, status, author, amount) values (default, ?,?,?)";
         //daniel ask about this databasemetadata for cu and whats going on with your connection factory
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unprocessedReimbursement.getStatus().toString());
            ps.setString(2, unprocessedReimbursement.getAuthor().getUsername());
//
            ps.setDouble(3, unprocessedReimbursement.getAmount());


            ps.executeUpdate();
            return unprocessedReimbursement;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}