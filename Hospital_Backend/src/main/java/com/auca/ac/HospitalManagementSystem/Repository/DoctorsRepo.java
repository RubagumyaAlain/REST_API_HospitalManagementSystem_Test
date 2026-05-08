package com.auca.ac.HospitalManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.ac.HospitalManagementSystem.Model.Doctors;

public interface  DoctorsRepo extends JpaRepository<Doctors, Long> {
    
}
