package com.playground.uml;

import java.util.HashSet;
import java.util.Set;

class Employee extends Man {

    private String position;

    //Binary association
    private IdCard idCard;

    //N-ary association
    private Set<Room> rooms = new HashSet<>();

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

    void addRoom(Room room) {
        rooms.add(room);
    }

    Set<Room> getRooms() {
        return rooms;
    }
}