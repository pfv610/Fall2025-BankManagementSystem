package edu.utsa.cs3443.bankmanagementsystemfx;

import edu.utsa.cs3443.bankmanagementsystemfx.model.Bank;
import edu.utsa.cs3443.bankmanagementsystemfx.model.Teller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginController {

    @FXML
    private Label loginFailedLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameTextBox;

    private Stage stage;

    private Bank myBank;

    @FXML
    void loginButtonClicked(ActionEvent event) {
        myBank = Bank.getBankInstance();
        String userName = userNameTextBox.getText();
        String password = passwordField.getText();
        System.out.println(userName);
        System.out.println(password);

        //If username or password are empty
        if(userName.isEmpty() || password.isEmpty()){
            loginFailedLabel.setText("Username or password are empty!");
        }
        else{
            System.out.println(userName);
            System.out.println(password);
            Teller teller = myBank.findTeller(userName, password);

            if(teller == null){
                loginFailedLabel.setText("Enter Valid username and password!");
            }
            else{
                System.out.println(teller.toString());
                login(teller);
            }
        }
    }

    private void login(Teller teller){
        myBank.setCurrentTeller(teller);
        //Load the BankController and bank-view.fxml
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bank-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            BankController bankController = fxmlLoader.getController();
            bankController.setStage(this.stage);
            this.stage.setScene(scene);
            this.stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }



}
