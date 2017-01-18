package com.company.Services;


import com.company.DataHolder.DataHolderSingleton;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Developer;
import com.company.StaffStructureEntities.Employee;
import com.company.StaffStructureEntities.Manager;
import com.company.UserInterface.VisitedNodesStack;


public class DepartmentServiceImpl implements DepartmentService {


    @Override
    public String openEmployeeInfo(long employeeId) {
        return "";
    }

    @Override
    public String updateEmployeeInfo(long employeeId, String newEmployeeName, byte newEmployeeAge, String newEmployeeType, String newEmployeeSkill) {
        return "";
    }


    @Override
    public String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill) {

        String emplList = "sorry...";

        Employee newEmployee;

        switch (employeeType) {
            case "m":
                newEmployee = new Manager();
                break;
            case "d":
                newEmployee = new Developer();
                break;
            default:
                return "Wrong employee type.";
        }

        newEmployee.setEmployeeName(employeeName);
        newEmployee.setEmployeeAge(employeeAge);

        long parentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        for (Department department : DataHolderSingleton.getInstance().getStaffStructureSet()){
            if (department.getNodeId() == parentNodeId){
                department.addEmployee(newEmployee);
                DataHolderSingleton.getInstance().addDepartment(department);
                emplList = StringConstructor.getEmployeesList(department);
            }
        }
        return emplList;
    }


    @Override
    public String removeEmployee(long employeeId) {
        return "";
    }

    @Override
    public String showDepartments() {
        return "";
    }

}
