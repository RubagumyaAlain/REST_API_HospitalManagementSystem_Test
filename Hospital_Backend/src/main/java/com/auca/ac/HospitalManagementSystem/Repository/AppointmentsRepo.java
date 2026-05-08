package com.auca.ac.HospitalManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.ac.HospitalManagementSystem.Model.Appointment;

public interface AppointmentsRepo extends JpaRepository<Appointment, Integer>{
    
}
