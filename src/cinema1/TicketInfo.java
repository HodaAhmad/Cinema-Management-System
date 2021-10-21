/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema1;

import java.sql.*;


/**
 *
 * @author Hoda Anis
 */
public class TicketInfo {

    int ticketID;
    String seatNo;
    double price;
    int screenNo;
    boolean imax;
    boolean vipSeat;

    

    public String getSeatNo() {
        return seatNo;
    }

    public TicketInfo(int ticketID, String seatNo, double price, int screenNo, boolean imax, boolean vipSeat) {
        this.ticketID = ticketID;
        this.seatNo = seatNo;
        this.price = price;
        this.screenNo = screenNo;
        this.imax = imax;
        this.vipSeat = vipSeat;
    }

    public void addTicket(String seatNo,int ticketID,double price, int screenNo, boolean imax, boolean vipSeat) {     //add in class diagram
        this.price=price;
        this.seatNo = seatNo;
        this.ticketID=ticketID;
        this.screenNo = screenNo;
        this.imax = imax;
        this.vipSeat = vipSeat;
        
        try{
        String ConnectionURL="jdbc:derby://localhost:1527/cinemaa";
        Connection conn=DriverManager.getConnection(ConnectionURL, "cinema", "cinema");
        Statement st= conn.createStatement();
        
        String sql = "INSERT INTO TICKETINFO(SEATNO,TICKETID,PRICE,SCREENNO,IMAX,VIPSEAT) VALUES('"+seatNo+"',"+ticketID+","+price+","+screenNo+","+imax+","+vipSeat+")";
        st.executeUpdate(sql);
        st.close();
        conn.close();
        }
        catch(SQLException ex){
        System.out.println("Connect failed /inserting TICKETINFO!");

        }
        
        
    }
    
    public String getSeatNo(int id) {     //add in class diagram

        
        String Seatno="";
        String ConnectionURL="jdbc:derby://localhost:1527/cinemaa";

        try {
            Connection conn=DriverManager.getConnection(ConnectionURL, "cinema", "cinema");
            String sql = "SELECT * FROM TICKETINFO WHERE TICKETID="+id;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Seatno=rs.getString("SEATNO");
            }
            
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return Seatno;
    }
    
    public TicketInfo() {
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getseatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(int screenNo) {
        this.screenNo = screenNo;
    }

    public boolean isImax() {
        return imax;
    }

    public void setImax(boolean imax) {
        this.imax = imax;
    }

    public boolean isVipSeat() {
        return vipSeat;
    }

    public void setVipSeat(boolean vipSeat) {
        this.vipSeat = vipSeat;
    }

    public String getseatNodata(int id) {
        String Seatno = "";
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            String sql = "SELECT * FROM TICKETINFO WHERE TICKETID=" + id;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Seatno = rs.getString("SEATNO");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return Seatno;
    }

    public double getPricedata(int id) {
        double price = 0;
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            String sql = "SELECT * FROM TICKETINFO WHERE TICKETID=" + id;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                price = rs.getDouble("Price");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return price;
    }

    public int getScreenNodata(int id) {
        int screenno = 0;
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            String sql = "SELECT * FROM TICKETINFO WHERE TICKETID=" + id;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                screenno = rs.getInt("screenno");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return screenno;
    }

    public boolean isImaxdata(int id) {
        boolean imax = false;
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            String sql = "SELECT * FROM TICKETINFO WHERE TICKETID=" + id;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                imax = rs.getBoolean("imax");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return imax;
    }

    public boolean isVipSeatdata(int id) {
        boolean Vipseat = false;
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            String sql = "SELECT * FROM TICKETINFO WHERE TICKETID=" + id;
            Statement st = conn.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Vipseat = rs.getBoolean("Vipseat");
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
        return Vipseat;
    }

    public String chooseSeat(String seatN, int noOfSeats) {
        return null;

    }

    public boolean checkSeatAvailability() {
        return false;

    }

    public String updateSeats() {
        return null;
    }
    
    public boolean checkTicketID(int t){
        return t==ticketID;
   }

}
