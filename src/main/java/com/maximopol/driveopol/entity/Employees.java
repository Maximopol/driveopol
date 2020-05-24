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
    private Long position;

    @Column(name = "number_mobile")
    private String number_mobile;

    @Column(name = "experience")
    private Long experience;

    @Transient
    private Position position2;

    @Transient
    private Client me;

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

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
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

    public Position getPosition2() {
        return position2;
    }

    public void setPosition2(Position position2) {
        if (position2.getId().equals(position)) {
            this.position2 = position2;
        }
    }

    public Client getMe() {
        return me;
    }

    public void setMe(Client me) {
        if (me.getId().equals(person)) {
            this.me = me;
        }
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
                ", position2=" + position2 +
                ", me=" + me +
                '}';
    }
}
