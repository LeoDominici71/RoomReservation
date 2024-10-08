package com.booking.project.repositories;

import com.booking.project.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByRoomId(Long roomId);

}
