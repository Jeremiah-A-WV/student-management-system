package com.codedifferently.studentmanagementserver.domain.studentServer.services;

import com.codedifferently.studentmanagementserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.studentmanagementserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.studentmanagementserver.domain.studentServer.models.StudentServer;

import java.util.List;

public interface StudentServerService {
    StudentServer create(StudentServer employee) throws ResourceCreationException;
    StudentServer getById(Long id) throws ResourceNotFoundException;
    StudentServer getByEmail(String email) throws ResourceNotFoundException;
    StudentServer getByAptNumber(String aptNumber) throws ResourceNotFoundException;
    List<StudentServer> getAll();
    StudentServer update(Long id, StudentServer employeeDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
