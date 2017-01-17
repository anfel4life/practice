package com.company.Services;


import com.company.DataHolder.DataHolderSingleton;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Employee;
import com.company.UserInterface.VisitedNodesStack;

import java.util.HashSet;


public class DepartmentServiceImpl implements DepartmentService {


    @Override
    public String openEmployeeInfo(long employeeId) {
        return "";
    }

    @Override
    public String updateEmployeeInfo(long employeeId, String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill) {
        return "";
    }

    @Override
    public String createEmployee(String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill) {
        return "";
    }

    @Override
    public String createEmployee(String newEmployeeName) {

        String emplList = "sorry...";

        Employee newEmployee = new Employee();
        newEmployee.setEmployeeName(newEmployeeName);

        long parentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        for (Department department : DataHolderSingleton.getInstance().getStaffStructureSet()){
            if (department.getNodeId() == parentNodeId){
                department.addEmployee(newEmployee);
                DataHolderSingleton.getInstance().addDepartment(department);
                emplList = getEmployeesList(department.getEmployeeSet());
            }
        }

        return emplList;
    }

    //code dublicate
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


    @Override
    public String removeEmployee(long employeeId) {
        return "";
    }

    @Override
    public String showDepartments() {
        return "";
    }

}
