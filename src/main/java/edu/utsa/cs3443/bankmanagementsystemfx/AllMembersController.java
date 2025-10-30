package edu.utsa.cs3443.bankmanagementsystemfx;

import edu.utsa.cs3443.bankmanagementsystemfx.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import edu.utsa.cs3443.bankmanagementsystemfx.model.Bank;

public class AllMembersController {

    @FXML
    private Label AnchorPaneLabel;

    @FXML
    private ListView<String> membersList;

    private Bank myBank;

    private ObservableList<String> membersObservableList;

    //observableList -> List from JAVAFX collections, different from ArrayList in a way that, it has a listener, so
    //if the your data source which ArrayList of members in Bank changes, this observableList, will make the changes
    //in this UI automatically!!!

    //We are not calling teh constructor of Bank from this file either!!!!

    public void initialize(){
       // BankController.getMyBank().getMembers();
        //membersList.setItems(new ArrayList<Person>(BankController.getMyBank().getMembers()));
        myBank = Bank.getBankInstance();
        membersObservableList = FXCollections.observableArrayList();
        System.out.println(myBank.getMembers().size());
        for(Member member: myBank.getMembers()){
            membersObservableList.add(member.toString());
            System.out.println(member.toString());
        }
        membersList.setItems(membersObservableList);
    }

}

