package com.college.ed.controllers;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.ed.exception_handling.NotFoundException;
import com.college.ed.exception_handling.ValidationException;
import com.college.ed.services.GroupWorkLoadService;

@RestController
// Request API for Group WorkLoad
@RequestMapping("/api/group/workload")
public class GroupWorkLoadController {

    @Autowired
    private GroupWorkLoadService groupWorkLoadService;

    // Retrieving total working hours for specified group ID
    @GetMapping
    public ResponseEntity<?> getGroupWorkload(@RequestParam("groupID") int groupId) {
        try {
            double totalWorkHours = groupWorkLoadService.calculateTotalWorkHours(groupId);
            return ResponseEntity.ok(Collections.singletonMap("TotalWorkHours", totalWorkHours));
        } catch (ValidationException | NotFoundException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Internal Server Error"));
        }
    }
}
