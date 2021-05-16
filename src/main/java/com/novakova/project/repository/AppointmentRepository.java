package com.novakova.project.repository;

import com.novakova.project.model.Appointment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findAll();
    Appointment findAppointmentById(Long id);
}
