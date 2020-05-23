package com.maximopol.driveopol.entity;

import javax.persistence.*;

@Entity
@Table(name = "Workers")
public class Employees {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person")
    private Long person;

    @Column(name = "address")
    private String address;

    @Column(name = "possition")
    private Integer position;

    @Column(name = "number_mobile")
    private String number_mobile;

    @Column(name = "experience")
    private Long experience;

    public Employees() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getNumber_mobile() {
        return number_mobile;
    }

    public void setNumber_mobile(String number_mobile) {
        this.number_mobile = number_mobile;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", person=" + person +
                ", address='" + address + '\'' +
                ", position=" + position +
                ", number_mobile='" + number_mobile + '\'' +
                ", experience=" + experience +
                '}';
    }
}
