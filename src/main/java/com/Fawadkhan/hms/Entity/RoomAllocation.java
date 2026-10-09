package com.Fawadkhan.hms.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "room_allocation")
public class RoomAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate allocationDate;

    private LocalDate endDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    public RoomAllocation(){
    }

    public RoomAllocation(LocalDate allocationDate,LocalDate endDate,String status,Student student,Bed bed){
        this.allocationDate = allocationDate;
        this.endDate = endDate;
        this.status = status;
        this.student = student;
        this.bed = bed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(LocalDate allocationDate) {
        this.allocationDate = allocationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
