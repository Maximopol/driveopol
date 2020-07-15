package com.maximopol.driveopol.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
