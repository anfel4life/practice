package com.company.StaffStructureEntities;


import java.util.LinkedList;

public class VisitedNodesStack {
    private static VisitedNodesStack instance;
    private static LinkedList<Node> NODES_STACK;

    private VisitedNodesStack() {
        NODES_STACK = new LinkedList<Node>();
        NODES_STACK.add(RootNode.getInstance());
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
        NODES_STACK.add(RootNode.getInstance());
    }

    public Node peekLast() {
        return NODES_STACK.peekLast();
    }

}
