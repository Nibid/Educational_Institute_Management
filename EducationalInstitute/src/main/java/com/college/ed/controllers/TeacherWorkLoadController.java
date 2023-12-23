package com.college.ed.controllers;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.exception_handling.ValidationException;
import com.college.ed.services.TeacherWorkLoadService;

@RestController
//Request API for Teacher WorkLoad
@RequestMapping("/api/teacher/workload")
public class TeacherWorkLoadController {

    @Autowired
    private TeacherWorkLoadService teacherWorkLoadService;

    // Retrieving total working hours for specified teacher in certain date range
    @GetMapping
    public ResponseEntity<?> getTeacherWorkload(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("teacherName") String teacherName) {
        try {
            double totalWorkHours = teacherWorkLoadService.calculateTotalWorkHours(startDate, endDate, teacherName);
            return ResponseEntity.ok(Collections.singletonMap("TotalWorkHours", totalWorkHours));
        } catch (ValidationException | NotFoundException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Internal Server Error"));
        }
    }
}
