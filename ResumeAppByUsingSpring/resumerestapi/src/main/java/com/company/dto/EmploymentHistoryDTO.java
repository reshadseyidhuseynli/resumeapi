package com.company.dto;

import com.company.entity.EmploymentHistory;

import java.util.Date;

public class EmploymentHistoryDTO {
    private Integer id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String description;

    public EmploymentHistoryDTO() {
    }

    public EmploymentHistoryDTO(EmploymentHistory employmentHistory) {
        this.id = employmentHistory.getId();
        this.header = employmentHistory.getHeader();
        this.beginDate = employmentHistory.getBeginDate();
        this.endDate = employmentHistory.getEndDate();
        this.description = employmentHistory.getDescription();
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getHeader() {return header;}

    public void setHeader(String header) {this.header = header;}

    public Date getBeginDate() {return beginDate;}

    public void setBeginDate(Date beginDate) {this.beginDate = beginDate;}

    public Date getEndDate() {return endDate;}

    public void setEndDate(Date endDate) {this.endDate = endDate;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}
}
