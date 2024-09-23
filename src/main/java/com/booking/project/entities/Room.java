package com.booking.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomNumber;
    private Integer capacity;
    private String localization;
    private Boolean television;
    private Boolean videoProjector;
    @JsonIgnore
    @OneToOne(mappedBy = "room")
    private Booking booking;



}
