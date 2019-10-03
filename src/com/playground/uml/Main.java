package com.playground.uml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


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

        printInfoFor(john);

        Employee albert = addAndGetDeveloper("Albert", "O’Connor");
        printInfoFor(albert);
        Employee adam = addAndGetDeveloper("Adam", "Gordon");
        printInfoFor(adam);
    }

    private static Employee addAndGetDeveloper(String name, String surname) {
        Employee employee = new Employee(name, surname, DEVELOPER);
        employee.setIdCard(new IdCard(yearBeginning));
        employee.addRoom(DEVELOPERS_ROOM);
        DEVELOPERS.addEmpoyee(employee);

        return employee;
    }

    private static void printInfoFor(Employee employee) {
        System.out.println(employee.getName() + " " + employee.getSurname() + " works as a " + employee.getPosition());
        System.out.println("The card is valid until " + new SimpleDateFormat("yyyy-dd-mm").format(employee.getIdCard().getDateExpire()));

        printRoomsInfo(employee);

        Department department = employee.getDepartment();
        if (department != null) {
            System.out.println("He belongs to the " + department.getName() + " department");
        }

        printPastPositionInfoIfExists(employee);
        System.out.println();
    }

    private static void printPastPositionInfoIfExists(Employee employee) {
        Set<PastPosition> positions = employee.getPastPositions();
        if (positions.isEmpty()) {
            return;
        }

        System.out.print("Previously, he worked as a: ");
        String pastPositions = positions.stream()
                    .map(position -> position.getName() + " (Department: " + position.getDepartmentName() + ")")
                    .collect(joinByComma());
        System.out.println(pastPositions);
    }

    private static void printRoomsInfo(Employee manager) {
        System.out.print("He may be in the rooms: ");

        String rooms = manager.getRooms().stream()
                    .map(room -> String.valueOf(room.getNumber()))
                    .collect(joinByComma());
        System.out.println(rooms);
    }

    private static Collector<CharSequence, ?, String> joinByComma() {
        return Collectors.joining(", ");
    }
}