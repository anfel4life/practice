package com.company.StaffStructureEntities;


public class Manager extends Employee {

    private String employeeType;

    public Manager(){
        employeeType = "Manager";
    }

    public String getEmployeeType() {
        return employeeType;
    }
}
