package com.playground.uml;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class Employee extends Man {

    private String position;

    //Binary association
    private IdCard idCard;

    //N-ary association
    private SortedSet<Room> rooms = new TreeSet<>();

    //Aggregation
    private Department department;

    //Composition
    private Set<PastPosition> pastPositions = new HashSet<>();

    Employee(String name, String surname, String position) {
        super(name, surname);
        this.position = position;
    }

    String getPosition() {
        return position;
    }

    void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    IdCard getIdCard() {
        return idCard;
    }

    void addRoom(Room room) {
        rooms.add(room);
    }

    Set<Room> getRooms() {
        return rooms;
    }

    void setDepartment(Department department) {
        this.department = department;
    }

    Department getDepartment() {
        return department;
    }

    Set<PastPosition> getPastPositions() {
        return pastPositions;
    }

    void setPosition(String newPosition, Department newDepartment) {
        pastPositions.add(new PastPosition(position, department));
        position = newPosition;
        department = newDepartment;
    }
}