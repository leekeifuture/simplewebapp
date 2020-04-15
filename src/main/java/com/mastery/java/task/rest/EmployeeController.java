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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "/api/v1/employees", produces = "application/json")
@Api(value = "Employee Management System",
        description = "Operations pertaining to employee in Employee Management System")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success request"),
        @ApiResponse(code = 400, message = "Bad request"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Employee Not found")
})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    @ApiOperation(value = "View a list of available employees",
            response = List.class)
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAll();

        if (employees == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    @ApiOperation(value = "View info about specific employee", response = List.class)
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

    @PostMapping()
    @ApiOperation(value = "Add new employee", response = List.class)
    public ResponseEntity<Employee> addEmployee(
            @RequestBody @Valid Employee employee
    ) {
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        employeeService.create(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping()
    @ApiOperation(value = "Edit existing employee", response = List.class)
    public ResponseEntity<Employee> editEmployee(
            @RequestBody @Valid Employee employee
    ) {
        if (employee == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        employeeService.update(employee);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    @ApiOperation(value = "Delete existing employee", response = List.class)
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
