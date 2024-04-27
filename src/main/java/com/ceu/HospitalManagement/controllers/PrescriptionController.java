package com.ceu.HospitalManagement.controllers;

import com.ceu.HospitalManagement.entities.Prescription;
import com.ceu.HospitalManagement.entities.RO.PrescriptionRO;
import com.ceu.HospitalManagement.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity save(@RequestBody PrescriptionRO prescriptionRO) {
        return ResponseEntity.ok(prescriptionService.save(prescriptionRO));
    }
}
