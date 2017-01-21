package com.company.Services;


import com.company.StaffStructureEntities.Department;
import com.company.StaffStructureEntities.RootNode;
import com.company.StaffStructureEntities.VisitedNodesStack;
import java.util.HashSet;

public class RootNodeServiceImpl implements RootNodeService {

    private DepartmentNodeService departmentNodeService;

    public RootNodeServiceImpl() {
        departmentNodeService = new DepartmentNodeServiceImpl();
    }

    @Override
    public String createDepartment(String newDepartmentName) {
        if (FindNodeReferenceUtils.getDepartmentRef(newDepartmentName) != null) {
            return "The department with name " + newDepartmentName + " already exists. \n" + getDepartmentsList();
        }

        Department department = new Department();
        department.setDepartmentName(newDepartmentName);
        RootNode.getInstace().addDepartment(department);
        return "Department " + newDepartmentName + " was created. \n" + getDepartmentsList();
    }

    @Override
    public String removeDepartment(String departmentName) {
        Department departmentForRemoving = FindNodeReferenceUtils.getDepartmentRef(departmentName);
        if (departmentForRemoving != null) {
            RootNode.getInstace().removeDepartment(departmentForRemoving);
            return "Department " + departmentName + " was removed.\n" + getDepartmentsList();
        }
        return "Department " + departmentName + " doesn't exist." + getDepartmentsList();
    }

    @Override
    public String getDepartmentsList() {
        StringBuilder departmentsCount = new StringBuilder();
        HashSet<Department> staffStructureSet = RootNode.getInstace().getStaffStructureSet();
        if (staffStructureSet != null && !staffStructureSet.isEmpty()) {
            departmentsCount.append("Departments list: \n");
            for (Department department : staffStructureSet) {
                departmentsCount.append(department.getDepartmentName()).append("\n");
            }
        }

        if (departmentsCount.length() == 0) {
            departmentsCount.append("No departments");
        }
        return departmentsCount.toString();
    }

    @Override
    public String openDepartment(String departmentName) {
        Department department = FindNodeReferenceUtils.getDepartmentRef(departmentName);
        if (department == null) {
            return "Department with name " + departmentName + " doesn't exist.\n" + getDepartmentsList();
        }
        VisitedNodesStack.getInstance().setNode(department);
        return departmentNodeService.getEmployeeList(department);
    }

}
