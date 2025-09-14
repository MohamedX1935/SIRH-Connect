package com.sirhconnect.controller;

import com.sirhconnect.model.Payroll;
import com.sirhconnect.service.PayrollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {
    private final PayrollService service;

    public PayrollController(PayrollService service) {
        this.service = service;
    }

    @GetMapping
    public List<Payroll> all() {
        return service.findAll();
    }

    @PostMapping
    public Payroll calculate(@RequestBody Payroll payroll) {
        return service.calculate(payroll);
    }
}
