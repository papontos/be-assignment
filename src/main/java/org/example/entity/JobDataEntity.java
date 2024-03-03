package org.example.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "JOB_DATA")
public class JobDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TIMESTAMP")
    private Date timestamp;
    @Column(name = "EMPLOYER")
    private String employer;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "YEARS_AT_EMPLOYER")
    private String yearsAtEmployer;
    @Column(name = "YEARS_OF_EXPERIENCE")
    private String yearsOfExperience;
    @Column(name = "SALARY")
    private String salary;
    @Column(name = "SINGING_BONUS")
    private String signingBonus;
    @Column(name = "ANNUAL_BONUS")
    private String annualBonus;
    @Column(name = "ANNUAL_STOCK_VALUE_BONUS")
    private String annualStockValueBonus;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "ADDITIONAL_COMMENTS", length = 1000)
    private String additionalComments;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
