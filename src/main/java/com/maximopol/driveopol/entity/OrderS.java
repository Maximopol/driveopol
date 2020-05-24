package com.maximopol.driveopol.entity;

import javax.persistence.*;

@Entity
@Table(name = "OrderS")
public class OrderS {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service")
    private Long service;

    @Column(name = "client")
    private Long client;

    @Column(name = "status")
    private Long status;

    @Column(name = "date_completion")
    private String data_completion;

    @Column(name = "data_created")
    private String data_created;

    @Column(name = "master")
    private Long master;

    public OrderS() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getService() {
        return service;
    }

    public void setService(Long service) {
        this.service = service;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getDataCompletion() {
        return data_completion;
    }

    public void setDataCompletion(String data_completion) {
        this.data_completion = data_completion;
    }

    public String getDataCreated() {
        return data_created;
    }

    public void setDataCreated(String data_created) {
        this.data_created = data_created;
    }

    public Long getMaster() {
        return master;
    }

    public void setMaster(Long master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", service=" + service +
                ", client=" + client +
                ", status=" + status +
                ", data_completion='" + data_completion + '\'' +
                ", data_created='" + data_created + '\'' +
                ", master=" + master +
                '}';
    }
}
