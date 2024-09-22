package com.booking.project.repositories;

import com.booking.project.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r " +
            "LEFT JOIN r.booking b " +
            "WHERE (b IS NULL OR " +
            "       NOT (b.inicialDateTime < :finalDateTime AND b.finalDateTime > :inicialDateTime)) " +
            "AND (b IS NULL OR b.date = :date)")
    List<Room> findAvailableRooms(@Param("date") LocalDate date,
                                  @Param("inicialDateTime") LocalDateTime inicialDateTime,
                                  @Param("finalDateTime") LocalDateTime finalDateTime);

}
