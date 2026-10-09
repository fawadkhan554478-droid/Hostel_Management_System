package com.Fawadkhan.hms.Controller;

import com.Fawadkhan.hms.Entity.ServiceRequest;
import com.Fawadkhan.hms.Service.ServiceRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-request")
public class ServiceRequestController {
    private final ServiceRequestService serviceRequestService;

    public ServiceRequestController(ServiceRequestService serviceRequestService){

        this.serviceRequestService = serviceRequestService;
    }
    // CREATE SERVICE REQUEST
    @PostMapping
    public ServiceRequest createRequest(
            @RequestBody ServiceRequest request) {

        return serviceRequestService.createRequest(request);
    }
    // GET ALL
    @GetMapping
    public List<ServiceRequest> getAllRequests() {

        return serviceRequestService.getAllRequests();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getRequestById(@PathVariable Long id) {

        return serviceRequestService.getRequestById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ServiceRequest updateRequest(@PathVariable Long id, @RequestBody ServiceRequest request) {

        return serviceRequestService.updateRequest(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {

        serviceRequestService.deleteRequest(id);

        return "Service request deleted successfully";
    }
}

