package com.Fawadkhan.hms.Repository;

import com.Fawadkhan.hms.Entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository
        extends JpaRepository<ServiceRequest, Long> {
}
