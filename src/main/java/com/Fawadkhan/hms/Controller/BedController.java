package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.Bed;
import com.Fawadkhan.hms.Service.BedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beds")
public class BedController {

    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    // CREATE
    @PostMapping
    public Bed createBed(@RequestBody Bed bed) {
        return bedService.createBed(bed);
    }

    // GET ALL
    @GetMapping
    public List<Bed> getAllBeds() {
        return bedService.getAllBeds();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Bed> getBedById(@PathVariable Long id) {

        return bedService.getBedById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public Bed updateBed(@PathVariable Long id, @RequestBody Bed bed) {

        return bedService.updateBed(id, bed);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBed(@PathVariable Long id) {

        bedService.deleteBed(id);

        return "Bed deleted successfully";
    }
}
