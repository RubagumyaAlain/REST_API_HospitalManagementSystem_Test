package com.auca.ac.HospitalManagementSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auca.ac.HospitalManagementSystem.Model.Appointment;
import com.auca.ac.HospitalManagementSystem.Repository.AppointmentsRepo;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class AppointmentsController {
    
    private final AppointmentsRepo appointmentsRepo;

    public AppointmentsController (AppointmentsRepo appointmentsRepo){
        this.appointmentsRepo = appointmentsRepo;
    }

    @GetMapping("/appointments")
    public List<Appointment> getallAppointments(){
        return appointmentsRepo.findAll();
    }
    @PostMapping("/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment){
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentsRepo.save(appointment));
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<?> DeleteAppointment(@PathVariable int id){
        return appointmentsRepo.findById(id).map(appointment -> {
            appointmentsRepo.delete(appointment);
            return ResponseEntity.ok("appointment deleted Successfully!");
        }).orElse(ResponseEntity.notFound().build());
    }
}
