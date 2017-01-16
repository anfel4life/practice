package com.company.Services;


import com.company.DataHolder.DataHolderSingleton;
import com.company.StaffStructureEntities.Employee;

public class EmployeeServiceImpl implements EmployeeService {


    public EmployeeServiceImpl() {
    }

    public EmployeeServiceImpl(Employee employee) {
    }

    @Override
    public void openEmployeeInfo(long employeeId) {
    }

    @Override
    public void updateEmployeeInfo(long employeeId, String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill) {

    }

    @Override
    public void createEmployee(String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill) {

    }

    @Override
    public void removeEmployee(long employeeId) {

    }

    @Override
    public void showDepartments() {

    }

    @Override
    public String employeeCommandsList() {
        return null;
    }

}
