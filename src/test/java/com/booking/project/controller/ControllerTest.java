package com.booking.project.controller;

import com.booking.project.dto.FindAvailablePlaces;
import com.booking.project.entities.Booking;
import com.booking.project.entities.Room;
import com.booking.project.factory.Factory;
import com.booking.project.repositories.BookingRepository;
import com.booking.project.repositories.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveRegistrarUmRoom() throws Exception{

        // Arrange
        Room request = Factory.createRoom();
        String jsonBody = objectMapper.writeValueAsString(request);

        ResultActions response = mockMvc
                .perform(post("/booking/registerRoom").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isCreated());

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveRegistrarUmaReserva() throws Exception{

        // Arrange
        Booking request = Factory.createABooking();
        String jsonBody = objectMapper.writeValueAsString(request);

        ResultActions response = mockMvc
                .perform(post("/booking/create").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isCreated());

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveBuscarUmaReservaPorId() throws Exception{

        // Arrange
        bookingRepository.save(Factory.createABooking());

        // Act
        ResultActions result = mockMvc.perform(get("/booking/{id}", 1L).accept(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isOk());

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveBuscarAsSalasReservadas() throws Exception{

        // Arrange
        FindAvailablePlaces request = Factory.createFindPlacesAvailables();
        String jsonBody = objectMapper.writeValueAsString(request);

        // Act
        ResultActions response = mockMvc
                .perform(post("/booking/roomsAvailables").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isOk());

    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveAtualizarReservaPorId() throws Exception {
        // Arrange
        bookingRepository.save(Factory.createABooking());
        Booking request = Factory.createABooking();
        String jsonBody = objectMapper.writeValueAsString(request);
        // Act
        ResultActions result = mockMvc.perform(put("/booking/update/{id}", 1L).content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
        // Assert
        result.andExpect(status().isOk());


    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveDeletarReservaPorId() throws Exception {

        //Arrange
        bookingRepository.save(Factory.createABooking());

        // Act
        ResultActions result = mockMvc.perform(delete("/booking/delete/{id}", 1L).accept(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isNoContent());

    }




}
