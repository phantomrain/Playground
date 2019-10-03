package com.playground.uml;

class Room implements Comparable<Room> {

    private int number;

    Room(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Room room) {
        return Integer.compare(number, room.getNumber());
    }
}