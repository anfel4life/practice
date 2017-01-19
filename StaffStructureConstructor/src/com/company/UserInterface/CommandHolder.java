package com.company.UserInterface;


import com.company.StaffStructureEntities.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CommandHolder {

    public static final String EXIT_COM = "type \"exit\" to quit from the application";

    public static final String OPEN_DEPARTMENT_COM = "type \"open -d department_name\" to watch employees of this " +
            "department";
    public static final String OPEN_EMPLOYEE_COM = "type \"open -e employee_id\" to watch employee details";

    public static final String REMOVE_DEPARTMENT_COM = "type \"rm -d department_name\" to remove department";
    public static final String REMOVE_EMPLOYEE_COM = "type \"rm -e employee -id\" to remove employee";

    public static final String UPDATE_EMPLOYEE_COM = "type \"update -e employee_id -n employee_name -t -a age " +
            "(type \"-m\" for manager, \"-d\" for developer)\" \n      \"-l\" (developers only) \"-m\" (managers only) \" " +
            "to update employee information";

    public static final String CREATE_EMPLOYEE_COM = "type \"create -e -n employee_name -t (type \"-m\" for manager, " +
            "\"-d\" for developer)\" \n     -a age \"-l\" (developers only) \"-m\" (managers only) \" to create new employee";

    public static final String CREATE_DEPARTMENT_COM = "type \"create -d department_name\" to create new department";

    public static final String DEPARTMENT_COM = "type \"departments\" to return to the list of departments";

    public static final String HELP_COM = "type \"help\" for command list";


//    private static final String[] rootCommandsArr = {DEPARTMENT_COM, OPEN_DEPARTMENT_COM, CREATE_DEPARTMENT_COM,
//            REMOVE_DEPARTMENT_COM, HELP_COM, EXIT_COM};
//
//    private static final String[] departmentCommandsArr = {OPEN_EMPLOYEE_COM, UPDATE_EMPLOYEE_COM, CREATE_EMPLOYEE_COM,
//            REMOVE_EMPLOYEE_COM, DEPARTMENT_COM, HELP_COM, EXIT_COM};
//
//    private static final String[] employeeCommandsArr = {UPDATE_EMPLOYEE_COM, DEPARTMENT_COM, OPEN_DEPARTMENT_COM,
//            HELP_COM, EXIT_COM};

//    private HashMap<String, String[]> commandsMap = new HashMap<String, String[]>();

    private static final HashMap<String, ArrayList<String>> commandPermissionsMap = new HashMap<String, ArrayList<String>>();
    private static final ArrayList<String> rootCommands = new ArrayList<String>();
    private static final ArrayList<String> departmentCommands = new ArrayList<String>();
    private static final ArrayList<String> employeeCommands = new ArrayList<String>();

    public CommandHolder() {
//        commandsMap.put(Node.ROOT_NODE_TYPE, rootCommandsArr);
//        commandsMap.put(Node.DEPARTMENT_NODE_TYPE, departmentCommandsArr);
//        commandsMap.put(Node.EMPLOYEE_NODE_TYPE, employeeCommandsArr);


        commandPermissionsMap.put(Node.ROOT_NODE_TYPE, rootCommands);
        commandPermissionsMap.put(Node.DEPARTMENT_NODE_TYPE, departmentCommands);
        commandPermissionsMap.put(Node.EMPLOYEE_NODE_TYPE, employeeCommands);

        rootCommands.add(DEPARTMENT_COM);
        rootCommands.add(OPEN_DEPARTMENT_COM);
        rootCommands.add(CREATE_DEPARTMENT_COM);
        rootCommands.add(REMOVE_DEPARTMENT_COM);
        rootCommands.add(HELP_COM);
        rootCommands.add(EXIT_COM);

        departmentCommands.add(OPEN_EMPLOYEE_COM);
        departmentCommands.add(UPDATE_EMPLOYEE_COM);
        departmentCommands.add(CREATE_EMPLOYEE_COM);
        departmentCommands.add(REMOVE_EMPLOYEE_COM);
        departmentCommands.add(DEPARTMENT_COM);
        departmentCommands.add(HELP_COM);
        departmentCommands.add(EXIT_COM);

        employeeCommands.add(UPDATE_EMPLOYEE_COM);
        employeeCommands.add(DEPARTMENT_COM);
        employeeCommands.add(OPEN_DEPARTMENT_COM);
        employeeCommands.add(HELP_COM);
        employeeCommands.add(EXIT_COM);

        commandPermissionsMap.put(Node.ROOT_NODE_TYPE, rootCommands);
        commandPermissionsMap.put(Node.DEPARTMENT_NODE_TYPE, departmentCommands);
        commandPermissionsMap.put(Node.EMPLOYEE_NODE_TYPE, employeeCommands);

    }

    public ArrayList<String> getCommands(String nodeType) {
        return commandPermissionsMap.get(nodeType);
    }

    public static boolean isCommandAllowed (String nodeType, String command){
        return commandPermissionsMap.get(nodeType).contains(command);
    }
}
