package com.company.Services;


import com.company.StaffStructureEntities.Department;

public interface DepartmentNodeService {

    String openEmployee(long employeeId);

    String updateEmployee(long employeeId, String employeeName, short employeeAge, String skillKey, String newEmployeeSkill);

    String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill);

    String removeEmployee(long employeeId);

    String getEmployeeList(Department department);

}
