package com.booking.project.services;

import com.booking.project.entities.Room;
import com.booking.project.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterRoomService {

    @Autowired
    private RoomRepository repository;

    public Room registerRoom(Room room) {

        try {

            return repository.save(room);

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
        }


    }
