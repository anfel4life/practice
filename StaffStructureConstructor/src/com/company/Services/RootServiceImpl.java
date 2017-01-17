package com.company.Services;


import com.company.DataHolder.DataHolderSingleton;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Employee;
import com.company.UserInterface.VisitedNodesStack;

import java.util.HashSet;

public class RootServiceImpl implements RootService {

    public RootServiceImpl() {
    }

    @Override
    public void createDepartment(String newDepartmentName) {
        Department department = new Department();
        department.setDepartmentName(newDepartmentName);
        DataHolderSingleton.getInstance().addDepartment(department);
    }

    @Override
    public void removeDepartment(String departmentName) {
        Department departmentForRemoving = new Department();
        HashSet<Department> staffStructureSet = DataHolderSingleton.getInstance().getStaffStructureSet();

        removeLbl:
        if (staffStructureSet != null && !staffStructureSet.isEmpty()) {
            for (Department department : staffStructureSet) {
                if (department.getDepartmentName().equals(departmentName)) {
                    departmentForRemoving = department;
                    break removeLbl;
                }
            }
        }
        DataHolderSingleton.getInstance().removeDepartment(departmentForRemoving);
    }

    @Override
    public String getDepartmentsList() {
        StringBuilder departmentsCount = new StringBuilder();
        HashSet<Department> staffStructureSet = DataHolderSingleton.getInstance().getStaffStructureSet();
        if (staffStructureSet != null && !staffStructureSet.isEmpty()) {
            departmentsCount.append("Depertments list: \n\n");
            for (Department department : staffStructureSet) {
                departmentsCount.append(department.getDepartmentName()).append("\n");
            }
        }

        if (departmentsCount.length() == 0) {
            departmentsCount.append("No departmens");
        }

        return departmentsCount.toString();
    }

    @Override
    public String openDepartment(String departmentName) {
        String result = "No departments";
        boolean isDepartment = false;
        HashSet<Department> staffStructureSet = DataHolderSingleton.getInstance().getStaffStructureSet();

        lbl:
        if (staffStructureSet != null && !staffStructureSet.isEmpty()) {
            for (Department department : staffStructureSet) {
                if (department.getDepartmentName().equals(departmentName)) {
                    //there is department with such name!
                    isDepartment = true;
                    HashSet<Employee> employeeSet = department.getEmployeeSet();
                    VisitedNodesStack.getInstance().setNode(department);
//                    System.out.println("RootService openDepartment nodeType: " + department.getNodeType());
                    result = "Employees list of " + departmentName + " department:\n\n";
                    result += getEmployeesList(employeeSet);
                    break lbl;
                }
            }
        }
        result = isDepartment ? result : "Department with name " + departmentName +
                "doesn't exist.";
        return result;
    }

    private String getEmployeesList(HashSet<Employee> employeeSet) {
        StringBuilder list = new StringBuilder();
        if (employeeSet != null && !employeeSet.isEmpty()) {
            for (Employee employee : employeeSet) {

                list.append(employee.getEmployeeName())
                        .append(" (id:")
                        .append(employee.getEmployeeId())
                        .append(")")
                        .append("\n");
            }
        } else {
            list.append("There aren't any employees in this department yet");
        }
        return list.toString();

    }
}
