package com.company.UserInterface;


import com.company.Services.DataKeeperUtils;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.RootNode;

import java.util.HashSet;

public interface CommandsController {

    String createNewDepartment(String departmentName);

    String openDepartment(String departmentName);

    String removeDepartment(String departmentName);

    String departmentsList();

    String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill);

    String createEmployee(String department, String employeeName, String employeeType, short employeeAge,
                          String employeeSkill);

    String updateEmployee(long id, String employeeName, short employeeAge, String employeeSkill);

    String removeEmployee(String employeeIdStr);

    String openEmployee(String employeeIdStr);

    String help();

    String saveStaffStructure();

    String loadStaffStructure();
}
