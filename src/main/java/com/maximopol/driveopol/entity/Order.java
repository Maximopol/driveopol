package com.maximopol.driveopol.entity;

import javax.persistence.*;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
