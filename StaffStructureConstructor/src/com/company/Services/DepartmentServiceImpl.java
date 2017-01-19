package com.company.Services;


import com.company.StaffStructureEntities.*;


public class DepartmentServiceImpl implements DepartmentService {


    public DepartmentServiceImpl(){
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
    public String updateEmployee(long employeeId, String employeeName, short employeeAge, String employeeSkill) {

        if (employeeId == 0){
            return "Wrong employee id.";
        }

        long currentDepartmentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        Department currentDepartmentRef = FindNodeReferenceUtils.getDepartmentRef(currentDepartmentNodeId);

        Employee employee = FindNodeReferenceUtils.getEmployeeRef(employeeId);
        if (employee == null) {
            return "Employee with id \"" + employeeId + "\"doesn't exist.\n" +
                    StringConstructorUtils.getEmployeesList(currentDepartmentRef);
        }

        employee.setEmployeeName(employeeName);
        employee.setEmployeeAge(employeeAge);
        employee.setEmployeeSkill(employeeSkill);

        return "Info about employee with id \"" + employeeId + "\" was updated \n" +
                StringConstructorUtils.getEmployeesList(currentDepartmentRef);
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

        System.out.println(">>>> createEmployee " + VisitedNodesStack.getInstance().peekLast());
        long currentDepartmentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        Department currentDepartmentRef = FindNodeReferenceUtils.getDepartmentRef(currentDepartmentNodeId);

        System.out.println(">>>> createEmployee " + currentDepartmentRef);
        currentDepartmentRef.addEmployee(newEmployee);

        return "Employee with name \"" + employeeName + "\" was added to department " +
                currentDepartmentRef.getDepartmentName() + "\n" +
                StringConstructorUtils.getEmployeesList(currentDepartmentRef);
    }

    @Override
    public String removeEmployee(long employeeId) {

        long currentDepartmentNodeId = VisitedNodesStack.getInstance().peekLast().getNodeId();
        Department currentDepartmentRef = FindNodeReferenceUtils.getDepartmentRef(currentDepartmentNodeId);

        Employee employee = FindNodeReferenceUtils.getEmployeeRef(employeeId);
        if (employee == null) {
            return "Employee with id \"" + employeeId + "\"doesn't exist.\n" +
                    StringConstructorUtils.getEmployeesList(currentDepartmentRef);
        }
        currentDepartmentRef.getEmployeeSet().remove(employee);

        return "Employee with id \"" + employeeId + "\" was removed from " + currentDepartmentRef.getDepartmentName() + "\n" +
                StringConstructorUtils.getEmployeesList(currentDepartmentRef);
    }

}
