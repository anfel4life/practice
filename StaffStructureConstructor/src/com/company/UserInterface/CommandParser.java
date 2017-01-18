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
                resultMessage = (commandsArr.length >= 1) ? removeStaffUnitParse(commandsArr) : INCORRECT_INPUT;
                break;

            case "open":
                resultMessage = (commandsArr.length >= 1) ? openStaffTree(commandsArr) : INCORRECT_INPUT;
                break;

            case "help":
                resultMessage = help();
                break;

            case "departments":
//                System.out.println(">>>CPU: switch departmentsList()");
                resultMessage = departmentsList();
                break;

            case "update":
                resultMessage = (commandsArr.length >= 1) ? updateStaffUnitParse(commandsArr) : INCORRECT_INPUT;
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
                resultMessage = (commandsArr.length >= 3) ? createEmployeeParse(commandsArr) : INCORRECT_INPUT;
                break;

            default:
                resultMessage = INCORRECT_INPUT;
        }
        return resultMessage;
    }

    //update -e
    private String updateStaffUnitParse(String[] commandsArr) {
        String resultMessage = INCORRECT_INPUT;
        if (commandsArr[1].toLowerCase().equals("-e")) {
            resultMessage = (commandsArr.length >= 3) ? updateEmployeeParse(commandsArr) : INCORRECT_INPUT;
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
    private String removeStaffUnitParse(String[] commandsArr) {
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

    private String createEmployeeParse(String [] commandsArr){
        long id = 0L;
        String name = "";
        String type = "";
        short age = 0;
        String language = "";
        String methodology = "";
        String skill;

        for (int i = 0; i < commandsArr.length; i++ ){
            if (commandsArr[i].equals("-e")){
                try {
                    id = Long.valueOf(commandsArr[i + 1]);
                } catch (NumberFormatException e) {
                    id = 0L;
                }
            } else if (commandsArr[i].equals("-n") && i <= commandsArr.length){
                name = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-t") && i <= commandsArr.length){
                type = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-a") && i <= commandsArr.length){
                try {
                    age = Short.valueOf(commandsArr[i + 1]);
                } catch (NumberFormatException e) {
                    age = 0;
                }
            } else if (commandsArr[i].equals("-l")  && i <= commandsArr.length){
                language= commandsArr[i + 1];
            } else if (commandsArr[i].equals("-m") && i <= commandsArr.length){
                methodology = commandsArr[i + 1];
            }
        }
        skill = getSkill(type, language,  methodology);
//        System.out.println("name: " + name + "; type: " + type + "; age:" + age + "; skill: " + skill);
        return createEmployee(name, type, age, skill);
    }


    private String updateEmployeeParse(String [] commandsArr){
        long id = 0;
        String name = "";
        String type = "";
        short age = 0;
        String language = "";
        String methodology = "";
        String skill;

        for (int i = 0; i < commandsArr.length; i++ ){
            if (commandsArr[i].equals("-n") && i <= commandsArr.length){
                name = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-t") && i <= commandsArr.length){
                type = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-a") && i <= commandsArr.length){
                try {
                    age = Short.valueOf(commandsArr[i + 1]);
                } catch (NumberFormatException e) {
                    age = 0;
                }
            } else if (commandsArr[i].equals("-l")  && i <= commandsArr.length){
                language= commandsArr[i + 1];
            } else if (commandsArr[i].equals("-m") && i <= commandsArr.length){
                methodology = commandsArr[i + 1];
            }
        }
        skill = getSkill(type, language,  methodology);

        return updateEmployee(id, name, type, age, skill);
    }

    private String getSkill(String type, String language, String methodology) {
        String skill;
        switch (type){
            case "d":
                skill = language;
                break;
            case "m":
                skill = methodology;
                break;
            default:
                skill = "";
        }
        return  skill;
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

    private String updateEmployee(long id, String employeeName, String employeeType, short employeeAge, String employeeSkill) {
        return comControl.updateEmployee(id, employeeName, employeeType, employeeAge, employeeSkill);
    }

    private String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill) {
        return comControl.addEmployee(employeeName, employeeType, employeeAge, employeeSkill);
    }

    private String departmentsList() {
        return comControl.departmentsList();
    }

    private String help() {
        return comControl.commandsList();
    }

}
