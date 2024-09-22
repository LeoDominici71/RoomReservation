package com.booking.project.dto;

import com.booking.project.entities.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookingUpdate {

    private Room room;
    private LocalDate date;
    private LocalDateTime inicialDateTime;
    private LocalDateTime finalDateTime;
}
