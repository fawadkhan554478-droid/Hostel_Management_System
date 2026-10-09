package com.Fawadkhan.hms.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hostels")
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hostelName;

    private String address;

    private String contactNumber;

    private Integer totalRooms;

    private Integer totalBeds;

    private String status;

    public Hostel() {
    }

    public Hostel(String hostelName, String address, String contactNumber, Integer totalRooms, Integer totalBeds, String status) {

        this.hostelName = hostelName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.totalRooms = totalRooms;
        this.totalBeds = totalBeds;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Integer getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(Integer totalBeds) {
        this.totalBeds = totalBeds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
