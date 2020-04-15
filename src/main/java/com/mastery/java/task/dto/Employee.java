package com.mastery.java.task.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated employee ID")
    private Long employeeId;

    @NotNull(message = "First Name cannot be null")
    @ApiModelProperty(notes = "Employee first name", example = "John")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    @ApiModelProperty(notes = "Employee last name", example = "Snow")
    private String lastName;

    @NotNull(message = "Department id cannot be null")
    @ApiModelProperty(notes = "Employee department id", example = "12")
    private Long departmentId;

    @NotNull(message = "Job title cannot be null")
    @ApiModelProperty(notes = "Employee job title", example = "Software Developer")
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender cannot be null")
    @ApiModelProperty(notes = "Employee gender", example = "MALE",
            allowableValues = "MALE, FEMALE")
    private Gender gender;

    @NotNull(message = "Date of birth cannot be null")
    @ApiModelProperty(notes = "Employee date of birth", example = "14.06.1990")
    private String dateOfBirth;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Long departmentId,
                    String jobTitle, Gender gender, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
