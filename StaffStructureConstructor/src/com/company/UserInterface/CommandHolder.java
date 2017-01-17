package com.company.UserInterface;


import com.company.StaffStructureEntities.Node;

import java.util.HashMap;

public class CommandHolder {

    private static final String EXIT_COM = "type \"exit\" to quit from the application";

    private static final String OPEN_DEPARTMENT_COM = "type \"open -d department_name\" to watch employees of this " +
            "department";
    private static final String OPEN_EMPLOYEE_COM = "type \"open -e employee_id\" to watch employee details";

    private static final String REMOVE_DEPARTMENT_COM = "type \"rm -d department_name\" to remove department";
    private static final String REMOVE_EMPLOYEE_COM = "type \"rm -e employee -id\" to remove employee";

    private static final String UPDATE_EMPLOYEE_COM = "type \"update -e employee_id -n employee_name -t -a age " +
            "(type \"-m\" for manager, \"-d\" for developer)\" \n      \"-l\" (developers only) \"-m\" (managers only) \" " +
            "to update employee information";

    private static final String CREATE_EMPLOYEE_COM = "type \"create -e -n employee_name -t (type \"-m\" for manager, " +
            "\"-d\" for developer)\" \n     -a age \"-l\" (developers only) \"-m\" (managers only) \" to create new employee";

    private static final String CREATE_DEPARTMENT_COM = "type \"create -d department_name\" to create new department";

    private static final String DEPARTMENT_COM = "type \"departments\" to return to the list of departments";

    private static final String HELP_COM = "type \"help\" for command list";


    private static final String[] rootCommandsArr = {DEPARTMENT_COM, OPEN_DEPARTMENT_COM, CREATE_DEPARTMENT_COM,
            REMOVE_DEPARTMENT_COM,
            HELP_COM, EXIT_COM};

    private static final String[] departmentCommandsArr = {OPEN_EMPLOYEE_COM, UPDATE_EMPLOYEE_COM, CREATE_EMPLOYEE_COM,
            REMOVE_EMPLOYEE_COM, DEPARTMENT_COM, HELP_COM, EXIT_COM};

    private static final String[] employeeCommandsArr = {UPDATE_EMPLOYEE_COM, DEPARTMENT_COM, OPEN_DEPARTMENT_COM,
            HELP_COM, EXIT_COM};

    public HashMap<String, String[]> commandsMap = new HashMap<String, String[]>();

    public CommandHolder() {
        commandsMap.put(Node.ROOT_NODE_TYPE, rootCommandsArr);
        commandsMap.put(Node.DEPARTMENT_NODE_TYPE, departmentCommandsArr);
        commandsMap.put(Node.EMPLOYEE_NODE_TYPE, employeeCommandsArr);
    }

    public String[] getCommands(String nodeType) {
        return commandsMap.get(nodeType);
    }
}
