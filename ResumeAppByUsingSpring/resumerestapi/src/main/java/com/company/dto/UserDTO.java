package com.company.dto;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String profileDescription;
    private String address;
    private Date birthDate;
    private String password;
    private CountryDTO countryId;
    private CountryDTO nationalityId;
    private List<UserSkillDTO> userSkillList;
    private List<EmploymentHistoryDTO> employmentHistoryList;


    public UserDTO() {
    }
    public UserDTO(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.email = u.getEmail();
        this.phone = u.getPhone();
        this.profileDescription = u.getProfileDescription();
        this.address = u.getAddress();
        this.birthDate = u.getBirthDate();
        this.password = u.getPassword();
        this.countryId = new CountryDTO(u.getCountryId());
        this.nationalityId = new CountryDTO(u.getNationalityId());

        this.userSkillList = new ArrayList<>();
        List<UserSkill> usl = u.getUserSkillList();
        for (int i = 0; i < u.getUserSkillList().size(); i++) {
            userSkillList.add(new UserSkillDTO(usl.get(i)));
        }

        this.employmentHistoryList = new ArrayList<>();
        List<EmploymentHistory> ehl = u.getEmploymentHistoryList();
        for (int i = 0; i < u.getEmploymentHistoryList().size(); i++){
            employmentHistoryList.add(new EmploymentHistoryDTO(ehl.get(i)));
        }
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getProfileDescription() {return profileDescription;}

    public void setProfileDescription(String profileDescription) {this.profileDescription = profileDescription;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public Date getBirthDate() {return birthDate;}

    public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public CountryDTO getCountryId() {return countryId;}

    public void setCountryId(CountryDTO countryId) {this.countryId = countryId;}

    public CountryDTO getNationalityId() {return nationalityId;}

    public void setNationalityId(CountryDTO nationalityId) {this.nationalityId = nationalityId;}

    public List<UserSkillDTO> getUserSkillList() {return userSkillList;}

    public void setUserSkillList(List<UserSkillDTO> userSkillList) {this.userSkillList = userSkillList;}

    public List<EmploymentHistoryDTO> getEmploymentHistoryList() {return employmentHistoryList;}

    public void setEmploymentHistoryList(List<EmploymentHistoryDTO> employmentHistoryList) {this.employmentHistoryList = employmentHistoryList;}
}

