package com.company.Services;

public class UniqueIDGenerator {

    private static UniqueIDGenerator instance;

    private static long uniqueNodeId;
    private static long uniqueEmployeeId;

    private UniqueIDGenerator() {
        uniqueNodeId = 0L;
        uniqueEmployeeId = 0L;
    }

    public static UniqueIDGenerator getInstance() {
        if (instance == null) {
            instance = new UniqueIDGenerator();
        }
        return instance;
    }

    public long getNewNodeId() {
        uniqueNodeId++;
        return uniqueNodeId;
    }

    public long getNewEmployeeId() {
        uniqueEmployeeId++;
        return uniqueEmployeeId;
    }

    public long getCurrentEmployeeId() {
        return uniqueEmployeeId;
    }

}
