package com.ceu.HospitalManagement.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "prescriptions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    @Id
    private String id;

    @NotBlank(message = "Prescription name cannot be blank")
    private String name;

    @NotBlank(message = "Doctor name cannot be blank")
    private String doctor;

    @NotBlank(message = "Created by cannot be blank")
    private String createdBy;

}
