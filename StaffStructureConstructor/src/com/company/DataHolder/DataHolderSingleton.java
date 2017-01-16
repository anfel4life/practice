package com.company.DataHolder;


import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataHolderSingleton {

    private static long lastEmployeeId;
    private static DataHolderSingleton instance;

    private static HashMap<Department, HashSet<Employee>> STAFF_STRUCTURE_MAP;

    private DataHolderSingleton() {
        STAFF_STRUCTURE_MAP = new HashMap<Department, HashSet<Employee>>();
        lastEmployeeId = 0L;
    }

    public static DataHolderSingleton getInstance() {
        if (instance == null) {
            instance =  new DataHolderSingleton();
        }
        return instance;
    }

//    public static long getLastEmployeeId() {
//        return lastEmployeeId;
//    }

    public long incrementLastEmployeeId(){
        return ++lastEmployeeId;
    }

//    public static void setLastEmployeeId(long lastEmployeeId) {
//        DataHolderSingleton.lastEmployeeId = lastEmployeeId;
//    }

    public void deleteDepartmentFromStaffStructureMap(Department department) {
        STAFF_STRUCTURE_MAP.remove(department);
    }

    public HashMap<Department, HashSet<Employee>> getStaffStructureMap() {
        return STAFF_STRUCTURE_MAP;
    }

    public void addNewStaffStructureUnit(Department department, HashSet<Employee> employeeSet) {
        STAFF_STRUCTURE_MAP.put(department, employeeSet);
    }
}
