package com.elevatex.elevatex.repository;

import com.elevatex.elevatex.model.Elevator;
import com.elevatex.elevatex.model.ElevatorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElevatorRepository extends JpaRepository<Elevator, Long> {

    List<Elevator> findByStatus(ElevatorStatus status);

    Optional<Elevator> findByName(String name);

    List<Elevator> findByCurrentFloor(int floor);
}
