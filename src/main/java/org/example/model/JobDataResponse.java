package org.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobDataResponse {
    private Date timestamp;
    private String employer;
    private String location;
    private String jobTitle;
    private String yearsAtEmployer;
    private String yearsOfExperience;
    private String salary;
    private String signingBonus;
    private String annualBonus;
    private String annualStockValueBonus;
    private String gender;
    private String additionalComments;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getYearsAtEmployer() {
        return yearsAtEmployer;
    }

    public void setYearsAtEmployer(String yearsAtEmployer) {
        this.yearsAtEmployer = yearsAtEmployer;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSigningBonus() {
        return signingBonus;
    }

    public void setSigningBonus(String signingBonus) {
        this.signingBonus = signingBonus;
    }

    public String getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(String annualBonus) {
        this.annualBonus = annualBonus;
    }

    public String getAnnualStockValueBonus() {
        return annualStockValueBonus;
    }

    public void setAnnualStockValueBonus(String annualStockValueBonus) {
        this.annualStockValueBonus = annualStockValueBonus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }
}
