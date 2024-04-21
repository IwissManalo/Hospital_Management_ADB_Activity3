package com.ceu.HospitalManagement.services;

import com.ceu.HospitalManagement.entities.RO.DoctorRO;
import com.ceu.HospitalManagement.entities.Doctor;
import com.ceu.HospitalManagement.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getOneById(String id) {
        return doctorRepository.findById(id).get();
    }

    public boolean save(DoctorRO doctorRO) {
            Doctor doctor = Objects.isNull(doctorRO.getId()) ? null : getOneById(doctorRO.getId());
            doctorRepository.save(doctorRO.toEntity(doctor));
            return true;
    }

    public boolean update(String id, DoctorRO updatedUser) {
        Doctor existingUser = getOneById(id);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setYearOfService(updatedUser.getYearOfService());
            existingUser.setSpecialty(updatedUser.getSpecialty());
            doctorRepository.save(existingUser);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
