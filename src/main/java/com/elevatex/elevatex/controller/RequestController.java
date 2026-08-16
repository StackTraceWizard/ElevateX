package com.elevatex.elevatex.controller;

import com.elevatex.elevatex.model.LiftRequest;
import com.elevatex.elevatex.model.RequestStatus;
import com.elevatex.elevatex.service.ElevatorService;
import com.elevatex.elevatex.repository.LiftRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private ElevatorService elevatorService;

    @Autowired
    private LiftRequestRepository requestRepository;

    // POST: Create new lift request (MAIN API)
    @PostMapping
    public ResponseEntity<LiftRequest> createRequest(@RequestBody LiftRequest request) {
        LiftRequest assignedRequest = elevatorService.createRequest(
                request.getFromFloor(),
                request.getToFloor()
        );

        return ResponseEntity.ok(assignedRequest);
    }

    // GET: All requests history
    @GetMapping
    public ResponseEntity<List<LiftRequest>> getAllRequests() {
        return ResponseEntity.ok(requestRepository.findAll());
    }

    // GET: Pending requests only
    @GetMapping("/pending")
    public ResponseEntity<List<LiftRequest>> getPendingRequests() {
        List<LiftRequest> pending = requestRepository.findAll();
        pending.removeIf(r -> r.getStatus() != RequestStatus.PENDING);
        return ResponseEntity.ok(pending);
    }

    // GET: Single request by ID
    @GetMapping("/{id}")
    public ResponseEntity<LiftRequest> getRequest(@PathVariable Long id) {
        return requestRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
