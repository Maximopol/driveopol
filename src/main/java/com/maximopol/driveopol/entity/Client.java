package com.maximopol.driveopol.entity;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    private String name;
    private String email;


}
