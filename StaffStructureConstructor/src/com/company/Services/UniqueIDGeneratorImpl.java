package com.company.Services;

import com.company.DataHolder.DataHolderSingleton;

public class UniqueIDGeneratorImpl implements UniqueIdGenerator {
    public long getNewId(){
        return DataHolderSingleton.getInstance().incrementLastEmployeeId();
    }
}
