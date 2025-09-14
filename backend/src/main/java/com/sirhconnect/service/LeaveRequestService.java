package com.sirhconnect.service;

import com.sirhconnect.model.LeaveRequest;
import com.sirhconnect.model.LeaveStatus;
import com.sirhconnect.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepository repository;

    public LeaveRequestService(LeaveRequestRepository repository) {
        this.repository = repository;
    }

    public List<LeaveRequest> findAll() {
        return repository.findAll();
    }

    public LeaveRequest submit(LeaveRequest leave) {
        leave.setStatus(LeaveStatus.PENDING);
        return repository.save(leave);
    }

    public LeaveRequest approve(Long id) {
        LeaveRequest leave = repository.findById(id).orElseThrow();
        leave.setStatus(LeaveStatus.APPROVED);
        return repository.save(leave);
    }
}
