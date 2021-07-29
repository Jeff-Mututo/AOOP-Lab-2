package aoop.lab.pkg1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class homePage extends Application{
    
    Stage homeStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 2 - HOME PAGE");
        primaryStage.setScene(homeScene(primaryStage));
        primaryStage.show();
    }
    
    public Scene homeScene(Stage primaryStage){
        //Create Button Nodes
        Button exampleBtn = new Button("EXAMPLE PAGE");
        Button movieBtn = new Button("MOVIES PAGE");
        Button custBtn = new Button("CUSTOMER PAGE");
        Button rentalBtn = new Button("RENTALS PAGE");
        
        //Preparing The GridPane
        GridPane gridPane = new GridPane();
        
        gridPane.setMinSize(600, 300);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        //Rendering Nodes onto the Grid
        gridPane.add(exampleBtn, 0, 0);
        gridPane.add(movieBtn, 1, 0);
        gridPane.add(custBtn, 2, 0);
        gridPane.add(rentalBtn, 3, 0);
        
        exampleBtn.setMinWidth(100);
        movieBtn.setMinWidth(100);
        custBtn.setMinWidth(100);
        rentalBtn.setMinWidth(100);
        
        //Event Handling
        exampleBtn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                examplePage examplePage = new examplePage();
                primaryStage.close();
                examplePage.start(examplePage.exampleStage);
            }
        }));
        movieBtn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                moviesPage moviesPage = new moviesPage();
                primaryStage.close();
                moviesPage.start(moviesPage.movieStage);
            }
        }));
        custBtn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                customerPage custPage = new customerPage();
                primaryStage.close();
                try {
                    custPage.start(custPage.customerStage);
                } catch (SQLException ex) {
                    Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));
        rentalBtn.setOnMouseClicked((new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                rentalPage rentalPage = new rentalPage();
                primaryStage.close();
                rentalPage.start(rentalPage.rentalsStage);
            }
        }));
        
        //Setting the scene
        Scene scene = new Scene(gridPane);
        
        return scene;
    }
    
}