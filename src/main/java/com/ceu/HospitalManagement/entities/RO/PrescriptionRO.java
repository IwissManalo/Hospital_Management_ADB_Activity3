package com.ceu.HospitalManagement.entities.RO;

import com.ceu.HospitalManagement.entities.Prescription;
import com.ceu.HospitalManagement.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionRO {

    private String id;

    private String name;

    private String doctor;

    public Prescription toPrescription(Prescription prescription) {
        prescription = new Prescription();
        prescription.setId(id);
        prescription.setName(name);
        prescription.setDoctor(doctor);
        return prescription;
    }
}

