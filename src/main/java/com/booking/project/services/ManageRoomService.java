package com.booking.project.services;

import com.booking.project.dto.BookingUpdate;
import com.booking.project.entities.Booking;
import com.booking.project.entities.Room;
import com.booking.project.repositories.BookingRepository;
import com.booking.project.repositories.RoomRepository;
import com.booking.project.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ManageRoomService {

    @Autowired
    private BookingRepository repository;
    @Autowired
    private RoomRepository roomRepo;


    public List<Room> findAvailablesRoom(LocalDate date, LocalDateTime inicial, LocalDateTime finalDate) {
        return roomRepo.findAvailableRooms(date, inicial, finalDate);

    }


    public Booking createBooking(Booking booking) {


        try {

            Optional<Booking> reservation = repository.findByRoomId(booking.getRoom().getId());

            if (reservation.isPresent()) {

                Booking reservationPresent = reservation.get();

                if (reservationPresent.getDate().equals(booking.getDate()) && reservationPresent.getInicialDateTime().equals(booking.getInicialDateTime())) {
                    throw new Exception("Room already reserved for date");
                }
            }

                return repository.save(booking);

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public Booking updateBooking(Long bookingId, BookingUpdate booking) {

        try {

            Booking oldBooking = repository.getReferenceById(bookingId);

            Optional<Booking> reservation = repository.findByRoomId(booking.getRoom().getId());
            Booking reservationPresent = reservation.orElseThrow(() -> new Exception("booking not found"));
            if (reservationPresent.getDate().equals(booking.getDate())  && reservationPresent.getInicialDateTime().equals(oldBooking.getInicialDateTime())) {
                throw new Exception("Room already reserved for date");
            }

            return repository.save(Mapper.toBooking(booking, oldBooking));

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    public void deleteBooking(Long bookingId) {
        repository.deleteById(bookingId);
    }

    public Booking findBookingById(Long bookingId) {

        Optional<Booking> booking = repository.findById(bookingId);

        return booking.orElseThrow(() -> new RuntimeException("Wrong id"));

    }

}