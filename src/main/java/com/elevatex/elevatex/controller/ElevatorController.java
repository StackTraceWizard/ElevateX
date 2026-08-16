package com.elevatex.elevatex.controller;

import com.elevatex.elevatex.model.LiftRequest;
import com.elevatex.elevatex.model.Elevator;
import com.elevatex.elevatex.service.ElevatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/elevators")
public class ElevatorController {

    @Autowired
    private ElevatorService elevatorService;

    // GET all elevators status (Resume bullet #2)
    @GetMapping
    public ResponseEntity<List<Elevator>> getAllElevators() {
        return ResponseEntity.ok(elevatorService.getAllElevators());
    }

    // POST new lift request (CORE FEATURE)
    @PostMapping("/request")
    public ResponseEntity<LiftRequest> createLiftRequest(@RequestBody LiftRequest request) {
        LiftRequest assignedRequest = elevatorService.createRequest(
                request.getFromFloor(), request.getToFloor()
        );

        return ResponseEntity.ok(assignedRequest);
    }

    // GET system status dashboard
    @GetMapping("/status")
    public ResponseEntity<String> getSystemStatus() {
        List<Elevator> elevators = elevatorService.getAllElevators();
        String status = "ElevateX Status:\n";
        for (Elevator e : elevators) {
            status += e.getName() + " @ Floor " + e.getCurrentFloor() +
                    " (" + e.getStatus() + ")\n";
        }
        return ResponseEntity.ok(status);
    }
}
