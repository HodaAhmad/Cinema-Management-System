
package cinema1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;


public class Reservation {
    int reservationNo;
    String reservationDate;
    ArrayList <Movie> movie;

    Reservation() {
        
    }

    public int getReservationNo() {
       
        
        
        return reservationNo;
   
    }

    public void setReservationNo(int reservationNo) {
        this.reservationNo = reservationNo;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ArrayList<Movie> getMovie() {
        return movie;
    }

    public void setMovie(ArrayList<Movie> movie) {
        this.movie = movie;
    }

    public Reservation(int reservationNo, String reservationDate, ArrayList Movie) {
        
        this.reservationNo=reservationNo;
        this.reservationDate=reservationDate;
        this.movie=Movie;
    }
    
    public void deleteReservation(int id){
    
    }
    
    
    
    public void updateReservation(int id){
    
    }
    
    public void sendConfirmationMail(){
    
    }
    
   
    public void makeReservation (int reservationNo ,String reservationDate){ //new
       
        this.reservationNo=reservationNo;
        this.reservationDate=reservationDate;
      
        String ConnectionURL="jdbc:derby://localhost:1527/HODA";
        
        try {
        Connection conn = DriverManager.getConnection(ConnectionURL, "HODA", "HODA");
        Statement st=conn.createStatement();
        String sql = "INSERT INTO RESERVATION (RESERVATIONNO,RESERVATIONDATE) VALUES ( "+reservationNo+",  '"+reservationDate+"')";
        st.executeUpdate(sql);
        st.close(); 
        conn.close(); 
        }
       catch (SQLException ex)
       {System.out.println("Connect failed ! ");}
    
    }
}