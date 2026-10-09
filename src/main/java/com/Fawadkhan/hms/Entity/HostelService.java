package com.Fawadkhan.hms.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Service")
public class HostelService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String serviceName;

    private String description;

    private Double price;

    private String status;

    public HostelService(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HostelService(String serviceName, String description, Double price, String status){
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
        this.status = status;

    }
}
