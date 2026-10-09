package com.Fawadkhan.hms.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roomNumber;

    private String roomType;

    private Integer capacity;

    private Integer occupiedBeds;

    private String status;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;

    public Room(){
    }
    public Room(String roomNumber,String roomType,Integer capacity,Integer occupiedBeds,String status,Hostel hostel){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.capacity = capacity;
        this.occupiedBeds = occupiedBeds;
        this.status = status;
        this.hostel = hostel;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    public String getRoomType(){
        return roomType;
    }

    public void setRoomType( String roomType){
        this.roomType = roomType;
    }

    public Integer getCapacity(){
        return capacity;
    }

    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }

    public Integer getOccupiedBeds(){
        return occupiedBeds;
    }

    public void setOccupiedBeds(Integer occupiedBeds){
        this.occupiedBeds = occupiedBeds;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }
}


