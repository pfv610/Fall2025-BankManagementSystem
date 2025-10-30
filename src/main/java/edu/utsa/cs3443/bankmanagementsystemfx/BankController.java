package edu.utsa.cs3443.bankmanagementsystemfx;

import edu.utsa.cs3443.bankmanagementsystemfx.model.Bank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BankController {

    private static final Bank myBank = new Bank();
    @FXML
    private Label welcomeText;


    private void initialize(){
        //myBank = new Bank();
        myBank.loadMembersFromFile();
        myBank.loadTellersFromFile();
        //Now, I can access the two arrayLists inside the bank object
    }


    @FXML
    void deleteMember(ActionEvent event) {

    }

    @FXML
    void listBankMembers(ActionEvent event) {

        //Firstly, we need to set up a new scene

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("all-members.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 320, 240);
            Stage stage = new Stage();
            stage.setTitle("All Bank members!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Bank getMyBank(){
        return myBank;
    }

}
