package com.company.UserInterface;


public class CommandParser {

    private CommandController comControl;

    private static final String INCORRECT_INPUT = "Incorrect input! Enter \"help\" for commands list. ";

    public CommandParser() {
        comControl = new CommandController();
    }

    public String usersCommandProcessing(String str) {

        String resultMessage;
        String[] commandsArr = enterUsersCommand(str);

        switch (commandsArr[0].toLowerCase()) {
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
                resultMessage = help();
                break;

            case "departments":
//                System.out.println(">>>CPU: switch departmensList()");
                resultMessage = departmentsList();
                break;

            case "update":
                resultMessage = (commandsArr.length >= 1) ? updateStaffUnit(commandsArr) : INCORRECT_INPUT;
                break;

            default:
                resultMessage = INCORRECT_INPUT;
        }
        return resultMessage;
    }

    private static String[] enterUsersCommand(String str) {
        str = str.trim();
        return str.split(" ");
    }

    private String createStaffUnit(String[] commandsArr) {
        String resultMessage;

        switch (commandsArr[1].toLowerCase()) {
            case "-d":
                //"create -d";
                resultMessage = (commandsArr.length >= 3) ? createDepartment(commandsArr[2]) : INCORRECT_INPUT;
                break;

            case "-e":
                //"create -e";
                resultMessage = (commandsArr.length >= 3) ? createEmployee(commandsArr[2]) : INCORRECT_INPUT;
                break;

            default:
                resultMessage = INCORRECT_INPUT;
        }
        return resultMessage;
    }

    //update -e
    private String updateStaffUnit(String[] commandsArr) {
        String resultMessage = INCORRECT_INPUT;
        if (commandsArr[1].toLowerCase().equals("-e")) {
            resultMessage = (commandsArr.length >= 3) ? updateEmployee(commandsArr[2]) : INCORRECT_INPUT;
        }
        return resultMessage;
    }

    //open -d | open -e
    private String openStaffTree(String[] commandsArr) {
        String resultMessage = INCORRECT_INPUT;

        if (commandsArr.length >= 3) {
            switch (commandsArr[1].toLowerCase()) {
                case "-d":
                    resultMessage = openDepartment(commandsArr[2]);
                    break;
                case "-e":
                    resultMessage = openEmployee(commandsArr[2]);
                    break;
                default:
                    resultMessage = INCORRECT_INPUT;
            }
        }
        return resultMessage;
    }

    //rm -d | rm -e
    private String removeStaffUnit(String[] commandsArr) {
        String resultMessage = INCORRECT_INPUT;

        if (commandsArr.length >= 3) {
            switch (commandsArr[1].toLowerCase()) {
                case "-d":
                    resultMessage = removeDepartment(commandsArr[2]);
                    break;
                case "-e":
                    resultMessage = removeEmployee(commandsArr[2]);
                    break;
                default:
                    resultMessage = INCORRECT_INPUT;
            }
        }
        return resultMessage;
    }


    private String openDepartment(String departmentName) {
        return comControl.openDepartment(departmentName);
    }

    private String openEmployee(String employeeId) {
        return "open employee " + employeeId;
    }

    private String createDepartment(String departmentName) {
        return comControl.createNewDepartment(departmentName);
    }

    private  String removeDepartment(String departmentName) {
        return comControl.removeDepartment(departmentName);
    }

    private String removeEmployee(String employeeId) {
        return "rm employee " + employeeId;
    }

    private String updateEmployee(String employeeId) {
        return "update employee " + employeeId;
    }

    private String createEmployee(String employeeName) {
        return comControl.addEmployee(employeeName);
    }

    private String departmentsList() {
        return comControl.departmensList();
    }

    private String help() {
        return comControl.commandsList();
    }

}
