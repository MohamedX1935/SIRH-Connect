package com.sirhconnect.controller;

import com.sirhconnect.model.Employee;
import com.sirhconnect.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> all() {
        return service.findAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
