package com.playground.uml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;


public class Main {

    private static Date yearBeginning;
    private static final Department developers = new Department("Developers");
    private static final Room developersRoom = new Room(2);

    static {
        try {
            yearBeginning = new SimpleDateFormat("yyyy-mm-dd").parse("2020-01-01");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee manager = new Employee("John", "Connor", "Manager");

        Room managerRoom = new Room(1);
        manager.addRoom(managerRoom);
        manager.addRoom(developersRoom);
        manager.setIdCard(new IdCard(yearBeginning));

        printInfoFor(manager);

        Employee albert = addAndGetDeveloper("Albert", "O’Connor", "Developer");
        printInfoFor(albert);
        Employee adam = addAndGetDeveloper("Adam", "Gordon", "Developer");
        printInfoFor(adam);
    }

    private static Employee addAndGetDeveloper(String name, String surname, String position) {
        Employee employee = new Employee(name, surname, position);
        employee.setIdCard(new IdCard(yearBeginning));
        employee.addRoom(developersRoom);
        developers.addEmpoyee(employee);

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

        System.out.println();
    }

    private static void printRoomsInfo(Employee manager) {
        System.out.print("He may be in the rooms: ");

        String rooms = manager.getRooms().stream()
                    .map(room -> String.valueOf(room.getNumber()))
                    .collect(Collectors.joining(", "));
        System.out.println(rooms);
    }
}