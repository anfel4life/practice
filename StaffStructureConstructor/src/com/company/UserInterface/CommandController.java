package com.company.UserInterface;


import com.company.Services.*;

public class CommandController {

    private RootService rootService;
    private DepartmentService departmentService;
    private EmployeeService employeeService;


    public CommandController() {
//        currentNode = VisitedNodesStack.getInstance().peek();
        rootService = new RootServiceImpl();
        departmentService = new DepartmentServiceImpl();
        employeeService = new EmployeeServiceImpl();
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

    public String departmentsList() {
        return rootService.getDepartmentsList();
    }

    public String addEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill){
        return departmentService.createEmployee(employeeName, employeeType, employeeAge, employeeSkill);
    }

    public String updateEmployee(long id, String employeeName, String employeeType, short employeeAge, String employeeSkill){
        return departmentService.createEmployee(employeeName, employeeType, employeeAge, employeeSkill);
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
