package edu.utsa.cs3443.bankmanagementsystemfx.model;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


//Design pattern we used in Bank is a ***Singleton*** => Creational Design Pattern
//final class: we cannot create objects from this class
public final class Bank {
    //Data structures for storing all the members (ArrayList of Members)
    //ArrayList of all tellers

    ArrayList<Member> members; //Collection of Members //aggregation  or composition
    ArrayList<Teller> tellers; //Collection of Tellers// Aggregation ot composition
    private Teller currentTeller;

    public void setCurrentTeller(Teller teller){
        this.currentTeller = teller;
    }

    public Teller getCurrentTeller(){
        return this.currentTeller;
    }
    private static Bank bankInstance;

    public Bank(){
        this.members = new ArrayList<>();
        this.tellers = new ArrayList<>();
    }

    public static Bank getBankInstance(){
        if(bankInstance == null){
            bankInstance = new Bank(); //This is the only place we call the constructor of the Bank
            bankInstance.loadMembersFromFile();
            bankInstance.loadTellersFromFile();
        }
        return bankInstance;
    }

    public void loadMembersFromFile(){
        String fileName = "data/members.txt";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] elements = line.split(",");
                Member member = new Member(elements[0],elements[1],elements[2], elements[3], elements[4], elements[5], Double.valueOf(elements[6]));
                members.add(member);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void loadTellersFromFile(){
        String fileName = "data/tellers.txt";
        try{
            Scanner scanner = new Scanner(new File(fileName));
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");
                System.out.println(elements.toString());
                Teller teller = new Teller(elements[0],elements[1],elements[2], elements[3], elements[4], elements[5], Integer.valueOf(elements[6]));
                members.size();
                tellers.add(teller);
            }
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Member> getMembers(){
        return members;
    }
    public ArrayList<Teller> getTellers(){
        return tellers;
    }

    public Member findMember(String accountNumber){
        for(Member member: members){
            if(member.getAccountNumber().equals(accountNumber)){
                return member;
            }
        }
        return null;
    }

    public boolean isMember(String accountNumber){
        return (findMember(accountNumber) != null);
    }

    public boolean removeMember(String accountNumber){
        if(isMember(accountNumber)){
            Member me1 = findMember(accountNumber);
            members.remove(me1);
            //If we were using a DB -> make a query to the DB to remove a record
            //if you wanted a local arraylist of the updated list of members then you would read from db
            saveMemberDataToFile();
            loadMembersFromFile();
            return true;
        }
        return false;
    }


    private void saveMemberDataToFile(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/members.txt"));
            for(Member member:members){
                bw.write(convertMembertoLine(member));
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    private String convertMembertoLine(Member member){
        return member.getFirstName() + "," + member.getLastName() + "," + member.getEmail() + "," +
                member.getPhoneNumber() + "," + member.getPinCode() + ","+ member.getBalance();
    }

    public Teller findTeller(String userName, String password){
        for(Teller teller: tellers){
            if(teller.getUserName().equalsIgnoreCase(userName) && teller.getPassword().equalsIgnoreCase(password)){
                return teller;
            }
        }
        return null;
    }





   //TODO:  Adding a new member to the ArrayList members

    //TODO: Removing a member from the ArrayList

    //TODO: Method to print all the members with their information


}
