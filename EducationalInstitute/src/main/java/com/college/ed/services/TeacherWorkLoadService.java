package com.college.ed.services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.exception_handling.ValidationException;
import com.college.ed.model.Routine;
import com.college.ed.model.Teacher;
import com.college.ed.repository.RoutineRepository;
import com.college.ed.repository.TeacherRepository;

@Service
public class TeacherWorkLoadService {

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public double calculateTotalWorkHours(LocalDate startDate, LocalDate endDate, String teacherName) {
        // Validate inputs

    	validateInput(startDate, endDate, teacherName);
    	
        // Finding teacher by name
        Teacher teacher = teacherRepository.findByTeacherName(teacherName);
        if (teacher == null) {
            throw new NotFoundException("Teacher not found");
        }

        // Query routines for the given teacher and date range
        List<Routine> routines = routineRepository.findByTeacherAndRoutineDateBetween(teacher, startDate, endDate);

        // Calculate total work hours
        double totalWorkHours = calculateTotalWorkHours(routines);

        return totalWorkHours;
    }
    
    private void validateInput(LocalDate startDate, LocalDate endDate, String teacherName) {
        if (startDate == null || endDate == null || teacherName == null) {
            throw new ValidationException("Input parameters cannot be null");
        }

        if (startDate.isAfter(endDate)) {
            throw new ValidationException("Start date must be before or equal to end date");
        }

    }

    private double calculateTotalWorkHours(List<Routine> routines) {
        double totalWorkHours = 0;

        for (Routine routine : routines) {
            totalWorkHours += calculateWorkHours(routine.getStartTime(), routine.getEndTime());
        }

        return totalWorkHours;
    }

    private double calculateWorkHours(LocalTime startTime, LocalTime endTime) {
    	// Calculate the duration between startTime and endTime
        Duration duration = Duration.between(startTime, endTime);

        // Convert the duration to hours as a double
        double workHours = duration.toMinutes() / 60.0;

        return workHours;
    }
}