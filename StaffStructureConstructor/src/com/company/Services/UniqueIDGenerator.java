package com.company.Services;

import java.io.Serializable;

public class UniqueIDGenerator implements Serializable {

    private static UniqueIDGenerator INSTANCE;

    private static long UNIQUE_NODE_ID;
    private static long UNIQUE_EMPLOYEE_ID;

    private UniqueIDGenerator() {
        UNIQUE_NODE_ID = 0L;
        UNIQUE_EMPLOYEE_ID = 0L;
    }

    public static UniqueIDGenerator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UniqueIDGenerator();
        }
        return INSTANCE;
    }

    public long getNewNodeId() {
        UNIQUE_NODE_ID++;
        return UNIQUE_NODE_ID;
    }

    public long getNewEmployeeId() {
        UNIQUE_EMPLOYEE_ID++;
        return UNIQUE_EMPLOYEE_ID;
    }

    public long getCurrentEmployeeId() {
        return UNIQUE_EMPLOYEE_ID;
    }

    public long getCurrentNodeId() {
        return UNIQUE_NODE_ID;
    }

    public void loadUniqueEmployeeId(long uniqueEmployeeId){
        UNIQUE_EMPLOYEE_ID = uniqueEmployeeId;
    }

    public void loadNodeEmployeeId(long uniqueNodeId){
        UNIQUE_NODE_ID =  uniqueNodeId;
    }
}
