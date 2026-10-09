package com.Fawadkhan.hms.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate requestDate;

    private String status;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private HostelService service;

    public ServiceRequest() {
    }

    public ServiceRequest(LocalDate requestDate, String status, String remarks, Student student, HostelService service) {

        this.requestDate = requestDate;
        this.status = status;
        this.remarks = remarks;
        this.student = student;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HostelService getService() {
        return service;
    }

    public void setService(HostelService service) {
        this.service = service;
    }
}