package com.college.ed.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.ed.RoutineRequest;
import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.exception_handling.ValidationException;
import com.college.ed.model.Routine;
import com.college.ed.services.RoutineService;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {

    @Autowired
    private RoutineService routineService;

    @PostMapping
    public ResponseEntity<?> createRoutine(@RequestBody RoutineRequest routineRequest) {
        try {
            Long routineId = routineService.saveRoutine(routineRequest);
            return ResponseEntity.ok(Collections.singletonMap("RoutineID", routineId));
        } catch (ValidationException | NotFoundException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Internal Server Error"));
        }
    }
}
