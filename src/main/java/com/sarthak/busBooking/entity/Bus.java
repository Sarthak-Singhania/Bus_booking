package com.sarthak.busBooking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Bus {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String owner;
    private int noOfSeats;
    private String licensePlate;
}
