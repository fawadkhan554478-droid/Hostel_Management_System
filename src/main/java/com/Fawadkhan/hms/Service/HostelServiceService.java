package com.Fawadkhan.hms.Service;

import com.Fawadkhan.hms.Entity.HostelService;
import com.Fawadkhan.hms.Repository.HostelServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelServiceService {

    private final HostelServiceRepository hostelServiceRepository;

    public HostelServiceService(
            HostelServiceRepository hostelServiceRepository) {

        this.hostelServiceRepository = hostelServiceRepository;
    }

    // CREATE
    public HostelService createService(HostelService service) {
        return hostelServiceRepository.save(service);
    }

    // GET ALL
    public List<HostelService> getAllServices() {
        return hostelServiceRepository.findAll();
    }

    // GET BY ID
    public Optional<HostelService> getServiceById(Long id) {
        return hostelServiceRepository.findById(id);
    }

    // UPDATE
    public HostelService updateService(Long id, HostelService service) {

        HostelService existingService = hostelServiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setServiceName(service.getServiceName());

        existingService.setDescription(service.getDescription());

        existingService.setPrice(service.getPrice());

        existingService.setStatus(service.getStatus());

        return hostelServiceRepository.save(existingService);
    }

    // DELETE
    public void deleteService(Long id) {
        hostelServiceRepository.deleteById(id);
    }
}
