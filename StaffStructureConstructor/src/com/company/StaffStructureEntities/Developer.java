package com.company.StaffStructureEntities;


public class Developer extends Employee {

    private String employeeType;

    public Developer(){
        employeeType = "Developer";
    }

    public String getEmployeeType() {
        return employeeType;
    }
}
