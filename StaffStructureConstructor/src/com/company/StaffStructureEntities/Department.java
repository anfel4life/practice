package com.company.StaffStructureEntities;


import com.company.Services.UniqueIDGenerator;

import java.io.Serializable;
import java.util.HashSet;

public class Department extends Node implements  Serializable  {

    private String departmentName;
    private long nodeId;
    private HashSet<Employee> employeeSet;

    public Department() {
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

    public HashSet<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void addEmployee(Employee employee) {
        employeeSet.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeSet.remove(employee);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        setNodeId();
        this.departmentName = departmentName;
    }

    @Override
    public String getNodeType() {
        return DEPARTMENT_NODE_TYPE;
    }

}
