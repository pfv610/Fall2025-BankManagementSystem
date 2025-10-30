package edu.utsa.cs3443.bankmanagementsystemfx.model;

public class Member extends Person{

    private String accountNumber;
    private String pinCode;
    private double balance;
    public Member(String firstName, String lastName, String email, String phoneNumber,
    String accountNumber, String pinCode, double balance) {
        super(firstName, lastName, email, phoneNumber);
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    //Getters and setters

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void setPinCode(String pinCode){
        this.pinCode = pinCode;
    }

    public String getPinCode(){
        return this.pinCode;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public String toString(){
        return String.format("%s, with balance: %f", super.toString(),this.balance);
    }

    //Method to withdraw money from the account

    public boolean withdraw(double amount){
        if(this.balance >= amount && amount >0){
            this.balance = balance - amount;
            return true;
        }
        return false;
    }

    //Method for depositing
    public boolean deposit(double amount){
        if(amount >0 ){
            this.balance += amount;
            return true;
        }
        return false;
    }
}
