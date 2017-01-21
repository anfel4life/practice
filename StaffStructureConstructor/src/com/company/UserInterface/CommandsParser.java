package com.company.UserInterface;


public class CommandsParser {

    private static final String INCORRECT_INPUT = "Incorrect input! Enter \"help\" for commands list. ";
    private CommandsController comControl;

    public CommandsParser() {
        comControl = new CommandsControllerImpl();
    }

    private static String[] enterUsersCommand(String str) {
        str = str.trim();
        return str.split(" ");
    }

    public String usersCommandProcessing(String str) {

        String resultMessage;
        String[] commandsArr = enterUsersCommand(str);

        switch (commandsArr[0].toLowerCase()) {

            case "":
                resultMessage = "You didn't enter any commands";
                break;
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
                resultMessage = comControl.help();
                break;

            case "departments":
                resultMessage = comControl.departmentsList();
                break;

            case "update":
                resultMessage = (commandsArr.length >= 1) ? updateStaffUnitParse(commandsArr) : INCORRECT_INPUT;
                break;

            case "exit":
                resultMessage = (commandsArr.length >= 1) ? updateStaffUnitParse(commandsArr) : INCORRECT_INPUT;
                break;

            case "save":
                resultMessage = comControl.saveStaffStructure();
                break;

            case "load":
                resultMessage = comControl.loadStaffStructure();
                break;

            default:
                resultMessage = INCORRECT_INPUT;
        }
        return resultMessage;
    }

    //create -e|-d
    private String createStaffUnit(String[] commandsArr) {
        String resultMessage;

        switch (commandsArr[1].toLowerCase()) {
            case "-d":
                //"create -d";
                resultMessage = (commandsArr.length >= 3) ? comControl.createNewDepartment(commandsArr[2]) : INCORRECT_INPUT;
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
                    resultMessage = comControl.openDepartment(commandsArr[2]);
                    break;
                case "-e":
                    resultMessage = comControl.openEmployee(commandsArr[2]);
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
                    resultMessage = comControl.removeDepartment(commandsArr[2]);
                    break;
                case "-e":
                    resultMessage = comControl.removeEmployee(commandsArr[2]);
                    break;
                default:
                    resultMessage = INCORRECT_INPUT;
            }
        }
        return resultMessage;
    }

    //create -e dn department_name -n employee_name -t m|d  -a age -m\-l
    //create -e -n employee_name -t m|d -a age -m|-l Canban|Java
    private String createEmployeeParse(String[] commandsArr) {
        String name = "";
        String type = "";
        short age = 0;
        String language = "";
        String methodology = "";
        String department = "";
        String skill;

        int arrElemCounter = commandsArr.length - 1;

        for (int i = 0; i < commandsArr.length; i++) {

            if (commandsArr[i].isEmpty()) continue;

            if (commandsArr[i].equals("-dn") && i < arrElemCounter) {
                department = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-n") && i < arrElemCounter) {
                name = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-t") && i < arrElemCounter) {
                type = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-a") && i < arrElemCounter) {
                try {
                    age = Short.valueOf(commandsArr[i + 1]);
                } catch (NumberFormatException e) {
                    age = 0;
                }
            } else if (commandsArr[i].equals("-l") && i < arrElemCounter) {
                language = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-m") && i < arrElemCounter) {
                methodology = commandsArr[i + 1];
            }
        }

        if (type.equals("d") && !methodology.isEmpty()) {
            return "The developer doesn\'t have methodology field";
        } else if (type.equals("m") && !language.isEmpty()) {
            return "The manager doesn\'t have methodology Language";
        }

        skill = getSkill(type, language, methodology);

        if (!department.isEmpty()) {
            return comControl.createEmployee(department, name, type, age, skill);
        }
        return comControl.createEmployee(name, type, age, skill);
    }

    private String getSkill(String type, String language, String methodology) {
        String skill;
        switch (type) {
            case "d":
                skill = language;
                break;
            case "m":
                skill = methodology;
                break;
            default:
                skill = "";
        }
        return skill;
    }

    //update -e employee_id -n employee_name -a short -m|-l Canban|Java
    private String updateEmployeeParse(String[] commandsArr) {
        long id = 0L;
        String name = "";
        String skillKey = "";
        short age = 0;
        String skill = "";
        int arrElemCounter = commandsArr.length - 1;

        for (int i = 0; i < commandsArr.length; i++) {

            if (commandsArr[i].isEmpty()) continue;

            if (commandsArr[i].equals("-e") && i < arrElemCounter) {
                try {
                    id = Long.valueOf(commandsArr[i + 1]);
                } catch (NumberFormatException e) {
                    id = 0L;
                }
            } else if (commandsArr[i].equals("-n") && i < arrElemCounter) {
                name = commandsArr[i + 1];
            } else if (commandsArr[i].equals("-a") && i < arrElemCounter) {
                try {
                    age = Short.valueOf(commandsArr[i + 1]);
                } catch (NumberFormatException e) {
                    age = 0;
                }
            } else if ((commandsArr[i].equals("-l") || commandsArr[i].equals("-m")) && i < arrElemCounter) {
                skillKey = commandsArr[i];
                skill = commandsArr[i + 1];
            }
        }

        return comControl.updateEmployee(id, name, age, skillKey, skill);
    }

}
