package com.company.Services;


import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.Employee;
import java.util.HashSet;

public abstract class StringConstructorUtils {

    private static int SYMBOLS_IN_CELL = 20;
    private static int SYMBOLS_IN_FILE = 10;
    private static String TABLE_HEAD_ID = "ID";
    private static String TABLE_HEAD_TYPE = "Type";
    private static String TABLE_HEAD_NAME = "Name";
    private static String TABLE_HEAD_AGE = "Age";


    public static String getEmployeesList(Department department) {

        StringBuilder list = new StringBuilder();
        HashSet<Employee> employeeSet = department.getEmployeeSet();
        if (employeeSet != null && !employeeSet.isEmpty()) {
            list.append("Employees list of ").append(department.getDepartmentName()).append(" department:\n");
            list.append("|-")
                    .append(symbolsBetweenColumns(TABLE_HEAD_ID))
                    .append("|-")
                    .append(symbolsBetweenColumns(TABLE_HEAD_TYPE))
                    .append("|-")
                    .append(symbolsBetweenColumns(TABLE_HEAD_NAME))
                    .append("|-")
                    .append(symbolsBetweenColumns(TABLE_HEAD_AGE))
                    .append("|\n");

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
            list.append("There aren't any employees in department ").append(department.getDepartmentName()).append(" yet.");
        }
        return list.toString();
    }

    private static String symbolsBetweenColumns(String value) {

        int symbolsLeft = SYMBOLS_IN_CELL - value.length();
        StringBuilder whiteSpaces = new StringBuilder(value);
        for (int i = 0; i < symbolsLeft; i++) {
            whiteSpaces.append("-");
        }
        return whiteSpaces.toString();
    }

    private static String whiteSpaces(String value) {

        int symbolsLeft = SYMBOLS_IN_FILE - value.length();
        StringBuilder whiteSpaces = new StringBuilder(value);
        for (int i = 0; i < symbolsLeft; i++) {
            whiteSpaces.append(" ");
        }
        return whiteSpaces.toString();
    }

    public static String getEmployeeInfo(Employee employee) {
        StringBuilder info = new StringBuilder();
        info.append("Employee ").append(employee.getEmployeeName()).append(":\n");

        info.append(whiteSpaces(TABLE_HEAD_ID)).append(":")
                .append(String.valueOf(employee.getEmployeeId()))
                .append("\n");
        info.append(whiteSpaces(TABLE_HEAD_TYPE)).append(":")
                .append(employee.getEmployeeType())
                .append("\n");
        info.append(whiteSpaces(TABLE_HEAD_AGE)).append(":")
                .append(String.valueOf(employee.getEmployeeAge()))
                .append("\n");

        if (employee.getEmployeeType().equals("Manager")) {
            info.append(whiteSpaces("Methodology")).append(":")
                    .append(employee.getEmployeeSkill())
                    .append("\n");
        } else if (employee.getEmployeeType().equals("Developer")) {
            info.append(whiteSpaces("Language")).append(":")
                    .append(employee.getEmployeeSkill())
                    .append("\n");
        }

        return info.toString();
    }

}
