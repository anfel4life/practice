package com.company.StaffStructureEntities;


import com.company.Services.UniqueIDGenerator;

import java.io.Serializable;


public class Employee extends Node implements Serializable {

    protected long employeeId = 0L;
    protected short employeeAge = 0;
    protected String employeeName = "";
    protected long nodeId = 0L;
    protected String employeeSkill = "";

    public Employee() {
        setEmployeeId();
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    protected void setEmployeeId() {
        employeeId = UniqueIDGenerator.getInstance().getNewEmployeeId();
    }

    @Override
    public void setNodeId() {
        nodeId = UniqueIDGenerator.getInstance().getNewNodeId();
    }

    @Override
    public long getNodeId() {
        return nodeId;
    }

    @Override
    public String getNodeType() {
        return EMPLOYEE_NODE_TYPE;
    }

    public String getEmployeeType() {
        return null;
    }

    public String getEmployeeSkill() {
        return employeeSkill;
    }

    public void setEmployeeSkill(String employeeSkill) {
        if (!employeeSkill.isEmpty()) {
            this.employeeSkill = employeeSkill;
        }
    }

    public short getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(short employeeAge) {
        if (employeeAge != 0) {
            this.employeeAge = employeeAge;
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if (!employeeName.isEmpty()) {
            this.employeeName = employeeName;
        }
    }


}
