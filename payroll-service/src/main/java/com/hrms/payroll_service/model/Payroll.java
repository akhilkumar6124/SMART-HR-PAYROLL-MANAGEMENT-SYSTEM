package com.hrms.payroll_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payroll {

    private Long employeeId;
    private String month;
    private int year;
    private double grossSalary;
    private double deductions;
    private double netSalary;

}
