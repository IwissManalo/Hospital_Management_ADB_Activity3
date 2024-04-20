package com.ceu.HospitalManagement.entities.RO;

import com.ceu.HospitalManagement.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRO {

    private String id;

    private String name;

    private String email;

    private String contactNumber;

    private User emergencyContact;

    public User toEntity(User user) {

        if (Objects.isNull(user)) {
            user = new User();
        }

        user.setName(name);
        user.setEmail(email);
        user.setContactNumber(contactNumber);
        user.setEmergencyContact(emergencyContact);

        return user;
    }
}
