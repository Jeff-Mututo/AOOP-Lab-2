package aoop.lab.pkg1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class moviesPage extends Application{
    Stage movieStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 2 - Movie Page");
        primaryStage.setScene(movieScene());
        primaryStage.show();
    }
    
    public Scene movieScene(){
        // =======================================================================================================
        // Node Creation
        // =======================================================================================================
    
        // Preparing The GridPane
        GridPane gridPane = new GridPane();
        
        // Create TextLabel Nodes
        Text txt1 = new Text("Genre:");
        Text txt2 = new Text("Name:");
        Text txt3 = new Text("Registered:");
        
        // Create ComboBox Nodes
        ComboBox combo1 = new ComboBox();
        ObservableList<String> movieGenres = FXCollections.observableArrayList();
        ComboBox combo2 = new ComboBox();
        ObservableList<String> registeredMovies = FXCollections.observableArrayList();
        
        // Create TextField Nodes
        TextField txtField1 = new TextField();
        
        // Create Button Nodes
        Button btn1 = new Button("Save Movie");
        Button btn2 = new Button("Remove Movie");
        
        // =======================================================================================================
        // Event Handling
        // =======================================================================================================
        
        EventHandler<MouseEvent> fetchGenres = (MouseEvent e) -> {
            combo1.getItems().clear();
            movieGenres.clear();
            
            try {
                SystemMethods.fetchMovieGenres(combo1, movieGenres);
            } catch (SQLException ex) {
                Logger.getLogger(customerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        EventHandler<MouseEvent> addMovie = (MouseEvent e) -> {
            try {
                SystemMethods.addMovie((String) combo1.getValue(), txtField1.getText());
            } catch (SQLException ex) {
                Logger.getLogger(moviesPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        EventHandler<MouseEvent> fetchMovies = (MouseEvent e) -> {
            combo2.getItems().clear();
            registeredMovies.clear();
            
            try {
                SystemMethods.fetchRegisteredMovies(combo2, registeredMovies);
            } catch (SQLException ex) {
                Logger.getLogger(customerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        EventHandler<MouseEvent> deleteMovie = (MouseEvent e) -> {
            try {
                SystemMethods.deleteMovie((String) combo2.getValue());
            } catch (SQLException ex) {
                Logger.getLogger(SystemMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        combo1.setOnMouseClicked(fetchGenres);
        combo2.setOnMouseClicked(fetchMovies);
        btn1.setOnMouseClicked(addMovie);
        btn2.setOnMouseClicked(deleteMovie);
        
        // =======================================================================================================
        // GridPane Rendering
        // =======================================================================================================
        
        // Configuring GridPane
        gridPane.setMinSize(400, 400);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
        // Rendering Nodes On The Grid
        gridPane.add(txt1, 0, 0);
        gridPane.add(combo1, 1, 0);
        
        gridPane.add(txt2, 0, 1);
        gridPane.add(txtField1, 1, 1);
        gridPane.add(btn1, 1, 2);
        
        gridPane.add(txt3, 0, 3);
        gridPane.add(combo2, 1, 3);
        gridPane.add(btn2, 1, 4);
        
        // =======================================================================================================
        // Node Styling
        // =======================================================================================================
        
        // Sizing Nodes
        combo1.setMinWidth(200);
        combo1.setVisibleRowCount(5);
        combo2.setMinWidth(200);
        combo2.setVisibleRowCount(5);
        txtField1.setMinWidth(200);
        btn1.setMinWidth(200);
        btn2.setMinWidth(200);
        
        // Styling Nodes
        combo1.setStyle("-fx-border-color: blue;");
        combo2.setStyle("-fx-border-color: blue;");
        txtField1.setStyle("-fx-border-color: blue;");
        btn1.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 10pt;");
        btn2.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 10pt;");
        
        // Setting The Scene
        Scene scene = new Scene(gridPane);
        
        return scene;
    }
    
}