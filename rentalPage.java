package aoop.lab.pkg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class rentalPage extends Application{
    
    Stage rentalsStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 2 - Rentals Page");
        primaryStage.setScene(rentalScene());
        primaryStage.show();
    }
    
    public Scene rentalScene(){
        //Creating TextLabels Nodes
        Text customerLabel = new Text("Customer:");
        Text genreLabel = new Text("Genre:");
        Text movieLabel = new Text("Movies:");
        Text borrowLabel = new Text("Borrowed:");
        Text returnLabel = new Text("Returned:");
        
        //Creating ComboBox Nodes
        ComboBox customerCombo = new ComboBox();
        ComboBox genreCombo = new ComboBox();
        ComboBox movieCombo = new ComboBox();
        ComboBox borrowCombo = new ComboBox();
        ComboBox returnCombo = new ComboBox();
        
        //Creating Button Nodes
        Button movieBtn = new Button("Save Rental");
        Button borrowBtn = new Button("Return Movie");
        
        //Preparing The GridPane
        GridPane gridPane = new GridPane();
        
        gridPane.setMinSize(400, 400);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
        //Rendering Elements On The Grid
        gridPane.add(customerLabel, 0, 0);
        gridPane.add(customerCombo, 1, 0);
        
        gridPane.add(genreLabel, 0, 1);
        gridPane.add(genreCombo, 1, 1);
        
        gridPane.add(movieLabel, 0, 2);
        gridPane.add(movieCombo, 1, 2);
        gridPane.add(movieBtn, 1, 3);
        
        gridPane.add(borrowLabel, 0, 4);
        gridPane.add(borrowCombo, 1, 4);
        gridPane.add(borrowBtn, 1, 5);
        
        gridPane.add(returnLabel, 0, 6);
        gridPane.add(returnCombo, 1, 6);
        
        //Sizing Nodes
        customerCombo.setMinWidth(150);
        genreCombo.setMinWidth(150);
        movieCombo.setMinWidth(150);
        movieBtn.setMinWidth(150);
        borrowCombo.setMinWidth(150);
        borrowBtn.setMinWidth(150);
        returnCombo.setMinWidth(150);
        
        //Styling Nodes
        customerCombo.setStyle("-fx-border-color: blue;");
        genreCombo.setStyle("-fx-border-color: blue;");
        movieCombo.setStyle("-fx-border-color: blue;");
        borrowCombo.setStyle("-fx-border-color: blue;");
        returnCombo.setStyle("-fx-border-color: blue;");
        movieBtn.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 10pt;");
        borrowBtn.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 10pt;");
        
        //Setting The Scene
        Scene scene = new Scene(gridPane);
        
        return scene;
    }
    
}