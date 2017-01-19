package com.company.StaffStructureEntities;


import com.company.UserInterface.CommandHolder;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Node {

    public static String ROOT_NODE_TYPE = "root";
    public static String DEPARTMENT_NODE_TYPE = "department";
    public static String EMPLOYEE_NODE_TYPE = "employee";
    private CommandHolder commandHolder;

    public Node() {
        commandHolder = new CommandHolder();
    }

    public abstract void setNodeId();

    public abstract long getNodeId();

    public abstract void setNodeType(String nodeType);

    public abstract void setNodeName(String nodeName);

    public abstract String getNodeType();

    public abstract String getNodeName();

    public ArrayList<String> getNodeCommands(String nodeType) {
        return commandHolder.getCommands(nodeType);
    }
}
