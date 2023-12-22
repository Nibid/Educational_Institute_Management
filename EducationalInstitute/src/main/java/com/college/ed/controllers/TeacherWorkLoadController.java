package com.college.ed.controllers;

import java.time.LocalDate;
import java.util.Collections;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.college.ed.services.TeacherWorkLoadService;

@RestController
@RequestMapping("/api/teacher/workload")
public class TeacherWorkLoadController {

    @Autowired
    private TeacherWorkLoadService teacherWorkLoadService;

    @GetMapping
    public ResponseEntity<?> getTeacherWorkload(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam("teacherName") String teacherName) throws NotFoundException, ValidationException {
        try {
            double totalWorkHours = teacherWorkLoadService.calculateTotalWorkHours(startDate, endDate, teacherName);
            return ResponseEntity.ok(Collections.singletonMap("TotalWorkHours", totalWorkHours));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Internal Server Error"));
        }
    }
}
