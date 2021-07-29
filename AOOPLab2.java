package aoop.lab.pkg1;

import javafx.application.Application;
import javafx.stage.Stage;

public class AOOPLab2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        homePage home = new homePage();
        home.start(home.homeStage);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
