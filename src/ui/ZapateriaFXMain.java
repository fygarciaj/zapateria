/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author REBOOTSYSTEM
 */
public class ZapateriaFXMain extends Application {

    private Stage stage;


    @Override
    public void start(Stage primaryStage) {
        URL fxml = getClass().getClassLoader().getResource("ui/login_ui.fxml");


        try {
            stage = primaryStage;
            
            FXMLLoader fxmlLoader = new FXMLLoader(fxml);
            stage.setScene(new Scene(fxmlLoader.load(fxml)));
            stage.sizeToScene();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
