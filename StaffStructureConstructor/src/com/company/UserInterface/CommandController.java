package com.company.UserInterface;


import com.company.Services.DepartmentService;
import com.company.Services.DepartmentServiceImpl;
import com.company.Services.RootService;
import com.company.Services.RootServiceImpl;

public class CommandController {

    private RootService rootService;
    private DepartmentService departmentService;
    private EmployeeService employeeService;


    public CommandController() {
//        currentNode = VisitedNodesStack.getInstance().peek();
        rootService = new RootServiceImpl();
        departmentService = new DepartmentServiceImpl();
        employeeService = new EmployeeService();
    }

    public String createNewDepartment(String departmentName) {
        rootService.createDepartment(departmentName);
        return rootService.getDepartmentsList();
    }

    public String openDepartment(String departmentName) {
        return rootService.openDepartment(departmentName);
    }

    public String removeDepartment(String departmentName) {
        rootService.removeDepartment(departmentName);
        return rootService.getDepartmentsList();
    }

    public String departmensList() {
        return rootService.getDepartmentsList();
    }

    public String addEmployee(String newEmployeeName){
        return departmentService.createEmployee(newEmployeeName);
    }


    public String commandsList() {
        StringBuilder strings = new StringBuilder();
//        System.out.println(">>>CC: commandsList() currentNodeType: " + VisitedNodesStack.getInstance().peekLast().getNodeType());
        String[] commands = VisitedNodesStack.getInstance().peekLast().getNodeCommands(
                VisitedNodesStack.getInstance().peekLast().getNodeType());
        for (String com : commands) {
            strings.append(com).append("\n");
        }
        return strings.toString();
    }

}
