package com.playground.uml;

class PastPosition {

    private String name;
    private Department department;

    PastPosition(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    String getName() {
        return name;
    }

    String getDepartmentName() {
        return department.getName();
    }
}