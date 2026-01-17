package com.hrms.attendance_service.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.attendance_service.entity.Attendance;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployeeId(Long employeeId);
}
