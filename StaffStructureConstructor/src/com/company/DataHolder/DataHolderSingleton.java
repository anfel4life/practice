package com.company.DataHolder;


import com.company.Services.UniqueIDGenerator;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Node;

import java.util.HashSet;

public class DataHolderSingleton extends Node {

    private static long lastEmployeeId;
    private static DataHolderSingleton instance;
    private static HashSet<Department> STAFF_STRUCTURE_SET;

    private DataHolderSingleton() {
        STAFF_STRUCTURE_SET = new HashSet<Department>();
        lastEmployeeId = 0L;
    }

    public static DataHolderSingleton getInstance() {
        if (instance == null) {
            instance = new DataHolderSingleton();
        }
        return instance;
    }


    @Override
    public void setNodeId() {
    }

    @Override
    public long getNodeId() {
        return 0L;
    }

    public long incrementLastEmployeeId() {
        return ++lastEmployeeId;
    }

    public void removeDepartment(Department department) {
        STAFF_STRUCTURE_SET.remove(department);
    }

    public HashSet<Department> getStaffStructureSet() {
        return STAFF_STRUCTURE_SET;
    }

    public void addDepartment(Department department) {
        STAFF_STRUCTURE_SET.add(department);
    }

    @Override
    public void setNodeType(String nodeType) {
    }

    @Override
    public void setNodeName(String nodeName) {
    }

    @Override
    public String getNodeType() {
        return ROOT_NODE_TYPE;
    }

    @Override
    public String getNodeName() {
        return "root";
    }
}
