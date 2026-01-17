package com.hrms.attendance_service.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.List;
import com.hrms.attendance_service.entity.Attendance;
import com.hrms.attendance_service.repository.AttendanceRepository;


@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance markAttendance(Attendance attendance) {
        attendance.setAttendanceDate(LocalDate.now());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getByEmployee(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }
}
