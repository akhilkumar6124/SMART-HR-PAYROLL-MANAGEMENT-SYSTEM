package com.hrms.payroll_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.payroll_service.model.Payroll;
import com.hrms.payroll_service.service.PayrollService;

@RestController
@RequestMapping("/api/payroll")
@CrossOrigin(origins = "*")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/generate")
    public Payroll generate(
            @RequestParam Long employeeId,
            @RequestParam String month,
            @RequestParam int year) {

        return payrollService.generatePayroll(employeeId, month, year);
    }
}
