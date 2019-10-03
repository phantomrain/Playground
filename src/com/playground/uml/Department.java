package com.playground.uml;

import java.util.HashSet;
import java.util.Set;

class Department implements Unit /* Realization */ {

    private String name;

    //Aggregation
    private Set<Employee> employees = new HashSet<>();

    Department(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        newEmployee.setDepartment(this);
    }

    @Override
    public int getPersonCount() {
        return employees.size();
    }
}
