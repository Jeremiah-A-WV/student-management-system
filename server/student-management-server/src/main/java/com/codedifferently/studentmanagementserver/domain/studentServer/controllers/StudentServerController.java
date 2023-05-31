package com.codedifferently.studentmanagementserver.domain.studentServer.controllers;

import com.codedifferently.studentmanagementserver.domain.studentServer.models.StudentServer;
import com.codedifferently.studentmanagementserver.domain.studentServer.services.StudentServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenanceRequests")
@CrossOrigin(origins="*")
public class StudentServerController {

    private StudentServerService studentServerService;

    @Autowired
    public StudentServerController(StudentServerService studentServerService) {
        this.studentServerService = studentServerService;
    }

    @GetMapping
    public ResponseEntity<List<StudentServer>> getAll(){
        List<StudentServer> studentServers = studentServerService.getAll();
        return new ResponseEntity<>(studentServers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentServer> create(@RequestBody StudentServer studentService){
        studentService = studentServerService.create(studentService);
        return new ResponseEntity<>(studentService, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentServer> getById(@PathVariable("id") Long id){
        StudentServer studentService = studentServerService.getById(id);
        return new ResponseEntity<>(studentService, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<StudentServer> getByEmail(@RequestParam String email){
        StudentServer studentService = studentServerService.getByEmail(email);
        return new ResponseEntity<>(studentService, HttpStatus.OK);
    }

    @GetMapping("aptNumber")
    public ResponseEntity<StudentServer> getByAptNumber(@RequestParam String aptNumber){
        StudentServer studentService = studentServerService.getByAptNumber(aptNumber);
        return new ResponseEntity<>(studentService, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentServer> update(@PathVariable("id") Long id, @RequestBody StudentServer studentServerDetail){
        studentServerDetail = studentServerService.update(id, studentServerDetail);
        return new ResponseEntity<>(studentServerDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StudentServer> delete(@PathVariable("id") Long id){
        studentServerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
