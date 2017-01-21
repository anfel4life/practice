package com.company.StaffStructureEntities;


import com.company.Services.UniqueIDGenerator;
import java.util.HashSet;

public class Department extends Node   {

    private String departmentName;
    private long nodeId;
    private HashSet<Employee> employeeSet;
    private String nodeType;

    public Department() {
        employeeSet = new HashSet<Employee>();
        nodeType = DEPARTMENT_NODE_TYPE;
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
}
