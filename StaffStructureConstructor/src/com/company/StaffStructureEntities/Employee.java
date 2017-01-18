package com.company.StaffStructureEntities;


import com.company.Services.UniqueIDGenerator;

public class Employee extends Node {

    protected long employeeId;
    protected short employeeAge;
//    protected String employeeType;
    protected String employeeName;
    protected String nodeName;
    protected long nodeId;

    public Employee() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    protected void setEmployeeId() {
        employeeId = UniqueIDGenerator.getInstance().getNewEmployeeId();
        setNodeName(String.valueOf(employeeId));

    }

    @Override
    public void setNodeId() {
        nodeId = UniqueIDGenerator.getInstance().getNewNodeId();
    }

    @Override
    public long getNodeId() {
        return nodeId;
    }

    public String getEmployeeType() {
        return null;
    }

//    public void setEmployeeType(String employeeType) {
//    }

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
        setEmployeeId();
        this.employeeName = employeeName;
    }

    @Override
    public void setNodeType(String nodeType) {
    }

    @Override
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public String getNodeType() {
        return EMPLOYEE_NODE_TYPE;
    }

    @Override
    public String getNodeName() {
        return nodeName;
    }

    public String[] getNodeCommands() {
        return super.getNodeCommands(getNodeType());
    }
}
