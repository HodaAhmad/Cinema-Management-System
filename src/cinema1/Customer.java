/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema1;

import java.util.ArrayList;

/**
 *
 * @author Hoda Anis
 */
public class Customer extends User{
    
    int creditCardNo;
    //private ArrayList<Customer> customer = new ArrayList<Customer>();

    public int getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(int creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public Customer() {

    }

    public Customer(int creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public Customer(int creditCardNo, String userName, int userID, String UserMail, int userPhone) {
        super(userName, userID, UserMail, userPhone);
        this.creditCardNo = creditCardNo;
    }
    
    public void deleteCustomer (int id){
    
    }
    
    public Customer searchCustomer(int id ){
    Customer b = new Customer();
    return b;
    }
}
