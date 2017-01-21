package com.company.StaffStructureEntities;


import java.util.LinkedList;

public class VisitedNodesStack {
    private static VisitedNodesStack INSTANCE;
    private static LinkedList<Node> NODES_STACK;

    private VisitedNodesStack() {
        NODES_STACK = new LinkedList<Node>();
        NODES_STACK.add(RootNode.getInstace());
    }

    public static VisitedNodesStack getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new VisitedNodesStack();
        }
        return INSTANCE;
    }

    public void setNode(Node node) {
        if (node.getNodeId() != NODES_STACK.peekLast().getNodeId()) {
            NODES_STACK.add(node);
        }
    }

    public Node getPreviousNode(Node node) {
        int lastIndex = NODES_STACK.lastIndexOf(node);
        if (lastIndex > 0) {
            return NODES_STACK.get(lastIndex - 1);
        }
        return null;
    }

    public void clear() {
        NODES_STACK.clear();
        NODES_STACK.add(RootNode.getInstace());
    }

    public Node peekLast() {
        return NODES_STACK.peekLast();
    }
}
