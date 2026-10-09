package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.ServiceRequest;
import com.Fawadkhan.hms.Repository.ServiceRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceRequestService {
    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService(ServiceRequestRepository serviceRequestRepository){
        this.serviceRequestRepository = serviceRequestRepository;
    }
    


    // CREATE
    public ServiceRequest createRequest(ServiceRequest request) {

        return serviceRequestRepository.save(request);
    }

    // GET ALL
    public List<ServiceRequest> getAllRequests() {

        return serviceRequestRepository.findAll();
    }

    // GET BY ID
    public Optional<ServiceRequest> getRequestById(Long id) {

        return serviceRequestRepository.findById(id);
    }

    // UPDATE
    public ServiceRequest updateRequest(Long id, ServiceRequest request) {

        ServiceRequest existingRequest = serviceRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Service request not found"));

        existingRequest.setRequestDate(request.getRequestDate());

        existingRequest.setStatus(request.getStatus());

        existingRequest.setRemarks(request.getRemarks());

        existingRequest.setStudent(request.getStudent());

        existingRequest.setService(request.getService());

        return serviceRequestRepository.save(existingRequest);
    }


    // DELETE
    public void deleteRequest(Long id) {

        serviceRequestRepository.deleteById(id);
    }
}

