package com.codedifferently.studentmanagementserver.domain.studentServer.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // parameterized constructor
@Data // getters and setters
public class StudentServer {

    // its position in the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // first name of tenant making the request
    @NonNull
    private String firstName;

    // last name of tenant making the request
    @NonNull
    private String lastName;

    // email request of tenant making the request
    @NonNull
    private String email;

    // apartment number of the tenant making the request
    @NonNull
    private String aptNumber;

    // description of the request for maintenance
    @NonNull
    private String description;

    @NonNull
    // time stamp of when the request was made
    private String createdAt;

    public String toString(){
        return String.format("%d %s %s %s", id, firstName,lastName,email);
    }
}
