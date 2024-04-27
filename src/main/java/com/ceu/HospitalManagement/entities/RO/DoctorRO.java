package com.ceu.HospitalManagement.entities.RO;

import com.ceu.HospitalManagement.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRO {

    private String id;

    private String name;

    private int yearOfService;

    private String specialty;

    public Doctor toEntity(Doctor doctor) {

        if (Objects.isNull(doctor)) {
            doctor = new Doctor();
        }

        doctor.setName(name);
        doctor.setYearOfService(yearOfService);
        doctor.setSpecialty(specialty);
        return doctor;
    }
}
