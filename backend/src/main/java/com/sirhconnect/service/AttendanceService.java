package com.sirhconnect.service;

import com.sirhconnect.model.Attendance;
import com.sirhconnect.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public List<Attendance> findAll() {
        return repository.findAll();
    }

    public Attendance save(Attendance attendance) {
        return repository.save(attendance);
    }
}
