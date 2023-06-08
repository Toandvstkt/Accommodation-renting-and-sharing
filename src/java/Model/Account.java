/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class Account {
    private String userID;
    private String fullName;
    private String email;
    private String tel;
    private String password;
    private int role;

    public Account() {
    }

    public Account(String userID, String fullName, String email, String tel, String password, int role) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", fullName=" + fullName + ", email=" + email + ", tel=" + tel + ", password=" + password + ", role=" + role + '}';
    }
    
}