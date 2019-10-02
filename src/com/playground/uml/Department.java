package com.playground.uml;

import java.util.HashSet;
import java.util.Set;

class Department {

    private String name;

    //aggregation
    private Set<Employee> employees = new HashSet<>();

    Department(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addEmpoyee(Employee newEmployee) {
        employees.add(newEmployee);
        newEmployee.setDepartment(this);
    }
}
