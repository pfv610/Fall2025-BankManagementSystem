package edu.utsa.cs3443.bankmanagementsystemfx;

import edu.utsa.cs3443.bankmanagementsystemfx.model.Bank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BankController {

    private Bank myBank;
    private Stage mainStage;
    @FXML
    private Label welcomeText;

    //WE are not calling the constructor of Bank from this file!!

    private void initialize(){
        myBank = Bank.getBankInstance();
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
            Stage newStage = new Stage();
            //
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.initOwner(this.mainStage);
            newStage.setTitle("All Bank members!");
            newStage.setScene(scene);
            newStage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void setStage(Stage stage){
        this.mainStage = stage;
    }


}
