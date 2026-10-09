package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.Fee;
import com.Fawadkhan.hms.Repository.FeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeeService {

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    // CREATE FEE
    public Fee createFee(Fee fee) {

        fee.setPaidAmount(0.0);

        fee.setRemainingAmount(fee.getAmount());

        fee.setStatus("UNPAID");

        return feeRepository.save(fee);
    }

    // GET ALL
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }

    // GET BY ID
    public Optional<Fee> getFeeById(Long id) {
        return feeRepository.findById(id);
    }

    // UPDATE
    public Fee updateFee(Long id, Fee fee) {

        Fee existingFee = feeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Fee not found"));

        existingFee.setAmount(fee.getAmount());
        existingFee.setDueDate(fee.getDueDate());
        existingFee.setFeeType(fee.getFeeType());
        existingFee.setStudent(fee.getStudent());

        return feeRepository.save(existingFee);
    }

    // DELETE
    public void deleteFee(Long id) {

        if (!feeRepository.existsById(id)) {
            throw new RuntimeException("Fee not found");
        }

        feeRepository.deleteById(id);
    }
}