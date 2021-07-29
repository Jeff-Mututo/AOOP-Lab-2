package aoop.lab.pkg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class examplePage extends Application{
    
    Stage exampleStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab 2 - Example Page");
        primaryStage.setScene(exampleScene());
        primaryStage.show();
    }
    
    public Scene exampleScene(){
        //Create TextLabel Nodes
        Text text1 = new Text("Name:");
        Text text2 = new Text("Registered:");
        
        //Create TextField Nodes
        TextField textField1 = new TextField();
        
        //Create ComboBox Nodes
        ComboBox comboBox1 = new ComboBox();
        
        //Create Button Nodes
        Button btn1 = new Button("Save");
        Button btn2 = new Button("Remove");
        
        //Preparing The GridPane
        GridPane gridPane = new GridPane();
        
        gridPane.setMinSize(400, 400);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
        //Rendering Nodes onto the Grid
        gridPane.add(text1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(btn1, 1, 1);
        gridPane.add(text2, 0, 2);
        gridPane.add(comboBox1, 1, 2);
        gridPane.add(btn2, 1, 3);
        
        //Styling Nodes
        btn1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 13pt;");
        btn2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size: 13pt;");
        
        text1.setStyle("-fx-font: normal bold 20px 'serif' ");
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");
        
        gridPane.setStyle("-fx-background-color: BEIGE;");
        
        //Setting the scene
        Scene scene = new Scene(gridPane);
        
        return scene;
    }
    
}
