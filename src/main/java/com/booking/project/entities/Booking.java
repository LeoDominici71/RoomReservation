package com.booking.project.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne()
    @JoinColumn(name = "room_id")
    private Room room;
    private LocalDate date;
    private LocalDateTime inicialDateTime;
    private LocalDateTime finalDateTime;

}
