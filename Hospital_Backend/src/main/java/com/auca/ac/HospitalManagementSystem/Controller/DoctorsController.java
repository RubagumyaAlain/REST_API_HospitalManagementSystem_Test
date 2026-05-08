package com.auca.ac.HospitalManagementSystem.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.auca.ac.HospitalManagementSystem.Model.Doctors;
import com.auca.ac.HospitalManagementSystem.Repository.DoctorsRepo;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class DoctorsController {
  
    private final DoctorsRepo doctorRepo;
 
    public DoctorsController( DoctorsRepo doctorRepo){
        this.doctorRepo = doctorRepo;
    }

    @GetMapping("/doctors")
    public List<Doctors> getallDoctors(){
        return doctorRepo.findAll();
    }

    @PostMapping("/doctors")
    public ResponseEntity<Doctors> RegisterDoctors(@RequestBody Doctors doctor){
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorRepo.save(doctor));
    }
    
    @GetMapping("/doctors/{id}")
    public Doctors getDoctorById(@PathVariable Long id){
        return doctorRepo.findById(id)
        .orElseThrow(()-> new ResponseStatusException
        (HttpStatus.NOT_FOUND, 
        "DOCTOR NOT FOUND"));
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<?> UpdateDoctor(@PathVariable Long id, @RequestBody Doctors doctorDetails){
        return doctorRepo.findById(id).map(doctor -> 
        {
        doctor.setId(doctorDetails.getId());
        doctor.setFullName(doctorDetails.getFullName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setDepartment(doctorDetails.getDepartment());
        doctor.setAvailable(doctorDetails.getAvailable());
        
        doctorRepo.save(doctor);

        return ResponseEntity.status(200).body("Updated Successfully!");
        }).orElse(ResponseEntity.notFound().build());

    }

}
