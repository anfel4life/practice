package com.company.UserInterface;


public interface CommandsController {

    String createNewDepartment(String departmentName);

    String openDepartment(String departmentName);

    String removeDepartment(String departmentName);

    String departmentsList();

    String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill);

    String createEmployee(String department, String employeeName, String employeeType, short employeeAge,
                          String employeeSkill);

    String updateEmployee(long id, String employeeName, short employeeAge, String skillKey, String employeeSkill);

    String removeEmployee(String employeeIdStr);

    String openEmployee(String employeeIdStr);

    String help();

    String saveStaffStructure();

    String loadStaffStructure();
}
