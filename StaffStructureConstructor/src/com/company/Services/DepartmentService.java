package com.company.Services;


public interface DepartmentService {

    String openEmployeeInfo(long employeeId);

    String updateEmployeeInfo(long employeeId, String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill);

    String createEmployee(String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill);

    String createEmployee(String newEmployeeName);

    String removeEmployee(long employeeId);

    String showDepartments();

}
