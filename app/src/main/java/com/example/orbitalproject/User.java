package com.example.orbitalproject;


public class User {
    private String ID;
    private String Name;
    private String Date;
    private String Amount;
    //private String Pax;





    public User(String id, String name, String date, String amount){
        ID = id;
        Name = name;
        Date = date;
        Amount = amount;
        //Pax = pax;

    }


    public String getID(){return ID; }


    public String getName() {
        return Name;
    }


    public String getDate() {
        return Date;
    }


    public String getAmount() {
        return Amount;
    }

}
