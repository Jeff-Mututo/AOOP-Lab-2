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

public class customerPage extends Application{
    
    Stage customerStage = new Stage();
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        primaryStage.setTitle("Lab 2 - Customer Page");
        primaryStage.setScene(customerScene());
        primaryStage.show();
    }
    
    public static Scene customerScene() throws SQLException{
        // =======================================================================================================
        // Node Creation
        // =======================================================================================================
        
        GridPane gridPane = new GridPane();
        
        Text txt1 = new Text("Name");
        Text txt2 = new Text("Phone");
        Text txt3 = new Text("Email");
        Text txt4 = new Text("Registered");
        Text txt5 = new Text("");
        
        ComboBox combo1 = new  ComboBox();
        ObservableList<String> registeredCustomers = FXCollections.observableArrayList();

        TextField txtField = new TextField();
        TextField txtField2 = new TextField();
        TextField txtField3 = new TextField();
        
        Button btn1 = new Button("Save Customer");
        Button btn2 = new Button("Remove Customer");
        
        // =======================================================================================================
        // Event Handling
        // =======================================================================================================
        
        EventHandler<MouseEvent> fetchCustomers = (MouseEvent e) -> {
            combo1.getItems().clear();
            registeredCustomers.clear();
            
            try {
                SystemMethods.fetchRegisteredCustomers(combo1, registeredCustomers);
            } catch (SQLException ex) {
                Logger.getLogger(customerPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        EventHandler<MouseEvent> registerCustomer = (MouseEvent e) -> {
            try {
                SystemMethods.registerCustomer(txtField.getText(), txtField2.getText(), txtField3.getText());
                txt5.setText("Customer Registered!");
            } catch (SQLException ex) {
                Logger.getLogger(SystemMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        EventHandler<MouseEvent> deleteCustomer = (MouseEvent e) -> {
            try {
                SystemMethods.deleteCustomer((String) combo1.getValue());
                txt5.setText("Customer Unregistered!");
            } catch (SQLException ex) {
                Logger.getLogger(SystemMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        
        btn1.setOnMouseClicked(registerCustomer);
        btn2.setOnMouseClicked(deleteCustomer);
        combo1.setOnMouseClicked(fetchCustomers);
        
        // =======================================================================================================
        // GridPane Rendering
        // =======================================================================================================
        
        gridPane.setMinSize(400,400);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
        gridPane.add(txt1, 0, 0);
        gridPane.add(txtField, 1, 0);
        gridPane.add(txt2, 0, 1);
        gridPane.add(txtField2, 1, 1);
        gridPane.add(txt3, 0, 2);
        gridPane.add(txtField3, 1, 2);
        gridPane.add(btn1, 1, 3);
        gridPane.add(txt4, 0, 4);
        gridPane.add(combo1, 1, 4);
        gridPane.add(btn2, 1, 5);
        gridPane.add(txt5, 1, 6);
        
        // =======================================================================================================
        // Node Styling
        // =======================================================================================================

        txtField.setMinWidth(150);
        txtField2.setMinWidth(150);
        txtField3.setMinWidth(150);
        combo1.setMinWidth(150);
        combo1.setVisibleRowCount(4);
        btn1.setMinWidth(150);
        btn2.setMinWidth(150);
        
        btn1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        btn2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        
        txt1.setStyle("-fx-font: normal bold 20px 'serif';");
        txt2.setStyle("-fx-font: normal bold 20px 'serif';");
        txt3.setStyle("-fx-font: normal bold 20px 'serif';");
        txt4.setStyle("-fx-font: normal bold 20px 'serif';");
        txt5.setStyle("-fx-color: red; -fx-font: normal bold 14px 'serif';");
        
        gridPane.setStyle("-fx-background-color: BEIGE;"); 
        
        Scene scene = new Scene(gridPane);
        
        return scene;
    }
    
}