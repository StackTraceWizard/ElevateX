package com.elevatex.elevatex.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lift_requests")
public class LiftRequest {
    @Id @GeneratedValue private Long id;
    private int fromFloor;
    private int toFloor;
    @Enumerated(EnumType.STRING) private RequestStatus status;
    @ManyToOne private Elevator assignedElevator;

    public LiftRequest() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getFromFloor() { return fromFloor; }
    public void setFromFloor(int fromFloor) { this.fromFloor = fromFloor; }
    public int getToFloor() { return toFloor; }
    public void setToFloor(int toFloor) { this.toFloor = toFloor; }
    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public Elevator getAssignedElevator() { return assignedElevator; }
    public void setAssignedElevator(Elevator assignedElevator) { this.assignedElevator = assignedElevator; }
}
