package com.ceu.HospitalManagement.services;

import com.ceu.HospitalManagement.entities.Prescription;
import com.ceu.HospitalManagement.entities.RO.PrescriptionRO;
import com.ceu.HospitalManagement.repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription getOneById(String id) {
        return prescriptionRepository.findById(id).get();
    }

    public boolean save(PrescriptionRO prescriptionRO) {
        Prescription prescription = Objects.isNull(prescriptionRO.getId()) ? null : getOneById(prescriptionRO.getId());
        prescriptionRepository.save(prescriptionRO.toPrescription(prescription));
        return true;
    }
}
