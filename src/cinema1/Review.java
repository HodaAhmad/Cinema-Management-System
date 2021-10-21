/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Hoda Anis
 */
public class Review {
    
    int reviewID;
    Date reviewDate;
    String reviewDescription;
    static int reviewCount = 0;

    

    public Review( Date reviewDate, String reviewDescription) {
        reviewID = ++reviewCount;
        this.reviewDate = reviewDate;
        this.reviewDescription = reviewDescription;
    }

    public Review() {
        reviewID=++reviewCount;
    }
    
    public int getReviewID() {
        return reviewID;
    }
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
    
    public void writeReview(String desc){
        LocalDate ld=LocalDate.now();
        reviewDate = Date.valueOf(ld);
        reviewDescription=desc;
        
        
        String myUrl= "jdbc:derby://localhost:1527/cinemaa";
        
        try{
            Connection con=DriverManager.getConnection(myUrl,"cinema","cinema");
            Statement st=con.createStatement();
            String sql="INSERT INTO REVIEW(REVIEWID,REVIEWDATE,REVIEWDESCRIPTION) VALUES("+Character.getNumericValue(reviewID)+",'"+reviewDate+"','"+reviewDescription+"')";
            st.executeUpdate(sql);
            st.close();
            con.close();
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    //public Review updateReviewCount(){}
    
}
