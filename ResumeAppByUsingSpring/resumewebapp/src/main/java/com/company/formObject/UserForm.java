package com.company.formObject;

public class UserForm {
    private String name;
    private String surname;

    public UserForm() {
    }
    public UserForm(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setSurname(String surname) {
        this.surname = name;
    }
    public String getSurname() {
        return this.surname;
    }
}
