package com.company.Services;


public interface RootService {

    void createDepartment(String newDepartmentName);

    void removeDepartment(String departmentName);

    String openDepartment(String departmentName);

    String getDepartmentsList();

//    String getCommandsList();
}
