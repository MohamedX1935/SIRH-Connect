package com.sirhconnect.controller;

import com.sirhconnect.model.Attendance;
import com.sirhconnect.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Attendance> all() {
        return service.findAll();
    }

    @PostMapping
    public Attendance save(@RequestBody Attendance attendance) {
        return service.save(attendance);
    }
}
