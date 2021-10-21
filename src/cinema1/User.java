/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema1;

/**
 *
 * @author Hoda Anis
 */
public class User {
    String userName;
    int userID;
    String UserMail;
    int userPhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String UserMail) {
        this.UserMail = UserMail;
    }

    public int getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(int userPhone) {
        this.userPhone = userPhone;
    }

    public User() {
    }

    public User(String userName, int userID, String UserMail, int userPhone) {
        this.userName = userName;
        this.userID = userID;
        this.UserMail = UserMail;
        this.userPhone = userPhone;
    }
    
    public void updateUserName(String name){
    
    }
    
    public void updatePassword(String pass){
    
    }
    
}
