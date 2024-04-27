package com.ceu.HospitalManagement.controllers;

import javax.validation.Valid;

import com.ceu.HospitalManagement.entities.Doctor;
import com.ceu.HospitalManagement.entities.RO.DoctorRO;
import com.ceu.HospitalManagement.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/speciality/{specialty}")
    public ResponseEntity<List<Doctor>> getDoctorsBySpecialty(@PathVariable String specialty) {
        return ResponseEntity.ok(doctorService.getDoctorsBySpecialty(specialty));
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody DoctorRO doctorRO) {
        return ResponseEntity.ok(doctorService.save(doctorRO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody DoctorRO updatedUser) {
        boolean updated = doctorService.update(id, updatedUser);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        boolean deleted = doctorService.delete(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
