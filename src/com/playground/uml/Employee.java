package com.playground.uml;

import java.util.HashSet;
import java.util.Set;

class Employee extends Man {

    private String position;

    //Binary association
    private IdCard idCard;

    //N-ary association
    private Set<Room> rooms = new HashSet<>();

    //Aggregation
    private Department department;

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
}