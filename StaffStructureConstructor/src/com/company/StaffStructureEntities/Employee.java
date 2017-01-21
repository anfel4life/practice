package com.company.StaffStructureEntities;

import com.company.Services.UniqueIDGenerator;

public class Employee extends Node {

    private long employeeId = 0L;
    private short employeeAge = 0;
    private String employeeName = "";
    private long nodeId = 0L;
    private String employeeSkill = "";
    private String nodeType;

    public Employee() {
        setEmployeeId();
        this.nodeType = EMPLOYEE_NODE_TYPE;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    private void setEmployeeId() {
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
        return nodeType;
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
