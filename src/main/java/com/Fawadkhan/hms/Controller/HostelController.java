package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.Hostel;
import com.Fawadkhan.hms.Service.HostelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hostels")
public class HostelController {

    private final HostelService hostelService;

    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    // CREATE
    @PostMapping
    public Hostel createHostel(@RequestBody Hostel hostel) {
        return hostelService.createHostel(hostel);
    }

    // GET ALL
    @GetMapping
    public List<Hostel> getAllHostels() {
        return hostelService.getAllHostels();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Hostel> getHostelById(@PathVariable Long id) {

        return hostelService.getHostelById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public Hostel updateHostel(@PathVariable Long id, @RequestBody Hostel hostel) {

        return hostelService.updateHostel(id, hostel);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteHostel(@PathVariable Long id) {

        hostelService.deleteHostel(id);

        return "Hostel deleted successfully";
    }
}