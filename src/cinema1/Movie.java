/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoda Anis
 */
public class Movie {

    Movie mov;

    int movieID;
    String movTitle;
    String description;
    String ageLimit;
    String movGenre;
    ArrayList<Movie> m = new ArrayList<Movie>();

    public Movie() {
    }

    public Movie(int movieID, String movTitle, String description, String ageLimit, String movGenre) {
        this.movieID = movieID;
        this.movTitle = movTitle;
        this.description = description;
        this.ageLimit = ageLimit;
        this.movGenre = movGenre;

    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovTitle() {
        return movTitle;
    }

    public void setMovTitle(String movTitle) {
        this.movTitle = movTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getMovGenre() {
        return movGenre;
    }

    public void setMovGenre(String movGenre) {
        this.movGenre = movGenre;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieID=" + movieID + ", movTitle=" + movTitle + ", description=" + description + ", ageLimit=" + ageLimit + ", movGenre=" + movGenre + '}';
    }

    public String checkMovieAvailability() {
        return "yeah";
    }

//  public String selectMovie(String name){ }
    public void updateSearchHistory() {

    }

    public void recommendMovies(String genre) {

        Statement st;
        ResultSet rs;
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {

            Connection con = DriverManager.getConnection(connectionURL, "cnema", "cinema");
            st = con.createStatement();
            String searchQuery = "SELECT * FROM Movie WHERE movGenre LIKE '%" + genre + "%'";
            rs = st.executeQuery(searchQuery);

            while (rs.next()) {

                System.out.println(rs.getInt("movieID") + "\t" + rs.getString("movTitle") + "\t" + rs.getString("description") + "\t" + rs.getString("ageLimit") + "\t" + rs.getString("movGenre"));
                JOptionPane.showMessageDialog(null, "Recommended Movie is: " + rs.getInt("movieID") + " " + rs.getString("movTitle"));

            }
        } catch (SQLException ex) {
            System.out.println("error!!!");
        }

    }

    // public Movie selectRecommendedMovie(String name){  }
    public void displayMovie() {
        for (int i = 0; i < m.size(); i++) {
            System.out.println("\n ID:" + (i + 1) + " " + m.get(i));
        }

    }

    public void insertMovieRecord(int id, String name, String desc, String age, String genre) throws SQLException {
        try {
            String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            Statement st = conn.createStatement();
            String sql = "INSERT INTO MOVIE(movieID,movTitle,description,agelimit,movGenre)VALUES(" + id + ",'" + name + "','" + desc + "','" + age + "','" + genre + "')";
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteMovieRecord(int ID) {
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {

            Connection conn = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            String sql = "DELETE FROM Movie WHERE movieID = " + ID + "";
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connect failed ! ");
        }
    }

    public void searchMovies(String name) {

        Statement st;
        ResultSet rs;
        String connectionURL = "jdbc:derby://localhost:1527/cinemaa";
        try {

            Connection con = DriverManager.getConnection(connectionURL, "cinema", "cinema");
            st = con.createStatement();
            String searchQuery = "SELECT * FROM Movie WHERE movTitle LIKE '%" + name + "%'";
            rs = st.executeQuery(searchQuery);

            if (rs.next()) {
                System.out.println(rs.getInt("movieID") + "\t" + rs.getString("movTitle") + "\t" + rs.getString("description") + "\t" + rs.getString("ageLimit") + "\t" + rs.getString("movGenre"));
                JOptionPane.showMessageDialog(null, "Movie " + rs.getString("movTitle") + " is found");
            } else {
                JOptionPane.showMessageDialog(null, "Movie is not found");
            }

        } catch (SQLException ex) {
            System.out.println("error!!");
        }

    }

}
