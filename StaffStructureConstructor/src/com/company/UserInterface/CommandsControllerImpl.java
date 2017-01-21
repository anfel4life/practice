package com.company.UserInterface;


import com.company.Services.*;
import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.RootNode;
import com.company.StaffStructureEntities.VisitedNodesStack;

import java.util.ArrayList;
import java.util.HashSet;


public class CommandsControllerImpl implements CommandsController {

    private static String COMMAND_IS_NOT_ALLOWED_MSG = "Command is not allowed.";
    private static String WRONG_AGE_MSG = "Wrong age.";
    private static String WRONG_ID_MSG = "Wrong age.";
    private RootNodeService rootNodeService;
    private DepartmentNodeService departmentNodeService;

    public CommandsControllerImpl() {
        rootNodeService = new RootNodeServiceImpl();
        departmentNodeService = new DepartmentNodeServiceImpl();
    }

    @Override
    public String createNewDepartment(String departmentName) {
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.CREATE_DEPARTMENT_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return rootNodeService.createDepartment(departmentName);
    }

    @Override
    public String openDepartment(String departmentName) {
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.OPEN_DEPARTMENT_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return rootNodeService.openDepartment(departmentName);
    }

    @Override
    public String removeDepartment(String departmentName) {
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.REMOVE_DEPARTMENT_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return rootNodeService.removeDepartment(departmentName);
    }

    @Override
    public String departmentsList() {
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.DEPARTMENT_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        VisitedNodesStack.getInstance().clear();
        return rootNodeService.getDepartmentsList();
    }

    @Override
    public String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill) {

        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.CREATE_EMPLOYEE_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        if (isAgeNotCorrect(employeeAge)) {
            return WRONG_AGE_MSG;
        }
        return departmentNodeService.createEmployee(employeeName, employeeType, employeeAge, employeeSkill);
    }

    @Override
    public String createEmployee(String department, String employeeName, String employeeType, short employeeAge,
                                 String employeeSkill) {
        String message;
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.CREATE_EMPLOYEE_IN_DEPARTMENT_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }

        if (isAgeNotCorrect(employeeAge)) {
            return WRONG_AGE_MSG;
        }

        message = openDepartment(department);
        return message + "\n" + createEmployee(employeeName, employeeType, employeeAge, employeeSkill);
    }

    @Override
    public String updateEmployee(long id, String employeeName, short employeeAge, String skillKey, String employeeSkill) {
        if (isAgeNotCorrect(employeeAge)) {
            return WRONG_AGE_MSG;
        } else if (isIdNotCorrect(id)) {
            return WRONG_ID_MSG;
        }
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.UPDATE_EMPLOYEE_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return departmentNodeService.updateEmployee(id, employeeName, employeeAge, skillKey, employeeSkill);
    }

    @Override
    public String removeEmployee(String employeeIdStr) {
        long employeeId;
        try {
            employeeId = Long.valueOf(employeeIdStr);
        } catch (NumberFormatException e) {
            return WRONG_ID_MSG;
        }
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.REMOVE_EMPLOYEE_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return departmentNodeService.removeEmployee(employeeId);
    }

    @Override
    public String openEmployee(String employeeIdStr) {
        long employeeId;
        try {
            employeeId = Long.valueOf(employeeIdStr);
        } catch (NumberFormatException e) {
            return WRONG_ID_MSG;
        }
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.OPEN_EMPLOYEE_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return departmentNodeService.openEmployee(employeeId);
    }

    @Override
    public String help() {
        StringBuilder strings = new StringBuilder();
        ArrayList<String> commandsList = VisitedNodesStack.getInstance().peekLast().getNodeCommands(
                VisitedNodesStack.getInstance().peekLast().getNodeType());
        for (String com : commandsList) {
            strings.append(com).append("\n");
        }
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.HELP_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        return strings.toString();
    }

    @Override
    public String saveStaffStructure() {
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.SAVE_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }
        DataKeeperUtils.writeStaffStructure(RootNode.getInstace().getStaffStructureSet());
        DataKeeperUtils.writeEmployeeId(UniqueIDGenerator.getInstance().getCurrentEmployeeId());
        DataKeeperUtils.writeNodeId(UniqueIDGenerator.getInstance().getCurrentNodeId());
        return "Staff structure was saved";
    }

    @Override
    public String loadStaffStructure() {
        if (!CommandsHolder.isCommandAllowed(VisitedNodesStack.getInstance().peekLast().getNodeType(),
                CommandsHolder.LOAD_COM)) {
            return COMMAND_IS_NOT_ALLOWED_MSG;
        }

        Object staffStructureObject = DataKeeperUtils.readStaffStructure();
        Object employeeIdObject = DataKeeperUtils.readEmployeeId();
        Object nodeIdObject = DataKeeperUtils.readNodeId();

        if (staffStructureObject == null && employeeIdObject == null && nodeIdObject == null) {
            return "The loading was unsuccessful.";
        }

        try {
            HashSet<Department> staffStructureSet = (HashSet<Department>) staffStructureObject;
            RootNode.getInstace().loadData(staffStructureSet);
            UniqueIDGenerator.getInstance().loadNodeEmployeeId((long) nodeIdObject);
            UniqueIDGenerator.getInstance().loadUniqueEmployeeId((long) employeeIdObject);
            VisitedNodesStack.getInstance().clear();
        } catch (ClassCastException e) {
            return "The loading was unsuccessful.";
        }
        return "Staff structure was loaded";
    }

    private static boolean isAgeNotCorrect(short age) {
        return (0 > age || age > 200);
    }

    private static boolean isIdNotCorrect(long id) {
        return (1 > id || id > UniqueIDGenerator.getInstance().getCurrentEmployeeId());
    }
}
