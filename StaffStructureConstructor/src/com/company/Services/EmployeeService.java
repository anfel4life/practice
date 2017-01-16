package com.company.Services;


import com.company.StaffStructureEntities.Employee;

import java.util.HashSet;

public interface EmployeeService {

    void openEmployeeInfo(long employeeId);

    void updateEmployeeInfo(long employeeId, String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill);

    void createEmployee(String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill);

    void removeEmployee (long employeeId);

    void showDepartments();

    String employeeCommandsList();
}
