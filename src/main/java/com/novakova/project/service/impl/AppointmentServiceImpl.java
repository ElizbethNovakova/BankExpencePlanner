package com.novakova.project.service.impl;

import com.novakova.project.model.Appointment;
import com.novakova.project.repository.AppointmentRepository;
import com.novakova.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointment(Long id) {
        return appointmentRepository.findAppointmentById(id);
    }

    @Override
    public void confirmAppointment(Long id) {
        Appointment appointment = findAppointment(id);
        appointment.setConfirmed(true);
        appointmentRepository.save(appointment);
    }
}
