package com.company.StaffStructureEntities;


public class Developer extends Employee {
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmployeeType() {
        return "Developer";
    }
}
