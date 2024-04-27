package com.ceu.HospitalManagement.controllers;

import com.ceu.HospitalManagement.entities.Prescription;
import com.ceu.HospitalManagement.entities.RO.PrescriptionRO;
import com.ceu.HospitalManagement.services.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/latest")
    public ResponseEntity<List<Prescription>> getLatest() {
        return ResponseEntity.ok(prescriptionService.getLatestSix());
    }
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(prescriptionService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity save(@javax.validation.Valid @RequestBody PrescriptionRO prescriptionRO) {
        return ResponseEntity.ok(prescriptionService.save(prescriptionRO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid @RequestBody PrescriptionRO updatedPrescription) {
        boolean updated = prescriptionService.update(id, updatedPrescription);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
