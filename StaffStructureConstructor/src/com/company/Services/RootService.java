package com.company.Services;


public interface RootService {

    String createDepartment(String newDepartmentName);

    String removeDepartment(String departmentName);

    String openDepartment(String departmentName);

    String getDepartmentsList();

//    String getCommandsList();
}
