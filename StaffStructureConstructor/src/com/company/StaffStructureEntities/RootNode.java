package com.company.StaffStructureEntities;


import java.io.Serializable;
import java.util.HashSet;

public class RootNode extends Node implements Serializable{

    private static RootNode instance;
    private static HashSet<Department> STAFF_STRUCTURE_SET;


    private RootNode() {
        STAFF_STRUCTURE_SET = new HashSet<Department>();
    }

    public static RootNode getInstance() {
        if (instance == null) {
            instance = new RootNode();
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
    public String getNodeType() {
        return ROOT_NODE_TYPE;
    }

    public void loadData(HashSet<Department> staffStructureSet){
        STAFF_STRUCTURE_SET =  staffStructureSet;
    }
}
