package com.company.UserInterface;


import com.company.DataHolder.DataHolderSingleton;
import com.company.StaffStructureEntities.Node;

import java.util.LinkedList;

public class VisitedNodesStack {
    private static VisitedNodesStack instance;
    private static LinkedList<Node> NODES_STACK;

    private VisitedNodesStack() {
        NODES_STACK = new LinkedList<Node>();
        NODES_STACK.add(DataHolderSingleton.getInstance());
    }

    public static VisitedNodesStack getInstance() {
        if (instance == null) {
            instance = new VisitedNodesStack();
        }
        return instance;
    }

    public void setNode(Node node) {
        NODES_STACK.add(node);
    }

    public void clear() {
        NODES_STACK.clear();
        NODES_STACK.add(DataHolderSingleton.getInstance());
    }

    public Node peekLast() {
        return NODES_STACK.peekLast();
    }
}
