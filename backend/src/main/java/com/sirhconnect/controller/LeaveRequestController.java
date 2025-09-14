package com.sirhconnect.controller;

import com.sirhconnect.model.LeaveRequest;
import com.sirhconnect.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {
    private final LeaveRequestService service;

    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<LeaveRequest> all() {
        return service.findAll();
    }

    @PostMapping
    public LeaveRequest submit(@RequestBody LeaveRequest leave) {
        return service.submit(leave);
    }

    @PostMapping("/{id}/approve")
    public LeaveRequest approve(@PathVariable Long id) {
        return service.approve(id);
    }
}
