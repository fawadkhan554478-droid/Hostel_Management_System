package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.RoomAllocation;
import com.Fawadkhan.hms.Service.RoomAllocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class RoomAllocationController {

    private final RoomAllocationService allocationService;

    public RoomAllocationController(
            RoomAllocationService allocationService) {

        this.allocationService = allocationService;
    }

    // CREATE
    @PostMapping
    public RoomAllocation createAllocation(@RequestBody RoomAllocation allocation) {

        return allocationService.createAllocation(allocation);
    }

    // GET ALL
    @GetMapping
    public List<RoomAllocation> getAllAllocations() {

        return allocationService.getAllAllocations();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<RoomAllocation> getAllocationById(@PathVariable Long id) {

        return allocationService.getAllocationById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public RoomAllocation updateAllocation(@PathVariable Long id, @RequestBody RoomAllocation allocation) {

        return allocationService.updateAllocation(id, allocation);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteAllocation(@PathVariable Long id) {

        allocationService.deleteAllocation(id);

        return "Room allocation deleted successfully";
    }
}
