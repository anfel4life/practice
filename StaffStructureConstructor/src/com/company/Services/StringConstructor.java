package com.company.Services;


import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Employee;

import java.util.HashSet;

public class StringConstructor {

    public static String getEmployeesList(Department department) {
        StringBuilder list = new StringBuilder();
        HashSet<Employee> employeeSet = department.getEmployeeSet();
        if (employeeSet != null && !employeeSet.isEmpty()) {
            list.append("|-----ID----|").append("---Type----|").append("---Name----|").append("----Age----|\n");
            for (Employee employee : employeeSet) {

                list.append("|-")
                        .append(symbolsBetweenColumns(String.valueOf(employee.getEmployeeId())))
                        .append("|-")
                        .append(symbolsBetweenColumns(employee.getEmployeeType()))
                        .append("|-")
                        .append(symbolsBetweenColumns(employee.getEmployeeName()))
                        .append("|-")
                        .append(symbolsBetweenColumns(String.valueOf(employee.getEmployeeAge())))
                        .append("|\n");
            }

        } else {
            list.append("There aren't any employees in this department yet");
        }
        return list.toString();
    }

    private static String symbolsBetweenColumns(String value){

        int symbolsInCell = 10;
        int symbolsLeft = symbolsInCell - value.length();
        StringBuilder whiteSpaces = new StringBuilder(value);
        for (int i = 0; i < symbolsLeft; i++){
            whiteSpaces.append("-");
        }
        return whiteSpaces.toString();
    }
}
