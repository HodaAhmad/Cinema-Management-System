

package cinema1;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Payment {

    static int transactionNo;
    double total;
 
    
    Scanner enter = new Scanner(System.in);

    public int getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(int transactionNo) {
        this.transactionNo = transactionNo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Payment() {
    }

    public Payment(int transactionNo, double total) {
        this.transactionNo = transactionNo;
        this.total = total;
    }

    public String verifyCredit(String no) {

        Statement st;
        ResultSet rs;
        String connectionURL = "jdbc:derby://localhost:1527/Bank";

        try {
            Connection con;
            con = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            st = con.createStatement();
            String verify = "SELECT * FROM CREDIT WHERE creditno = '" + no + "'  ";
            rs = st.executeQuery(verify);

            if (rs.next()) {
                System.out.println("Verified");
                JOptionPane.showMessageDialog(null, "Credit Card " + rs.getInt("creditNo") + " is verified");
                return "Verified";
            } else {
                System.out.println("Not Verfied");
                JOptionPane.showMessageDialog(null, "Card is not verified, please Enter a valid Credit Card");
                
            }
            
            rs.close();
            st.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "not verified";
    }

    public String choosePaymentMethod() {
        System.out.print("Choose the payment method: \n" + "1 for Cash \n" + "2 for visa");
        int choice;
        choice = enter.nextInt();

        if (choice == 1) {
            return "Proceed to cash payment";
        } else if (choice == 2) {
            System.out.println("please enter your credit card number");
            String no;
            no = enter.next();
            verifyCredit(no);
        }
        return "Error";
    }
    public void insertIntoBank() {
        String url = "jdbc:derby://localhost:1527/Bank";
        try {
            Connection n = DriverManager.getConnection(url, "cinema", "cinema");
            Statement s = n.createStatement();
            String sql = "INSERT INTO CREDIT(creditno, creditname) VALUES ('11','mai')";
            s.executeUpdate(sql);
            s.close();
            n.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
        }
    }

}
