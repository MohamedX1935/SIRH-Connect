package com.sirhconnect.service;

import com.sirhconnect.model.Payroll;
import com.sirhconnect.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollService {
    private final PayrollRepository repository;

    public PayrollService(PayrollRepository repository) {
        this.repository = repository;
    }

    public List<Payroll> findAll() {
        return repository.findAll();
    }

    public Payroll calculate(Payroll payroll) {
        payroll.setAmount(payroll.getWorkedDays() * 100.0);
        return repository.save(payroll);
    }
}
