package com.playground.uml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws ParseException {
        Employee manager = new Employee("John", "Connor", "Manager");

        manager.addRoom(new Room(1));
        manager.addRoom(new Room(2));

        IdCard cardForManager = new IdCard();
        cardForManager.setDateExpire(new SimpleDateFormat("yyyy-mm-dd").parse("2020-01-01"));
        manager.setIdCard(cardForManager);

        System.out.println(manager.getName() + " " + manager.getSurname() + " works as a " + manager.getPosition());
        System.out.println("The card is valid until " + new SimpleDateFormat("yyyy-dd-mm").format(cardForManager.getDateExpire()));
        System.out.print("He may be in the rooms: ");

        String rooms = manager.getRooms().stream()
                    .map(room -> String.valueOf(room.getNumber()))
                    .collect(Collectors.joining(", "));
        System.out.print(rooms);

    }
}