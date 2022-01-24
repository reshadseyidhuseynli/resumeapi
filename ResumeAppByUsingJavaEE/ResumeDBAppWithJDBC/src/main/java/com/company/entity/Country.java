/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

/**
 *
 * @author SRSHD
 */
public class Country {

    private Integer id;
    private String countryName;
    private String nationality;

    public Country() {
    }

    public Country(Integer id, String countryName, String nationality) {
        this.id = id;
        this.countryName = countryName;
        this.nationality = nationality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        String result = "";
        if (!(countryName == null)) {
            result += countryName;
        }
        if (!(nationality == null)) {
            result += nationality;
        }
        return result;
    }

}
