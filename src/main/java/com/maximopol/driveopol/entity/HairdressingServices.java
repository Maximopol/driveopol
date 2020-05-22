package com.maximopol.driveopol.entity;

import javax.persistence.*;

@Entity
@Table(name = "Services")
public class HairdressingServices {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private float price;

    @Column(name = "For_Master")
    private String forMaster;

    public HairdressingServices() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getForMaster() {
        return forMaster;
    }

    public void setForMaster(String forMaster) {
        this.forMaster = forMaster;
    }

    @Override
    public String toString() {
        return "HairdressingServices{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", forMaster='" + forMaster + '\'' +
                '}';
    }
}
