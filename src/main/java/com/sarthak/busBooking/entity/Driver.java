package com.sarthak.busBooking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Driver {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String driversLicense;
    private String DOB;
    private String Address;
    private String DOJ;
    @OneToOne
    @JoinColumn(name = "busId", referencedColumnName = "id")
    private Bus bus;
}
