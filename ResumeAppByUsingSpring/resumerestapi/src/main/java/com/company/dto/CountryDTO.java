package com.company.dto;

import com.company.entity.Country;

public class CountryDTO {
    private Integer id;
    private String countryName;
    private String nationality;

    public CountryDTO() {
    }

    public CountryDTO(Country country) {
        this.id = country.getId();
        this.countryName = country.getCountryName();
        this.nationality = country.getNationality();
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getCountryName() {return countryName;}

    public void setCountryName(String countryName) {this.countryName = countryName;}

    public String getNationality() {return nationality;}

    public void setNationality(String nationality) {this.nationality = nationality;}
}
