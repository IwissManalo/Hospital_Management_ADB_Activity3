package com.ceu.HospitalManagement.repositories;

import com.ceu.HospitalManagement.entities.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
