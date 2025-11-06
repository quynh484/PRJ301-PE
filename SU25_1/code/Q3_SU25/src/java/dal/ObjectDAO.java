/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Object;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Constants;

// Ctrl Shift -    : fold all
public class ObjectDAO extends DBContext {

    public Object get(String code) {
        String sql = "SELECT * FROM Customers WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Object(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            System.err.println("------------------------- E:  " + e);
        }
        System.out.println("get nothing!! ");

        return null;
    }

    public List<Object> sort(String sortName, String sortAddress) {
        List<Object> list = new ArrayList<>();

        String sql = "SELECT * FROM Customers ";

        // sort
        sql += "ORDER BY name "
                + (("desc".equalsIgnoreCase(sortName)) ? "DESC" : "ASC")
                + ", address "
                + (("desc".equalsIgnoreCase(sortAddress)) ? "DESC" : "ASC");

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Object(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4).equals(Constants.MALE_STR) ? "Male" : "Female",
                        rs.getString(5)
                ));
            }

            return list;
        } catch (Exception e) {
            System.err.println("------------------------- E:  " + e);
        }

        System.out.println(
                "get nothing!! ");

        return null;
    }

    // READ + SEARCH
    public List<Object> find(String keyword) {
        List<Object> list = new ArrayList<>();
        String sql = "SELECT * from Customers";

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql += " WHERE Name LIKE ?";
        }

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            if (keyword != null && !keyword.trim().isEmpty()) {
                ps.setString(1, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Object(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4).equals(Constants.MALE_STR) ? "Male" : "Female",
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            System.err.println("------------------------- E:  " + e);
        }
        System.out.println("find: " + list);
        return list;
    }

    // ADD
    public void add(Object o) {
        String sql = "INSERT INTO Customers VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(o.getCode()));
            ps.setString(2, o.getName());
            ps.setDate(3, new java.sql.Date(o.getDob().getTime()));
            ps.setString(4, o.getGender());
            ps.setString(5, o.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("------------------------- E:  " + e);
        }
        System.err.println("add!!!");

    }

    // UPDATE
    public void update(Object o) {
        String sql = "UPDATE Customers SET Name=?, DOB=?, Gender=?, Address=? WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, o.getName());
            ps.setDate(2, new java.sql.Date(o.getDob().getTime()));
            ps.setInt(3, Integer.parseInt(o.getGender()));
            ps.setString(4, o.getAddress());
            ps.setInt(5, Integer.parseInt(o.getCode()));
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("------------------------- E:  " + e);
        }
        System.err.println("update!!!");
    }

    // DELETE
    public void delete(String code) {
        String sql = "DELETE FROM Customers WHERE code=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("------------------------- E:  " + e);
        }
        System.err.println("delete!!!");

    }

    public static void main(String[] args) {
        ObjectDAO dao = new ObjectDAO();
        System.out.println(dao.find(""));
    }
}
