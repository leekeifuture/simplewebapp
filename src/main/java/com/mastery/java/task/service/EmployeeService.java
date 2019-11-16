package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee getById(Long employeeId) {
        if (employeeId == null)
            throw new NotFoundException();
        else
            return employeeDao.getById(employeeId);
    }

    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    public void create(Employee employee) {
        employeeDao.create(employee);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    public void deleteById(Long id) {
        employeeDao.deleteById(id);
    }
}
