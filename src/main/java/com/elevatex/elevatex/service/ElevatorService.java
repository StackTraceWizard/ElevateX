package com.elevatex.elevatex.service;

import com.elevatex.elevatex.model.Elevator;
import com.elevatex.elevatex.model.ElevatorStatus;
import com.elevatex.elevatex.model.LiftRequest;
import com.elevatex.elevatex.model.RequestStatus;
import com.elevatex.elevatex.repository.ElevatorRepository;
import com.elevatex.elevatex.repository.LiftRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElevatorService {

    @Autowired
    private ElevatorRepository elevatorRepository;

    @Autowired
    private LiftRequestRepository liftRequestRepository;

    public List<Elevator> getAllElevators() {
        return elevatorRepository.findAll();
    }

    public Elevator getFirstIdleElevator() {
        List<Elevator> allElevators = elevatorRepository.findAll();
        for (Elevator elevator : allElevators) {
            if (elevator.getStatus() == ElevatorStatus.IDLE) {
                return elevator;
            }
        }
        return null;
    }

    public LiftRequest createRequest(int fromFloor, int toFloor) {
        LiftRequest request = new LiftRequest();
        request.setFromFloor(fromFloor);
        request.setToFloor(toFloor);
        request.setStatus(RequestStatus.PENDING);

        Elevator elevator = getFirstIdleElevator();
        if (elevator != null) {
            request.setAssignedElevator(elevator);
            elevator.setStatus(ElevatorStatus.MOVING);
            elevatorRepository.save(elevator);
        }

        return liftRequestRepository.save(request);
    }
}
