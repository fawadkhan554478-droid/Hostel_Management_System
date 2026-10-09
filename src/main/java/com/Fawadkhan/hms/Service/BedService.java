package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.Bed;
import com.Fawadkhan.hms.Repository.BedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedService {

    private final BedRepository bedRepository;

    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    // CREATE
    public Bed createBed(Bed bed) {
        return bedRepository.save(bed);
    }

    // GET ALL
    public List<Bed> getAllBeds() {
        return bedRepository.findAll();
    }

    // GET BY ID
    public Optional<Bed> getBedById(Long id) {
        return bedRepository.findById(id);
    }

    // UPDATE
    public Bed updateBed(Long id, Bed bed) {

        Bed existingBed = bedRepository.findById(id).orElseThrow(() -> new RuntimeException("Bed not found"));

        existingBed.setBedNumber(bed.getBedNumber());
        existingBed.setStatus(bed.getStatus());
        existingBed.setRoom(bed.getRoom());

        return bedRepository.save(existingBed);
    }

    // DELETE
    public void deleteBed(Long id) {
        bedRepository.deleteById(id);
    }
}
