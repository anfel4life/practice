package com.company.StaffStructureEntities;


import com.company.Services.UniqueIDGeneratorImpl;
import com.company.Services.UniqueIdGenerator;

public class Employee {

    protected long employeeId;
    protected short employeeAge;
    protected String employeeType;
    protected String employeeName;

    protected UniqueIdGenerator uniqueGenerator;

    public Employee() {
        uniqueGenerator = new UniqueIDGeneratorImpl();
    }


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId() {
        this.employeeId = uniqueGenerator.getNewId();
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public short getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(short employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

}
