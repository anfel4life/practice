package com.company.StaffStructureEntities;


import java.util.HashSet;

public class RootNode extends Node {

    private static RootNode INSTANCE;
    private static HashSet<Department> STAFF_STRUCTURE_SET;
    private static String nodeType;


    private RootNode() {
        STAFF_STRUCTURE_SET = new HashSet<Department>();
        nodeType = ROOT_NODE_TYPE;
    }

    public static RootNode getInstace() {
        if (INSTANCE == null) {
            INSTANCE = new RootNode();
        }
        return INSTANCE;
    }

    @Override
    public void setNodeId() {
    }

    @Override
    public long getNodeId() {
        return 0L;
    }

    @Override
    public String getNodeType() {
        return nodeType;
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

    public void loadData(HashSet<Department> staffStructureSet){
        STAFF_STRUCTURE_SET =  staffStructureSet;
    }
}
