package com.company.Services;


public interface DepartmentService {

    String openEmployeeInfo(long employeeId);

    String updateEmployeeInfo(long employeeId, String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill);

    String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill);

    String removeEmployee(long employeeId);

    String showDepartments();

}
