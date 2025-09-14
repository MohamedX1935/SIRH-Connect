package com.sirhconnect.controller;

import com.sirhconnect.model.LeaveStatus;
import com.sirhconnect.model.Employee;
import com.sirhconnect.repository.EmployeeRepository;
import com.sirhconnect.repository.LeaveRequestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final EmployeeRepository employeeRepository;
    private final LeaveRequestRepository leaveRepository;

    public DashboardController(EmployeeRepository employeeRepository, LeaveRequestRepository leaveRepository) {
        this.employeeRepository = employeeRepository;
        this.leaveRepository = leaveRepository;
    }

    @GetMapping
    public Map<String, Object> stats() {
        Map<String, Object> map = new HashMap<>();
        map.put("employees", employeeRepository.count());
        map.put("activeEmployees", employeeRepository.findAll().stream().filter(Employee::isActive).count());
        map.put("pendingLeaves", leaveRepository.findAll().stream().filter(l -> l.getStatus() == LeaveStatus.PENDING).count());
        return map;
    }
}
