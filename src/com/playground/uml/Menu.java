package com.playground.uml;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Menu {

    static void showEmployees(List<Employee> employees) {
        System.out.println("List of employees:");
        System.out.println();

        employees.forEach(Menu::printInfo);
    }

    private static void printInfo(Employee employee) {
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
