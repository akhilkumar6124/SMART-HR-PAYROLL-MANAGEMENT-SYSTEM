package com.hrms.payroll_service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hrms.payroll_service.model.Payroll;
@Repository
public class PayrollJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double getEmployeeSalary(Long employeeId) {
        String sql = "SELECT salary FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, employeeId);
    }

    public int getAbsentDays(Long employeeId, String month) {
        String sql = """
            SELECT COUNT(*) FROM attendance
            WHERE employee_id = ?
            AND status = 'ABSENT'
        """;
        return jdbcTemplate.queryForObject(sql, Integer.class, employeeId);
    }

    public void savePayroll(Payroll payroll) {
        String sql = """
            INSERT INTO payroll (employee_id, month, year, gross_salary, deductions, net_salary)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(sql,
                payroll.getEmployeeId(),
                payroll.getMonth(),
                payroll.getYear(),
                payroll.getGrossSalary(),
                payroll.getDeductions(),
                payroll.getNetSalary()
        );
    }
}
