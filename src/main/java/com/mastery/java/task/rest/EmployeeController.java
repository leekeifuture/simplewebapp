package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAll();

        if (employees == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable("employeeId") Long employeeId
    ) {
        if (employeeId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Employee employee = employeeService.getById(employeeId);

        if (employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(
            @RequestBody @Valid Employee employee
    ) {
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        employeeService.create(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Employee> editEmployee(
            @RequestBody @Valid Employee employee
    ) {
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        employeeService.update(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(
            @PathVariable("employeeId") Long employeeId
    ) {
        if (employeeId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Employee employee = employeeService.getById(employeeId);

        if (employee == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        employeeService.deleteById(employeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
