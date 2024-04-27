package com.ceu.HospitalManagement.repositories;

import com.ceu.HospitalManagement.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findBySpecialty(String specialty);
}
