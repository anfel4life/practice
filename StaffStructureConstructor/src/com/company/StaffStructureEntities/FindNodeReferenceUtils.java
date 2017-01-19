package com.company.StaffStructureEntities;


import java.util.HashSet;

public abstract class FindNodeReferenceUtils {

    public static Department getDepartmentRef(String departmentName) {
        Department departmentRef = null;
//        HashSet<Department> staffStructureSet = RootNode.getInstance().getStaffStructureSet();

        lbl:
        if (RootNode.getInstance().getStaffStructureSet() != null && !RootNode.getInstance().getStaffStructureSet().isEmpty()) {
            for (Department department : RootNode.getInstance().getStaffStructureSet()) {
                if (department.getDepartmentName().equals(departmentName)) {
                    departmentRef = department;
                    break lbl;
                }
            }
        }
        return departmentRef;
    }

    public static  Department getDepartmentRef(long departmentId) {
        Department departmentRef = null;
        HashSet<Department> staffStructureSet = RootNode.getInstance().getStaffStructureSet();

        lbl:
        if (staffStructureSet != null && !staffStructureSet.isEmpty()) {
            for (Department department : staffStructureSet) {
                if (department.getNodeId() == departmentId) {
                    departmentRef = department;
                    break lbl;
                }
            }
        }
        return departmentRef;
    }

    public static Employee getEmployeeRef (long employeeId){

        Employee employee = null;
        HashSet<Department> staffStructureSet = RootNode.getInstance().getStaffStructureSet();
        lbl:
        for (Department department : staffStructureSet){
            HashSet <Employee> employeeSet = department.getEmployeeSet();
            if (employeeSet != null && !employeeSet.isEmpty()) {
                for (Employee empl : employeeSet) {
                    if (empl.getEmployeeId() == employeeId) {
                        employee = empl;
                        break lbl;
                    }
                }
            }
        }
        return employee;
    }

}
