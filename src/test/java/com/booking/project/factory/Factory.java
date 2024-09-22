package com.booking.project.factory;

import com.booking.project.dto.FindAvailablePlaces;
import com.booking.project.entities.Booking;
import com.booking.project.entities.Room;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factory {

    public static Room createRoom(){

        Room room = new Room();

        room.setRoomNumber("23");
        room.setCapacity(4);
        room.setTelevision(true);
        room.setLocalization("Corridor green");
        room.setVideoProjector(true);

        return room;

    }

    public static FindAvailablePlaces createFindPlacesAvailables(){

        FindAvailablePlaces places = new FindAvailablePlaces();
        places.setDate(LocalDate.now());
        places.setInicial(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        places.setFinalDate(LocalDateTime.parse("2024-09-19 18:41:18", formatter));




        return places;

    }

    public static Booking createABooking(){


        Booking booking = new Booking();

        booking.setInicialDateTime(LocalDateTime.now());
        booking.setDate(LocalDate.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        booking.setFinalDateTime(LocalDateTime.parse("2024-09-19 18:41:18", formatter));

        Room room = new Room();
        room.setId(1L);
        room.setRoomNumber("23");
        room.setCapacity(4);
        room.setTelevision(true);
        room.setLocalization("Corridor green");
        room.setVideoProjector(true);

        booking.setRoom(room);

        return booking;

    }

    public static Booking updateABooking(){


        Booking booking = new Booking();

        booking.setInicialDateTime(LocalDateTime.now());
        booking.setDate(LocalDate.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        booking.setFinalDateTime(LocalDateTime.parse("2024-09-19 19:41:18", formatter));

        Room room = new Room();
        room.setId(1L);
        room.setRoomNumber("23");
        room.setCapacity(4);
        room.setTelevision(true);
        room.setLocalization("Corridor green");
        room.setVideoProjector(true);

        booking.setRoom(room);

        return booking;

    }


}
