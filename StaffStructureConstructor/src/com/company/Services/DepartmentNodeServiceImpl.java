package com.company.Services;


import com.company.StaffStructureEntities.*;

public class DepartmentNodeServiceImpl implements DepartmentNodeService {

    public DepartmentNodeServiceImpl() {
    }

    @Override
    public String openEmployee(long employeeId) {

        Employee employee = FindNodeReferenceUtils.getEmployeeRef(employeeId);
        if (employee == null) {
            return "Employee with id \"" + employeeId + "\"doesn't exist";
        }
        VisitedNodesStack.getInstance().setNode(employee);
        return StringConstructorUtils.getEmployeeInfo(employee);
    }

    @Override
    public String updateEmployee(long employeeId, String employeeName, short employeeAge, String skillKey,
                                 String employeeSkill) {

        Node node = VisitedNodesStack.getInstance().peekLast();
        long currentDepartmentNodeId;

        if (node.getNodeType().equals(Node.EMPLOYEE_NODE_TYPE)) {
            currentDepartmentNodeId = VisitedNodesStack.getInstance().getPreviousNode(node).getNodeId();
        } else {
            currentDepartmentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        }
        Department currentDepartmentRef = FindNodeReferenceUtils.getDepartmentRef(currentDepartmentNodeId);

        Employee employee = FindNodeReferenceUtils.getEmployeeRef(employeeId);

        if (employee == null) {
            return "Employee with id \"" + employeeId + "\"doesn't exist.\n" +
                    getEmployeeList(currentDepartmentRef);
        }


        if (employee.getEmployeeType().equals("Manager") && skillKey.equals("-l")){
            return "The manager doesn\'t have language field";
        } else if (employee.getEmployeeType().equals("Developer") && skillKey.equals("-m")){
            return "The developer doesn\'t have methodology field";
        }

        employee.setEmployeeName(employeeName);
        employee.setEmployeeAge(employeeAge);
        employee.setEmployeeSkill(employeeSkill);

        return "Info about employee with id \"" + employeeId + "\" was updated \n" +
                getEmployeeList(currentDepartmentRef);
    }


    @Override
    public String createEmployee(String employeeName, String employeeType, short employeeAge, String employeeSkill) {

        Employee newEmployee;

        switch (employeeType) {
            case "m":
                newEmployee = new Manager();
                break;
            case "d":
                newEmployee = new Developer();
                break;
            default:
                return "Wrong employee type.";
        }
        newEmployee.setEmployeeName(employeeName);
        newEmployee.setEmployeeAge(employeeAge);
        newEmployee.setEmployeeSkill(employeeSkill);
        long currentDepartmentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        Department currentDepartmentRef = FindNodeReferenceUtils.getDepartmentRef(currentDepartmentNodeId);
        currentDepartmentRef.addEmployee(newEmployee);
        return "Employee with name \"" + employeeName + "\" was added to department " +
                currentDepartmentRef.getDepartmentName() + "\n" +
                getEmployeeList(currentDepartmentRef);
    }

    @Override
    public String getEmployeeList(Department department) {
        VisitedNodesStack.getInstance().setNode(department);
        return StringConstructorUtils.getEmployeesList(department);
    }

    @Override
    public String removeEmployee(long employeeId) {

        long currentDepartmentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        Department currentDepartmentRef = FindNodeReferenceUtils.getDepartmentRef(currentDepartmentNodeId);

        Employee employee = FindNodeReferenceUtils.getEmployeeRef(employeeId);
        if (employee == null) {
            return "Employee with id \"" + employeeId + "\"doesn't exist.\n" +
                    getEmployeeList(currentDepartmentRef);
        }
        currentDepartmentRef.getEmployeeSet().remove(employee);

        return "Employee with id \"" + employeeId + "\" was removed from " + currentDepartmentRef.getDepartmentName() + "\n" +
                getEmployeeList(currentDepartmentRef);
    }

}
