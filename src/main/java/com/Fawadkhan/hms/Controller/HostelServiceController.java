package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.HostelService;
import com.Fawadkhan.hms.Service.HostelServiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class HostelServiceController {
    private final HostelServiceService hostelServiceService;

    public HostelServiceController( HostelServiceService hostelServiceService){
        this.hostelServiceService = hostelServiceService;

    }
    // CREATE
    @PostMapping
    public HostelService createService(@RequestBody HostelService service) {

        return hostelServiceService.createService(service);
    }

    // GET ALL
    @GetMapping
    public List<HostelService> getAllServices() {

        return hostelServiceService.getAllServices();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<HostelService> getServiceById(@PathVariable Long id) {

        return hostelServiceService.getServiceById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public HostelService updateService(@PathVariable Long id, @RequestBody HostelService service) {

        return hostelServiceService.updateService(id, service);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id) {

        hostelServiceService.deleteService(id);

        return "Service deleted successfully";
    }
}

