package com.maximopol.driveopol.entity;

import javax.persistence.*;

@Entity
@Table(name = "Order_status")
public class OrderStatus {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Description")
    private String description;

    public OrderStatus() {
    }

    public OrderStatus(Integer id) {
        this.id = id;
    }

    public OrderStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
