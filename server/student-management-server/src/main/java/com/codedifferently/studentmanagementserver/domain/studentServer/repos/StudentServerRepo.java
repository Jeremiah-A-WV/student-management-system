package com.codedifferently.studentmanagementserver.domain.studentServer.repos;

import com.codedifferently.studentmanagementserver.domain.studentServer.models.StudentServer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentServerRepo extends JpaRepository<StudentServer, Long> {
    Optional<StudentServer> findByEmail(String email);
    Optional<StudentServer> findByAptNumber(String aptNumber);
}
