package com.ceu.HospitalManagement.entities.RO;

import com.ceu.HospitalManagement.entities.Prescription;
import com.ceu.HospitalManagement.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionRO {

    private String id;

    private String name;

    private Doctor doctor;

    public Prescription toPrescription() {
        Prescription prescription = new Prescription();
        prescription.setId(id);
        prescription.setName(name);
        prescription.setDoctor(doctor);
        return prescription;
    }
}

