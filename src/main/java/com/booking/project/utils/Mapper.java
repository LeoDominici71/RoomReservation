package com.booking.project.utils;

import com.booking.project.dto.BookingUpdate;
import com.booking.project.entities.Booking;

public class Mapper {


    public static Booking toBooking(BookingUpdate newBooking, Booking booking) {
        if (newBooking.getRoom() != null) {
            booking.setRoom(newBooking.getRoom());
        }

        if (newBooking.getDate() != null) {
            booking.setDate(newBooking.getDate());
        }

        if (newBooking.getInicialDateTime() != null && newBooking.getFinalDateTime() != null) {
            booking.setInicialDateTime(newBooking.getInicialDateTime());
            booking.setFinalDateTime(newBooking.getFinalDateTime());

        }

        return booking;


    }
}
