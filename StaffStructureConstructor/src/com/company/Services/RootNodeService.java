package com.company.Services;


public interface RootNodeService {

    String createDepartment(String newDepartmentName);

    String removeDepartment(String departmentName);

    String openDepartment(String departmentName);

    String getDepartmentsList();

}
