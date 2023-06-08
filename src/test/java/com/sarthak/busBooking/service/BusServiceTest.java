package com.sarthak.busBooking.service;

import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.repository.BusRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {BusServiceTest.class})
class BusServiceTest {

    @Mock
    BusRepository busRepository;

    @InjectMocks
    BusService busService;

    @Test
    void findBus() {
        Bus bus=new Bus();
        bus.setName("ABC");
        bus.setOwner("XYZ Travels");
        bus.setNoOfSeats(50);
        bus.setLicensePlate("GJ04GDJ8829");
        bus.setId(1);

        int id=1;

        when(busRepository.getReferenceById(id)).thenReturn(bus);
        assertEquals(bus,busService.findBus(id));
    }

    @Test
    void createBus() {
    }
}