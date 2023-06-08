/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAOS.DAOS;

/**
 *
 * @author caokhanh
 */
public class Room {

    private int roomid;
    private String img;
    private String OwnerID;
    private int numberOfPeople;
    private int price;
    private int status;
    private String address;
    private String userID;
            
    public Room() {
    }

    public Room(int roomid, String img, int price, int numberOfPeople, String address, int status,String OwnerID) {
        this.roomid = roomid;
        this.img = img;
        this.OwnerID = OwnerID;
        this.numberOfPeople = numberOfPeople;
        this.price = price;
        this.status = status;
        this.address = address;
    }

    public Room(int roomid, String img, String OwnerID, int numberOfPeople, int price, int status, String address, String userID) {
        this.roomid = roomid;
        this.img = img;
        this.OwnerID = OwnerID;
        this.numberOfPeople = numberOfPeople;
        this.price = price;
        this.status = status;
        this.address = address;
        this.userID = userID;
    }
   public Room(Room r) {
        this(r.roomid, r.img, r.OwnerID, r.numberOfPeople, r.price, r.status, r.address,r.userID);
    }
     public Room(int uid) {
        this(new DAOS().getRoomById(uid));
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(String OwnerID) {
        this.OwnerID = OwnerID;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    @Override
    public String toString() {
        return "Room{" + "roomid=" + roomid + ", img=" + img + ", OwnerID=" + OwnerID + ", numberOfPeople=" + numberOfPeople + ", price=" + price + ", status=" + status + ", address=" + address + '}';
    }

    
}