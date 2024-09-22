package com.booking.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class FindAvailablePlaces {

    private LocalDate date;
    private LocalDateTime inicial;
    private LocalDateTime finalDate;
}
