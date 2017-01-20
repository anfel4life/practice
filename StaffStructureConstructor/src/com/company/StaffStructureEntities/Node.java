package com.company.StaffStructureEntities;


import com.company.UserInterface.CommandsHolder;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Node implements Serializable {

    public static String ROOT_NODE_TYPE = "root";
    public static String DEPARTMENT_NODE_TYPE = "department";
    public static String EMPLOYEE_NODE_TYPE = "employee";

    private CommandsHolder commandsHolder;

    public Node() {
        commandsHolder = new CommandsHolder();
    }

    public abstract void setNodeId();

    public abstract long getNodeId();

    public abstract String getNodeType();

    public ArrayList<String> getNodeCommands(String nodeType) {
        return commandsHolder.getCommands(nodeType);
    }
}
