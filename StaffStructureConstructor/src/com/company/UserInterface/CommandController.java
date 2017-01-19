package com.company.UserInterface;


import com.company.Services.*;
import com.company.StaffStructureEntities.VisitedNodesStack;

import java.util.ArrayList;


public class CommandController {

    private RootService rootService;
    private DepartmentService departmentService;
    private static String MESSAGE = "Command is not allowed.";

    public CommandController() {
        rootService = new RootServiceImpl();
        departmentService = new DepartmentServiceImpl();
    }

    public String createNewDepartment(String departmentName) {
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.CREATE_DEPARTMENT_COM)) {
           return MESSAGE;
        }
        return rootService.createDepartment(departmentName);
    }

    public String openDepartment(String departmentName) {
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.OPEN_DEPARTMENT_COM)) {
            return MESSAGE;
        }
        return rootService.openDepartment(departmentName);
    }

    public String removeDepartment(String departmentName) {
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.REMOVE_DEPARTMENT_COM)) {
            return MESSAGE;
        }
        return rootService.removeDepartment(departmentName);
    }

    public String departmentsList() {
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.DEPARTMENT_COM)) {
            return MESSAGE;
        }
        VisitedNodesStack.getInstance().clear();
        return rootService.getDepartmentsList();
    }

    public String addEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill){
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.CREATE_EMPLOYEE_COM)) {
            return MESSAGE;
        }
        if (!checkAge(employeeAge)){
           return "Wrong age.";
        }
        return departmentService.createEmployee(employeeName, employeeType, employeeAge, employeeSkill);
    }

    public String updateEmployee(long id, String employeeName, short employeeAge, String employeeSkill){
        if (!checkAge(employeeAge)){
            return "Wrong age.";
        } else if (checkId(id)){
            return "Wrong id";
        }
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.UPDATE_EMPLOYEE_COM)) {
            return MESSAGE;
        }
        return departmentService.updateEmployee(id, employeeName,  employeeAge, employeeSkill);
    }

    public String removeEmployee(String employeeIdStr){
        long employeeId;
        try {
            employeeId = Long.valueOf(employeeIdStr);
        } catch (NumberFormatException e){
            return "Wrong id";
        }
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.REMOVE_EMPLOYEE_COM)) {
            return MESSAGE;
        }
        return departmentService.removeEmployee(employeeId);
    }

    public String openEmployee(String employeeIdStr){
        long employeeId;
        try {
            employeeId = Long.valueOf(employeeIdStr);
        } catch (NumberFormatException e){
            return "Wrong id";
        }
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.OPEN_EMPLOYEE_COM)) {
            return MESSAGE;
        }
        return departmentService.openEmployee(employeeId);
    }

    public String commandsList() {
        StringBuilder strings = new StringBuilder();
        ArrayList<String> commandsList = VisitedNodesStack.getInstance().peekLast().getNodeCommands(
                VisitedNodesStack.getInstance().peekLast().getNodeType());
        for (String com : commandsList) {
            strings.append(com).append("\n");
        }
        if (!CommandHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(), CommandHolder.HELP_COM)) {
            return MESSAGE;
        }
        return strings.toString();
    }

    private static boolean checkAge(short age){
        return (1 < age || age > 200);
    }

    private static boolean checkId(long id){
        return (1 > id || id > UniqueIDGenerator.getInstance().getCurrentEmployeeId());
    }
}
