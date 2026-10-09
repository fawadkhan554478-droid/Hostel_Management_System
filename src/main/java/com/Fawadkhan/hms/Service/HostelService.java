package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.Hostel;
import com.Fawadkhan.hms.Repository.HostelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelService {

    private final HostelRepository hostelRepository;

    public HostelService(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }

    // CREATE
    public Hostel createHostel(Hostel hostel) {
        return hostelRepository.save(hostel);
    }

    // GET ALL
    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    // GET BY ID
    public Optional<Hostel> getHostelById(Long id) {
        return hostelRepository.findById(id);
    }

    // UPDATE
    public Hostel updateHostel(Long id, Hostel hostel) {

        Hostel existingHostel = hostelRepository.findById(id).orElseThrow(() -> new RuntimeException("Hostel not found"));

        existingHostel.setHostelName(hostel.getHostelName());
        existingHostel.setAddress(hostel.getAddress());
        existingHostel.setContactNumber(hostel.getContactNumber());
        existingHostel.setTotalRooms(hostel.getTotalRooms());
        existingHostel.setTotalBeds(hostel.getTotalBeds());
        existingHostel.setStatus(hostel.getStatus());

        return hostelRepository.save(existingHostel);
    }

    // DELETE
    public void deleteHostel(Long id) {
        hostelRepository.deleteById(id);
    }
}