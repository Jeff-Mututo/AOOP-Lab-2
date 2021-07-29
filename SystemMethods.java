package aoop.lab.pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class SystemMethods {
    // =======================================================================================================
    // General Methods
    // =======================================================================================================
    public static Connection connectDB(){
        // db parameters
        String url = "jdbc:mysql://localhost:3306/lab2db";
        String username = "root";
        String password = "";
        
        //LOAD DRIVER
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        //CONNECT TO DATABASE
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    // =======================================================================================================
    // Customer Page Methods
    // =======================================================================================================
        
    public static void fetchRegisteredCustomers(ComboBox combo1, ObservableList<String> registeredList) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();

        String query = "SELECT name FROM registered_customers";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            registeredList.add(rs.getString("name"));
        }
        
        combo1.setItems(registeredList);

        conn.close();
    }
    
    public static void registerCustomer(String name, String phone, String email) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();

        String query = "INSERT INTO registered_customers (name, phone, email) VALUES ('"+name+"', '"+phone+"', '"+email+"');";
        
        st.executeUpdate(query);
        
        System.out.println("Customer Added: " + name + phone + email);
        
        conn.close();
    }
    
    public static void deleteCustomer(String name) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();

        String query = "DELETE FROM registered_customers WHERE name='"+name+"'";
        
        st.executeUpdate(query);
        
        System.out.println("Customer Removed: " + name);
        
        conn.close();
    }
    
    // =======================================================================================================
    // Movie Page Methods
    // =======================================================================================================
    
    public static void fetchMovieGenres(ComboBox combo, ObservableList<String> list) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();

        String query = "SELECT genre FROM movie_genres";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            list.add(rs.getString("genre"));
        }
        
        combo.setItems(list);

        conn.close();
    }
    
    public static void addMovie(String genre, String movieName) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();
        
        String query = "INSERT INTO registered_movies (genre, movie_name) VALUES ('"+genre+"', '"+movieName+"');";
        
        st.executeUpdate(query);
        
        System.out.println("Movie Added: " + genre + ": " + movieName);
        
        conn.close();
    }
    
    public static void fetchRegisteredMovies(ComboBox combo, ObservableList<String> list) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();

        String query = "SELECT * FROM registered_movies";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            list.add(rs.getString("genre")+ ": " +rs.getString("movie_name"));
        }
        
        combo.setItems(list);

        conn.close();
    }
    
    public static void deleteMovie(String movieName) throws SQLException{
        Connection conn = connectDB();
        
        Statement st = conn.createStatement();

        String query = "DELETE FROM registered_movies WHERE movie_name='"+movieName+"'";
        
        st.executeUpdate(query);
        
        System.out.println("Movie Removed: " + movieName);
        
        conn.close();
    }
    
    // =======================================================================================================
    // Rental Page Methods
    // =======================================================================================================
}