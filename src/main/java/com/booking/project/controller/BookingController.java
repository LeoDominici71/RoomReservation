package com.booking.project.controller;

import com.booking.project.dto.BookingUpdate;
import com.booking.project.dto.FindAvailablePlaces;
import com.booking.project.entities.Booking;
import com.booking.project.entities.Room;
import com.booking.project.services.ManageRoomService;
import com.booking.project.services.RegisterRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    @Autowired
    private ManageRoomService manageService;
    @Autowired
    private RegisterRoomService registerService;


    @PostMapping("/registerRoom")
    public ResponseEntity<Room> registerRoom(@RequestBody Room room){

        Room response = registerService.registerRoom(room);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(room.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);

    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        Booking response = manageService.createBooking(booking);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(booking.getId())
                .toUri();
        return ResponseEntity.created(uri).body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id){

        Booking response = manageService.findBookingById(id);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody BookingUpdate bookingUpdate, @PathVariable Long id){
        Booking response = manageService.updateBooking(id, bookingUpdate);

        return ResponseEntity.ok(response);

    }

    @PostMapping("/roomsAvailables")
    public ResponseEntity<List<Room>> findAvailablePlaces(@RequestBody FindAvailablePlaces places){
        List<Room> rooms = manageService.findAvailablesRoom(places.getDate(), places.getInicial(), places.getFinalDate());
        return ResponseEntity.ok(rooms);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){

        manageService.deleteBooking(id);

        return ResponseEntity.noContent().build();
    }


}
