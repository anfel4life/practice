package com.company.StaffStructureEntities;


import com.company.Services.UniqueIDGenerator;

import java.util.HashSet;

public class Department extends Node {

    private String departmentName;
    private String nodeName;
    private long nodeId;
//    private CommandHolder comHolder;
    //private String nodeType;

    private HashSet<Employee> employeeSet;

    public Department() {
        //setNodeType(DEPARTMENT_NODE_TYPE);
//        comHolder = new CommandHolder();
        employeeSet = new HashSet<Employee>();
    }

    @Override
    public void setNodeId() {
        nodeId = UniqueIDGenerator.getInstance().getNewNodeId();
    }

    @Override
    public long getNodeId() {
        return nodeId;
    }

    public void setDepartmentName(String departmentName) {
        setNodeName(departmentName);
        this.departmentName = departmentName;
    }

    public HashSet<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void addEmployee(Employee employee) {
        employeeSet.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeSet.remove(employee);
    }

//    public void setEmployeeSet(HashSet<Employee> employeeSet) {
//        this.employeeSet = employeeSet;
//    }

    public String getDepartmentName() {
        return departmentName;
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
        return DEPARTMENT_NODE_TYPE;
    }

    @Override
    public String getNodeName() {
        return nodeName;
    }

}
