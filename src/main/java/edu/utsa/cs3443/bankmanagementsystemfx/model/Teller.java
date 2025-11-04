package edu.utsa.cs3443.bankmanagementsystemfx.model;

public class Teller extends Person{

    private String userName;
    private String password;
    private int permission;


    /*
    firstConstant: Sunday(1)
    Monday(2)
    ....



     */
    public enum Permissions {
        //in binary: (-1): 1111111...111
        //in binary: (1): 0001
        //0011
        //in binary: (2): 0010 compare with 0001
        //in binary: (4):
        pAll(-1),
        pListMembers(1),
        pAddNewMember(2),
        pDeleteMember(4),
        pUpdateMember(8),
        pFindMember(16);

        private int value;
        Permissions(int value) {
            this.value = -1;
        }

        public int getValue(){
            return this.value;
        }
    }



    public Teller(String firstName, String lastName, String email, String phoneNumber, String userName, String password, int permission) {
        super(firstName, lastName, email, phoneNumber);
        this.userName = userName;
        this.password = password;
        this.permission = permission;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){return this.password;}

    //TODO: setters and getters

    public boolean hasPermission(Permissions permissions){
        //We want to check if the current Teller has the permission equal to the input argument
        //if the input permission is equal to pAll
        if( this.permission == Permissions.pAll.getValue() ){
            return true;
        }
        else{
            return ((this.permission & permissions.getValue()) == permissions.getValue());
        }
    }

    public String toString(){
       // String superValue = super.toString();
        return String.format("%s, with userName: %s ", super.toString(), this.userName );

    }




}
