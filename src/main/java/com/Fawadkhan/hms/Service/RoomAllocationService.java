package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.RoomAllocation;
import com.Fawadkhan.hms.Repository.RoomAllocationRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RoomAllocationService {

    private final RoomAllocationRepository allocationRepository;

    public RoomAllocationService(RoomAllocationRepository allocationRepository){
        this.allocationRepository =allocationRepository;

    }
    // CREATE
    public RoomAllocation createAllocation(
            RoomAllocation allocation) {

        return allocationRepository.save(allocation);
    }

    // GET ALL
    public List<RoomAllocation> getAllAllocations() {

        return allocationRepository.findAll();
    }

    // GET BY ID
    public Optional<RoomAllocation> getAllocationById(Long id) {

        return allocationRepository.findById(id);
    }

    // UPDATE
    public RoomAllocation updateAllocation(Long id, RoomAllocation allocation) {

        RoomAllocation existingAllocation = allocationRepository.findById(id).orElseThrow(() -> new RuntimeException("Allocation not found"));

        existingAllocation.setAllocationDate(allocation.getAllocationDate());

        existingAllocation.setEndDate(allocation.getEndDate());

        existingAllocation.setStatus(allocation.getStatus());

        existingAllocation.setStudent(allocation.getStudent());

        existingAllocation.setBed(allocation.getBed());

        return allocationRepository.save(existingAllocation);
    }

    // DELETE
    public void deleteAllocation(Long id) {

        allocationRepository.deleteById(id);
    }
}


