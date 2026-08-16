package com.elevatex.elevatex.repository;

import com.elevatex.elevatex.model.LiftRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LiftRequestRepository extends JpaRepository<LiftRequest, Long> {
    List<LiftRequest> findByStatus(com.elevatex.elevatex.model.RequestStatus status);
}
