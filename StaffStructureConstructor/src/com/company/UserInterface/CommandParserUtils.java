package com.company.UserInterface;


public abstract class CommandParserUtils {
    private static final String INCORRECT_INPUT = "incorrect input";

    public static String usersCommandProcessing(String str){

        String resultMessage;
        String [] commandsArr = enterUsersCommand(str);

        switch(commandsArr[0].toLowerCase()) {
            case "create":
                resultMessage = (commandsArr.length >= 1) ? createStaffUnit(commandsArr) : INCORRECT_INPUT;
                break;

            case "rm":
                resultMessage = (commandsArr.length >= 1) ? removeStaffUnit(commandsArr) : INCORRECT_INPUT;
                break;

            case "open":
                resultMessage = (commandsArr.length >= 1) ? openStaffTree(commandsArr) : INCORRECT_INPUT;
                break;

            case "help":
                resultMessage = "help";
                break;

            case "departments":
                resultMessage = "help";
                break;

            case "update":
                resultMessage =  (commandsArr.length >= 1) ? updateStaffUnit(commandsArr) : INCORRECT_INPUT;
                break;

            default:
                resultMessage = INCORRECT_INPUT;
        }
        return resultMessage;
    }


    private static String [] enterUsersCommand(String str){
        str = str.trim();
        return str.split(" ");
    }


    private static String createStaffUnit(String [] commandsArr){
        String result;

        switch(commandsArr[1].toLowerCase()) {
            case "-d":
                //"create -d";
                result = (commandsArr.length >= 3) ? createDepartment(commandsArr[2]) : INCORRECT_INPUT;
                break;

            case "-e":
                //"create -e";
                result = (commandsArr.length >= 3) ? createEmployee(commandsArr[2]) : INCORRECT_INPUT;
                break;

            default:
                result = INCORRECT_INPUT;
        }
        return result;
    }

    //update -e
    private static String updateStaffUnit(String [] commandsArr){
        String result = INCORRECT_INPUT;
        if (commandsArr[1].toLowerCase().equals("-e")){
            result = (commandsArr.length >= 3) ? updateEmployee(commandsArr[2]) : INCORRECT_INPUT;
        }
        return result;
    }

    //open -d | open -e
    private static String openStaffTree(String [] commandsArr){
        String result = INCORRECT_INPUT;

        if (commandsArr.length >= 3) {
            switch (commandsArr[1].toLowerCase()){
                case "-d":
                    result = openDepartment(commandsArr[2]);
                    break;
                case "-e":
                    result = openEmployee(commandsArr[2]);
                    break;
                default:
                    result = INCORRECT_INPUT;
            }
        }
        return result;
    }

    //rm -d | rm -e
    private static String removeStaffUnit(String [] commandsArr){
        String result = INCORRECT_INPUT;

        if (commandsArr.length >= 3) {
            switch (commandsArr[1].toLowerCase()){
                case "-d":
                    result = removeDepartment(commandsArr[2]);
                    break;
                case "-e":
                    result = removeEmployee(commandsArr[2]);
                    break;
                default:
                    result = INCORRECT_INPUT;
            }
        }
        return result;
    }


    private static String openDepartment(String departmentName){
        return "open department " + departmentName;
    }

    private static String openEmployee(String employeeId){
        return "open employee " + employeeId;
    }

    private static String createDepartment(String departmentName){
        return "create department " + departmentName;
    }

    private static String removeDepartment(String departmentName){
        return "rm department " + departmentName;
    }

    private static String removeEmployee(String employeeId){
        return "rm employee " + employeeId;
    }

    private static String updateEmployee(String employeeId){
        return "update employee " + employeeId;
    }

    private static String createEmployee(String employeeName){
        return "create employee " + employeeName;
    }



}
