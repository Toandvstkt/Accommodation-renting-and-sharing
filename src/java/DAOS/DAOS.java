/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Model.Account; 
import Model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class DAOS { 
    public boolean checkAccountExist(String UserID) throws SQLException {
        boolean check = true;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT USERID FROM Users "
                        + "WHERE UserID= ?  ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, UserID);
                rs = stm.executeQuery();
                
                while (rs.next()) {
                    check = false;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;

    }

    public Account signup(String user,String fullname,String email,String tel,String pass,String role) {
         
        Connection conn = null;
        PreparedStatement stm = null;
        Account acc=new Account();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO Users([UserID],[FullName],[Email] ,[Tel],[Password],[Role])"
                        + " VALUES ( ?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1,user);
                stm.setString(2, fullname);
                stm.setString(3, email);
                stm.setString(4,tel);
                stm.setString(5, pass);
                stm.setString(6, role);
                stm.executeUpdate();
                conn.close();
            }
        } catch (Exception e) {
        }
        return acc;
    }
 public Account login(String userID, String pass) {
        String query = "SELECT * FROM Users where userID=? and password=?";
Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, userID);
            stm.setString(2, pass);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

public List<Room> getAllRoom() {
        List<Room> list = new ArrayList<>();
        String query = "SELECT * FROM Rooms";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Room getRoomById(int id){
        String query = "SELECT * FROM Rooms where RoomID =?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
 
public void insert(int roomID, String img, int price, int numberOfPeople, String address, int status, String OwnerID) {

        String query = "INSERT [dbo].[Rooms] ([roomID], [imge], [price], [Number of People], [Address], [Status], [OwnerID], [Userid]) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stm = null; 
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);

            stm.setInt(1, roomID);
            stm.setString(2, img);
            stm.setInt(3, price);
            stm.setInt(4, numberOfPeople);
            stm.setString(5, address);
            stm.setInt(6, status);
            stm.setString(7, OwnerID);
            stm.setString(8, null);
            stm.executeUpdate();
        } catch (Exception e) {

        }
    }
  
    public List<Room> getRoomByOwner(String id) {
        List<Room> list = new ArrayList<>();
        String query = "SELECT * FROM Rooms where OwnerID=?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),rs.getInt(6),rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Room> getRoomByUserRenter(String id) {
        List<Room> list = new ArrayList<>();
        String query = "SELECT * FROM Rooms where userid!=? and ownerID=?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, "Null");
            stm.setString(2, id);
            rs = stm.executeQuery();
            while (rs.next()) {
              
                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getInt(4), rs.getInt(3),rs.getInt(6),rs.getString(5),rs.getString(8)));
            }   
        } catch (Exception e) {
        }
        return list;
    }
    public void delete(int id) {
        String query = "delete from Rooms where RoomID=?";Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (Exception e) {

        }
    }
    public Room getRoomUpdateById(String id) {

        String query = "select*from Rooms where roomID=?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getInt(4), rs.getInt(3),rs.getInt(6),rs.getString(5),rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public Room checkRoomIDExist(int id) {

        String query = "select*from Rooms where roomID=?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getInt(4), rs.getInt(3),rs.getInt(6),rs.getString(5),rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void update(int roomID, String img, int price, int numberOfPeople, String address, int status, String OwnerID,String userID) {
        String query = "UPDATE [dbo].[Rooms]\n"
                + "   SET [imge] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[Number of People] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Status] = ?\n"
                + "      ,[OwnerID] = ?\n"
                + "      ,[Userid] = ?\n"
                + " WHERE roomID=?";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            stm.setString(1, img);
            stm.setInt(2, price);
            stm.setInt(3, numberOfPeople);
            stm.setString(4, address);
            stm.setInt(5, status);
            stm.setString(6, OwnerID);
            stm.setString(7, userID);
            stm.setInt(8, roomID);
            stm.executeUpdate();
        } catch (Exception e) {

        }
    }
    public List<Room> searchRoom(int status, String price, String address) {
        List<Room> list = new ArrayList<>();
        String query = "SELECT * FROM Rooms Where 1 = 1";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        query += " And Status = " + status;

        if (!price.equalsIgnoreCase("0")) {
            switch (price) {
                case "1":
                    query += " And Price < 200";
                    break;
                case "2":
                    query += " And Price between 200 and 300";
                    break;
                case "3":
                    query += " And Price between 300 and 400";
                    break;
                case "4":
                    query += " And Price > 400";
                    break;
            }
        }

        if (!address.equalsIgnoreCase("0")) {
            switch (address) {
                case "1":
                    query += " And Address like '%i Ch%'";
                    break;

                case "2":
                    query += " And Address like '%Thanh Kh%'";
                    break;

                case "3":
                    query += " And Address like '%nh S%'";
                    break;

                case "4":
                    query += " And Address like '%n ch%'";
                    break;

                case "5":
                    query += " And Address like '%a Vang%'";
                    break;

                case "6":
                    query += " And Address like '%m L%'";
                    break;

                case "7":
                    query += " And Address like '%n Tr%'";
                    break;
            }
        }

        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getInt(4), rs.getInt(3),rs.getInt(6),rs.getString(5),rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Room> getAllRoom(int status) {
        List<Room> list = new ArrayList<>();
        String query = "SELECT * FROM Rooms Where userid is NULL";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        query += " And Status = " + status;
        try {
            conn = DBUtils.getConnection();
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getInt(4), rs.getInt(3),rs.getInt(6),rs.getString(5),rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void updateUserID(int roomid, String userid) {
        try ( Connection con = DBUtils.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("Update Rooms set userid=? where roomid=? ");
            stmt.setString(1, userid);
            stmt.setInt(2, roomid);
            int rs = stmt.executeUpdate();
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    }
