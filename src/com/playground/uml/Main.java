package com.playground.uml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {

    private static final String DEVELOPER = "Developer";
    private static Date yearBeginning;
    private static final Department DEVELOPERS = new Department("Developers");
    private static final Room DEVELOPERS_ROOM = new Room(2);

    static {
        try {
            yearBeginning = new SimpleDateFormat("yyyy-mm-dd").parse("2020-01-01");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee john = new Employee("John", "Connor", "System Administrator");
        john.addRoom(DEVELOPERS_ROOM);
        john.setIdCard(new IdCard(yearBeginning));
        john.setDepartment(DEVELOPERS);

        john.setPosition(DEVELOPER, DEVELOPERS);

        john.setPosition("Manager", new Department("Managers"));
        Room managerRoom = new Room(1);
        john.addRoom(managerRoom);

        Employee albert = addAndGetDeveloper("Albert", "O’Connor");
        Employee adam = addAndGetDeveloper("Adam", "Gordon");

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(albert);
        employees.add(adam);

        //Dependency
        Menu.showEmployees(employees);
    }

    private static Employee addAndGetDeveloper(String name, String surname) {
        Employee employee = new Employee(name, surname, DEVELOPER);
        employee.setIdCard(new IdCard(yearBeginning));
        employee.addRoom(DEVELOPERS_ROOM);
        DEVELOPERS.addEmployee(employee);

        return employee;
    }
}