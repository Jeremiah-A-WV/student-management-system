package com.codedifferently.studentmanagementserver.domain.studentServer.services;

import com.codedifferently.studentmanagementserver.domain.core.exceptions.ResourceCreationException;
import com.codedifferently.studentmanagementserver.domain.core.exceptions.ResourceNotFoundException;
import com.codedifferently.studentmanagementserver.domain.studentServer.models.StudentServer;
import com.codedifferently.studentmanagementserver.domain.studentServer.repos.StudentServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServerServiceImpl implements StudentServerService {
    private StudentServerRepo studentServerRepository;

    @Autowired
    public StudentServerServiceImpl(StudentServerRepo studentServerRepository) {
        this.studentServerRepository = studentServerRepository;
    }

    @Override
    public StudentServer create(StudentServer studentServer) throws ResourceCreationException {
        Optional<StudentServer> optional = studentServerRepository.findByEmail(studentServer.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Employee with email exists: " + studentServer.getEmail());
        studentServer = studentServerRepository.save(studentServer);
        return studentServer;
    }

    @Override
    public StudentServer getById(Long id) throws ResourceNotFoundException {
        StudentServer studentServer = studentServerRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Employee with id: " + id));
        return studentServer;
    }

    @Override
    public StudentServer getByEmail(String email) throws ResourceNotFoundException {
        StudentServer studentServer = studentServerRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Employee with email: " + email));
        return studentServer;
    }

    @Override
    public List<StudentServer> getAll() {
        return studentServerRepository.findAll();
    }

    @Override
    public StudentServer update(Long id, StudentServer studentServerDetail) throws ResourceNotFoundException {
        StudentServer studentServer = getById(id);
        studentServer.setFirstName(studentServerDetail.getFirstName());
        studentServer.setLastName(studentServerDetail.getLastName());
        studentServer.setEmail(studentServerDetail.getEmail());
        studentServer.setAptNumber(studentServerDetail.getAptNumber());
        studentServer.setDescription(studentServerDetail.getDescription());
        studentServer.setCreatedAt(studentServerDetail.getCreatedAt());
        studentServer = studentServerRepository.save(studentServer);
        return studentServer;
    }

    @Override
    public void delete(Long id) {
        StudentServer studentServer = getById(id);
        studentServerRepository.delete(studentServer);
    }

    @Override
    public StudentServer getByAptNumber(String aptNumber) throws ResourceNotFoundException {
        StudentServer studentServer = studentServerRepository.findByAptNumber(aptNumber)
                .orElseThrow(()->new ResourceNotFoundException("No tenant with email: " + aptNumber));
        return studentServer;
    }
}
