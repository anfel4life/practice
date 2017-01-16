package com.company.Services;


import com.company.DataHolder.DataHolderSingleton;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DepartmentServiceImpl implements DepartmentService {

    //private Department department;
    //private HashSet employeeSet;
    private DataHolderSingleton dataHolder;

    public DepartmentServiceImpl() {
        dataHolder = DataHolderSingleton.getInstance();
    }

    public DepartmentServiceImpl(Department department) {
    }

    @Override
    public void createDepartment(String newDepartmentName) {
        Department department = new Department();
        department.setDepartmentName(newDepartmentName);
        HashSet employeeSet = new HashSet<Employee>();
        dataHolder.addNewStaffStructureUnit(department, employeeSet);
        //return DataHolderSingleton.getStaffStructureMap();
    }

    @Override
    public void removeDepartment(String departmentName) {
        Department departmentForRemoving = new Department();
        HashMap<Department, HashSet<Employee>> staffStructureMap = dataHolder.getStaffStructureMap();

        removeLbl:
        if (staffStructureMap != null && !staffStructureMap.isEmpty()) {
            for (Map.Entry<Department, HashSet<Employee>> entry : staffStructureMap.entrySet()) {
                Department department = entry.getKey();
                if (department.getDepartmentName().equals(departmentName)) {
                    departmentForRemoving = entry.getKey();
                    break removeLbl;
                }
            }
        }

        if (departmentForRemoving != null) {
            dataHolder.deleteDepartmentFromStaffStructureMap(departmentForRemoving);
        }
    }

    @Override
    public HashSet<Employee> openDepartment(String departmentName) {
        //ArrayList<String> employeeList = new ArrayList<String>();
        HashSet<Employee> employeeSet = new HashSet<Employee>();
        HashMap<Department, HashSet<Employee>> staffStructureMap = dataHolder.getStaffStructureMap();
        if (staffStructureMap != null && !staffStructureMap.isEmpty()) {
            for (Map.Entry<Department, HashSet<Employee>> entry : staffStructureMap.entrySet()) {
                Department department = entry.getKey();
                if (department.getDepartmentName().equals(departmentName)) {
                    employeeSet = entry.getValue();
                }
            }
        }
        return employeeSet;
    }

    @Override
    public String departmentCommandList()   {
        return null;
    }
}
