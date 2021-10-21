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
public class Admin extends User{
    String workingHrs;

    public String getWorkingHrs() {
        return workingHrs;
    }

    public void setWorkingHrs(String workingHrs) {
        this.workingHrs = workingHrs;
    }

    public Admin(String workingHrs) {
        this.workingHrs = workingHrs;
    }

    public Admin() {
    }

    public Admin(String workingHrs, String userName, int userID, String UserMail, int userPhone) {
        super(userName, userID, UserMail, userPhone);
        this.workingHrs = workingHrs;
    }
    
    public Admin searchAdmin (int id){
    Admin a = new Admin();
    return a;
    }
}
