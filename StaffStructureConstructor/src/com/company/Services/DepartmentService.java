package com.company.Services;


public interface DepartmentService {

    String openEmployee(long employeeId);

    String updateEmployee(long employeeId, String employeeName, short employeeAge, String newEmployeeSkill);

    String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill);

    String removeEmployee(long employeeId);

}
