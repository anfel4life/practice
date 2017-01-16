package com.company.Services;


import com.company.StaffStructureEntities.Employee;

import java.util.HashMap;
import java.util.HashSet;

public interface DepartmentService {

    void createDepartment(String newDepartmentName);

    void removeDepartment(String departmentName);

    HashSet<Employee> openDepartment(String departmentName);

    String departmentCommandList();
}
