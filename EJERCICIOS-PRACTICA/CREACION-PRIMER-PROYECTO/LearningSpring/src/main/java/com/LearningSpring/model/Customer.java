package com.LearningSpring.model;

public class Customer {
    // ATRIBUTOS
    private int ID;
    private String name;
    private String username;
    private String password;

    //CONSTRUCTOR
    public Customer (int ID,String name, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    //GETTERS Y SETTERS DE CADA ATRIBUTO.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
