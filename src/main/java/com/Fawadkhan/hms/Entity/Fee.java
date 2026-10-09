package com.Fawadkhan.hms.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "fees")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private Double paidAmount;

    private Double remainingAmount;

    private LocalDate dueDate;

    private String feeType;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Fee() {
    }

    public Fee(Double amount,
               Double paidAmount,
               Double remainingAmount,
               LocalDate dueDate,
               String feeType,
               String status,
               Student student) {

        this.amount = amount;
        this.paidAmount = paidAmount;
        this.remainingAmount = remainingAmount;
        this.dueDate = dueDate;
        this.feeType = feeType;
        this.status = status;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
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
}