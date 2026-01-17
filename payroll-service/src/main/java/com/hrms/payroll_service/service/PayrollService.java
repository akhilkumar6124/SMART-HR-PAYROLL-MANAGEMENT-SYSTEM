package com.hrms.payroll_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.payroll_service.model.Payroll;
import com.hrms.payroll_service.repository.PayrollJdbcRepository;

@Service
public class PayrollService {

    @Autowired
    private PayrollJdbcRepository jdbcRepo;

    public Payroll generatePayroll(Long employeeId, String month, int year) {

        double salary = jdbcRepo.getEmployeeSalary(employeeId);
        int absentDays = jdbcRepo.getAbsentDays(employeeId, month);

        double deduction = absentDays * (salary / 30);
        double netSalary = salary - deduction;

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(employeeId);
        payroll.setMonth(month);
        payroll.setYear(year);
        payroll.setGrossSalary(salary);
        payroll.setDeductions(deduction);
        payroll.setNetSalary(netSalary);

        jdbcRepo.savePayroll(payroll);
        return payroll;
    }
}
