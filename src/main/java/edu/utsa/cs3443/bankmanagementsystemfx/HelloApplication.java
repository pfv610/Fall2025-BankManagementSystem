package edu.utsa.cs3443.bankmanagementsystemfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bank-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        BankController bankController = fxmlLoader.getController();
        bankController.setStage(stage);
        stage.setTitle("UTSA Bank System!");
        stage.setScene(scene);
        stage.show();*/


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        LoginController loginController = fxmlLoader.getController();
        loginController.setStage(stage);

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
